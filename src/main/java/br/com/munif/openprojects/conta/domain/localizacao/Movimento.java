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
@Table(name = "movimento")
@Audited
public class Movimento extends BaseEntity {

    @ManyToOne
    private Conta contaOrigem;

    @ManyToOne
    private Conta contaDestino;

    private BigDecimal valor = BigDecimal.ZERO;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date momentoMovimento;

    public Movimento() {

    }

    public Movimento(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor=valor;
        momentoMovimento = new Date();
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getMomentoMovimento() {
        return momentoMovimento;
    }

    public void setMomentoMovimento(Date momentoMovimento) {
        this.momentoMovimento = momentoMovimento;
    }

    @Override
    public String toString() {
        return "Movimento{" + "contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + ", valor=" + valor + ", momentoMovimento=" + momentoMovimento + '}';
    }

}
