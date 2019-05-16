package br.com.munif.openprojects.conta.domain.localizacao;

import org.hibernate.envers.Audited;
import br.com.munif.framework.vicente.domain.BaseEntity;
import br.com.munif.framework.vicente.domain.BaseEntityHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Pais.
 */
@Entity
@Table(name = "pais")
@Audited
public class Pais extends BaseEntity {

    @Column(name = "nome")
    private String nome;

    public Pais() {

    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public String toString() {
        return super.toString()
                + ", nome='" + getNome() + "'"
                + "}";
    }
}
