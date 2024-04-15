package sancrisxa.com.br.testejava.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sancrisxa.com.br.testejava.Exceptions.customs.PedidoMaximoExcedidoException;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Cliente;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.repositories.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    LocalDateTime now;
    Cliente cliente;
    PedidoDto pedidoDto;
    Pedido pedido;
    Pedido pedidoSaved;
    List<Pedido> pedidoListSaved = new ArrayList<>();
    List<Pedido> pedidoList = new ArrayList<>();
    List<PedidoDto> pedidoDtoList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        now = LocalDateTime.now();
        cliente = new Cliente(1, "nome");

        pedidoDto = new PedidoDto(123, now, "nome", 123, 2, new BigDecimal("0.2"), cliente, new BigDecimal("10.2"));
        pedido = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"), cliente, new BigDecimal("10.2"));
        pedidoSaved = new Pedido(123, now, "nome", 123, 2, new BigDecimal("0.2"), cliente, new BigDecimal("10.2"));

        pedidoListSaved.add(pedidoSaved);
        pedidoList.add(pedido);
        pedidoDtoList.add(pedidoDto);
    }

    @Test
    @DisplayName("Verifica se um pedido está salvo e os seus campos")
    void savePedidoTest() {


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

    @Test
    @DisplayName("Verifica se um pedido está salvo com data null e quantidade zero")
    void savePedidoDataNullQtdZeroTest() {
        pedidoSaved.setDataCadastro(null);
        pedido.setDataCadastro(null);
        pedidoDto.setDataCadastro(null);

        pedidoSaved.setQuantidade(0);
        pedido.setQuantidade(0);
        pedidoDto.setQuantidade(0);


        when(this.modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
        when(this.pedidoRepository.saveAll(pedidoList)).thenReturn(pedidoListSaved);
        when(this.modelMapper.map(pedidoSaved, PedidoDto.class)).thenReturn(pedidoDto);

        List<PedidoDto> pedidoDtoListReturned = this.pedidoServiceImpl.savePedido(pedidoDtoList);

        assertEquals(123, pedidoDtoListReturned.get(0).getCodigoPedido());
        assertEquals(123, pedidoDtoListReturned.get(0).getNumeroControle());
        assertEquals(1, pedidoDtoListReturned.get(0).getQuantidade());
        assertEquals(new BigDecimal("0.2"), pedidoDtoListReturned.get(0).getValor());
    }

    @Test
    void buscarPedidos() {

        when(this.modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
        when(this.pedidoRepository.findAll()).thenReturn(pedidoList);

        List<PedidoDto> pedidoDtoListReturned = this.pedidoServiceImpl.buscarPedidos();

        assertNotNull(pedidoDtoListReturned);
    }

    @Test
    @DisplayName("Verifica o númrero de pedido excedido")
    void savePedidoTestException() {

        for (int i = 0; i < 12; i++) {
            pedidoListSaved.add(pedidoSaved);
            pedidoList.add(pedido);
            pedidoDtoList.add(pedidoDto);
        }

        when(this.pedidoRepository.saveAll(pedidoList)).thenThrow(PedidoMaximoExcedidoException.class);
        assertThrows(PedidoMaximoExcedidoException.class, () -> this.pedidoServiceImpl.savePedido(pedidoDtoList));
    }
}