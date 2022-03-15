package com.ithealth.susano.constant;

public enum TipoDocumento {    
    
    CEDULA("Cedula de ciudadanía"),
    TARJETA("Tarjeta de identidad"),
    REGISTRO("Registro civil de nacimiento"),
    EXTRANJERIA("Cedula de extranjería");
    
    private final String descripcion;
    
    private TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
