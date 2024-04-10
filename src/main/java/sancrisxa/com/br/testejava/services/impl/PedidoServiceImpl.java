package sancrisxa.com.br.testejava.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.repositories.PedidoRepository;
import sancrisxa.com.br.testejava.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoDto savePedido(PedidoDto pedidoDto) {

        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);
        Pedido pedidoSaved = this.pedidoRepository.save(pedido);

        return modelMapper.map(pedidoSaved, PedidoDto.class);
    }
}
