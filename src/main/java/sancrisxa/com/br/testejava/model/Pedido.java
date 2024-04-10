package sancrisxa.com.br.testejava.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCliente;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime data_cadastro;
    @NotEmpty
    private String nome;
    @NotEmpty
    private Integer númeroControle;
    private Integer quantidade;
    @NotEmpty
    private BigDecimal valor;
}
