package sancrisxa.com.br.testejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sancrisxa.com.br.testejava.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
