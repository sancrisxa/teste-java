package sancrisxa.com.br.testejava.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sancrisxa.com.br.testejava.dtos.ClienteDto;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Cliente;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.repositories.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        ClienteDto clienteDto = new ClienteDto(1, "nome");
        Cliente cliente = new Cliente(1, "nome");

        PedidoDto pedidoDto = new PedidoDto(123, now, "nome", 123, 2, new BigDecimal("0.2"), clienteDto, new BigDecimal("10.2"));
        Pedido pedido = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"), cliente, new BigDecimal("10.2"));
        Pedido pedidoSaved = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"), cliente, new BigDecimal("10.2"));

        List<Pedido> pedidoListSaved = new ArrayList<>();
        pedidoListSaved.add(pedidoSaved);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido);

        List<PedidoDto> pedidoDtoList = new ArrayList<>();
        pedidoDtoList.add(pedidoDto);

        when(this.modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
        when(this.pedidoRepository.saveAll(pedidoList)).thenReturn(pedidoListSaved);
        when(this.modelMapper.map(pedidoSaved, PedidoDto.class)).thenReturn(pedidoDto);

        List<PedidoDto> pedidoDtoListReturned = this.pedidoServiceImpl.savePedido(pedidoDtoList);

        assertEquals(123, pedidoDtoListReturned.get(0).getCodigoPedido());
        assertEquals(now, pedidoDtoListReturned.get(0).getDataCadastro());
        assertEquals(123, pedidoDtoListReturned.get(0).getNumeroControle());
        assertEquals(2, pedidoDtoListReturned.get(0).getQuantidade());
        assertEquals(new BigDecimal("0.2"), pedidoDtoListReturned.get(0).getValor());
    }
}