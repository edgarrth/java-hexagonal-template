package com.poc.microservice.demo.domain.base;

public abstract class Domain {
    protected Long id;
    protected String estado;

    public Domain() {
        super();
    }

    public Domain(Long id, String estado) {
        super();
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
