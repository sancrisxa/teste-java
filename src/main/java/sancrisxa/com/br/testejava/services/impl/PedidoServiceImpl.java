package sancrisxa.com.br.testejava.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sancrisxa.com.br.testejava.Exceptions.customs.PedidoMaximoExcedidoException;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.repositories.PedidoRepository;
import sancrisxa.com.br.testejava.services.PedidoService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PedidoDto> savePedido(List<PedidoDto> pedidoListDto) {

        LocalDateTime now = LocalDateTime.now();

        if (pedidoListDto.size() > 10) {
            throw new PedidoMaximoExcedidoException("Não pode ter mais de 10 pedidos.");
        }

        List<Pedido> pedidoList = pedidoListDto.stream().map(
                pedidoDto -> {
                    if (pedidoDto.getDataCadastro() == null) {
                        pedidoDto.setDataCadastro(now);
                    }

                    if (pedidoDto.getQuantidade() == null || pedidoDto.getQuantidade() <= 0 ) {
                        pedidoDto.setQuantidade(1);
                    }

                    BigDecimal valor = new BigDecimal(pedidoDto.getValor().toString());
                    BigDecimal qtd = new BigDecimal(pedidoDto.getQuantidade());
                    BigDecimal total = valor.multiply(qtd);

                    if (pedidoDto.getQuantidade() < 10 && pedidoDto.getQuantidade() > 5) {

                        total = total.subtract(total.multiply(new BigDecimal("0.05")));
                        pedidoDto.setValorTotal(total);
                    } else if (pedidoDto.getQuantidade() >= 10 ) {
                        total = total.subtract(total.multiply(new BigDecimal("0.10")));
                        pedidoDto.setValorTotal(total);
                    } else {
                        pedidoDto.setValorTotal(valor.multiply(qtd));
                    }



                    return modelMapper.map(pedidoDto, Pedido.class);
                }
        ).collect(Collectors.toList());


        List<Pedido> pedidoListSaved = this.pedidoRepository.saveAll(pedidoList);

        return pedidoListSaved.stream().map(
                pedido -> modelMapper.map(pedido, PedidoDto.class)
        ).collect(Collectors.toList());
    }
}
