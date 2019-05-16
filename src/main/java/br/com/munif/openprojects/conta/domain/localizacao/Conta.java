package br.com.munif.openprojects.conta.domain.localizacao;

import org.hibernate.envers.Audited;
import br.com.munif.framework.vicente.domain.BaseEntity;
import br.com.munif.framework.vicente.domain.BaseEntityHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * A Pais.
 */
@Entity
@Table(name = "conta")
@Audited
public class Conta extends BaseEntity {

    @Column(name = "nome")
    private String nome;

    private BigDecimal saldo=BigDecimal.valueOf(1000);
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date momentoSaldo;

    public Conta() {

    }

    public Conta(String nome) {
        this.nome = nome;
        momentoSaldo=new Date();
    }

    public String getNome() {
        return nome;
    }

    public Conta nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getMomentoSaldo() {
        return momentoSaldo;
    }

    public void setMomentoSaldo(Date momentoSaldo) {
        this.momentoSaldo = momentoSaldo;
    }
    
    
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public String toString() {
        return super.toString()
                + ", nome='" + getNome() + "'"
                + "}";
    }
}
