package sancrisxa.com.br.testejava.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCliente;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCadastro;
    @NotEmpty
    private String nome;
    @NotNull
    private Integer numeroControle;
    private Integer quantidade;
    @NotNull
    private BigDecimal valor;

    public Pedido() {
    }

    public Pedido(Integer codigoCliente, LocalDateTime dataCadastro, String nome, Integer numeroControle, Integer quantidade, BigDecimal valor) {
        this.codigoCliente = codigoCliente;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.numeroControle = numeroControle;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(Integer numeroControle) {
        this.numeroControle = numeroControle;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
