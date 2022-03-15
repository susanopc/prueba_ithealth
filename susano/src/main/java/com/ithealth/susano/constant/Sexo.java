package com.ithealth.susano.constant;

public enum Sexo {

    M("Masculino"),
    F("Femeninoo"),
    O("Otro");
    
    private final String descripcion;
    
    private Sexo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
