package com.matheusamiranda.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String Nome;

    public Categoria(){
    }

    public Categoria(int id, String nome) {
        this.id = id;
        Nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return getId() == categoria.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
