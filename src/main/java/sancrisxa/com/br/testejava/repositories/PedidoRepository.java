package sancrisxa.com.br.testejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sancrisxa.com.br.testejava.models.Pedido;
import sancrisxa.com.br.testejava.services.spec.PedidoSpecification;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, JpaSpecificationExecutor<Pedido> {

}
