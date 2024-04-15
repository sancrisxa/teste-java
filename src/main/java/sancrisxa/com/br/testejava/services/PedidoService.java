package sancrisxa.com.br.testejava.services;

import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.services.spec.PedidoSpecification;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PedidoService {
    List<PedidoDto> savePedido(List<PedidoDto> pedidoListDto);

    List<PedidoDto> buscarPedidos();

    List<PedidoDto> buscarPedidos(PedidoDto pedidoDto, Pageable pageable);
}
