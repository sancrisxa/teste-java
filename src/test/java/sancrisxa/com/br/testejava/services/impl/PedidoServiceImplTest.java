package sancrisxa.com.br.testejava.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.repositories.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PedidoServiceImplTest {

    @InjectMocks
    PedidoServiceImpl pedidoServiceImpl;

    @Mock
    PedidoRepository pedidoRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    @DisplayName("Verifica se um pedido está salvo e os seus campos")
    void savePedidoTest() {

        LocalDateTime now = LocalDateTime.now();

        PedidoDto pedidoDto = new PedidoDto(123, now, "nome", 123, 2, new BigDecimal("0.2"));
        Pedido pedido = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"));
        Pedido pedidoSaved = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"));

        when(this.modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
        when(this.pedidoRepository.save(pedido)).thenReturn(pedidoSaved);
        when(this.modelMapper.map(pedidoSaved, PedidoDto.class)).thenReturn(pedidoDto);

        PedidoDto pedidoDtoReturned = this.pedidoServiceImpl.savePedido(pedidoDto);

        assertEquals(123, pedidoDtoReturned.getCodigoCliente());
        assertEquals(now, pedidoDtoReturned.getDataCadastro());
        assertEquals(123, pedidoDtoReturned.getNumeroControle());
        assertEquals(2, pedidoDtoReturned.getQuantidade());
        assertEquals(new BigDecimal("0.2"), pedidoDtoReturned.getValor());
    }
}