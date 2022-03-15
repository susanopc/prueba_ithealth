package com.ithealth.susano.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ithealth.susano.constant.Sexo;
import com.ithealth.susano.constant.TipoDocumento;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id")
    private Long id;
    
    @Column(name = "primer_nombre")
    private String primerNombre;
    
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    
    @Column(name = "primer_apellido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;    
    
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @Column(name = "tipo_documento")
    private TipoDocumento tipoDocumento;
    
    @Column(name = "documento")
    private String documento;
    
    @Column(name = "sexo")
    private Sexo sexo;
    
    @Column(name = "direccion")
    private String direccion;

    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getNombreCompleto(){
        return primerNombre + " " +
            (segundoNombre == null || segundoNombre.isEmpty() ? "" : segundoNombre + " ") +
            primerApellido +
            (segundoApellido == null || segundoApellido.isEmpty() ? "" : " " + segundoApellido);
    }
    
    public String getDescripcionTipoDocumento() {
        return tipoDocumento.getDescripcion();
    }
    
    public String getDescripcionSexo() {
        return sexo.getDescripcion();
    }
    
    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", fechaNacimiento=" + fechaNacimiento + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", sexo=" + sexo + ", direccion=" + direccion + '}';
    }
    
}
