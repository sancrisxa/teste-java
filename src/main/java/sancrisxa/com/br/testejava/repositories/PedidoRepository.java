package sancrisxa.com.br.testejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sancrisxa.com.br.testejava.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
