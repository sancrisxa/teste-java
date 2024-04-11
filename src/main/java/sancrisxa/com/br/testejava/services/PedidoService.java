package sancrisxa.com.br.testejava.services;

import sancrisxa.com.br.testejava.dtos.PedidoDto;

import java.util.List;

public interface PedidoService {
    List<PedidoDto> savePedido(List<PedidoDto> pedidoListDto);
}
