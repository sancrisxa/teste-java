package sancrisxa.com.br.testejava.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPedido;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCadastro;
    @NotEmpty
    private String nome;
    @Column(unique=true)
    @NotNull
    private Integer numeroControle;
    private Integer quantidade;
    @NotNull
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;

    @NotNull
    private BigDecimal valorTotal;

    public Pedido() {
    }

    public Pedido(Integer codigoPedido, LocalDateTime dataCadastro, String nome, Integer numeroControle, Integer quantidade, BigDecimal valor, Cliente cliente, BigDecimal valorTotal) {
        this.codigoPedido = codigoPedido;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.numeroControle = numeroControle;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
