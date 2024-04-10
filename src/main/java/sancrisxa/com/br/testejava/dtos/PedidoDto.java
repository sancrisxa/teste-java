package sancrisxa.com.br.testejava.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PedidoDto {
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

    public PedidoDto() {
    }

    public PedidoDto(Integer codigoCliente, LocalDateTime dataCadastro, String nome, Integer numeroControle, Integer quantidade, BigDecimal valor) {
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

    public LocalDateTime getData_cadastro() {
        return dataCadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.dataCadastro = data_cadastro;
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
