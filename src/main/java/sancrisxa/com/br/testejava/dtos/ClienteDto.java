package sancrisxa.com.br.testejava.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ClienteDto {
    @NotNull
    private Integer codigoCliente;
    private String nome;

    public ClienteDto() {
    }

    public ClienteDto(Integer codigoCliente, String nome) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
