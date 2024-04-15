package sancrisxa.com.br.testejava.services.spec;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.models.Pedido;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoSpecification {
    public Specification<Pedido> pedidos(PedidoDto pedidoDto) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (!ObjectUtils.isEmpty(pedidoDto.getCodigoPedido())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("codigoPedido"), pedidoDto.getCodigoPedido())
                );
            }

            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }
}
