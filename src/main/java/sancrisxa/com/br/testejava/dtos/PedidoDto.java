package sancrisxa.com.br.testejava.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import sancrisxa.com.br.testejava.models.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PedidoDto {
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

    @NotNull
    private ClienteDto clienteDto;

    private BigDecimal valorTotal;

    public PedidoDto() {
    }

    public PedidoDto(Integer codigoPedido, LocalDateTime dataCadastro, String nome, Integer numeroControle, Integer quantidade, BigDecimal valor, ClienteDto clienteDto, BigDecimal valorTotal) {
        this.codigoPedido = codigoPedido;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.numeroControle = numeroControle;
        this.quantidade = quantidade;
        this.valor = valor;
        this.clienteDto = clienteDto;
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

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
