package sancrisxa.com.br.testejava.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.services.PedidoService;
import sancrisxa.com.br.testejava.services.spec.PedidoSpecification;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<List<PedidoDto>> createPedido(@Valid @RequestBody List<PedidoDto> pedidoListDto) {

        List<PedidoDto> pedidoListDtoCreated = this.pedidoService.savePedido(pedidoListDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoListDtoCreated);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> buscarPedidos(PedidoDto pedidoDto, Pageable pageable) {

        List<PedidoDto> pedidoListDtoCreated = this.pedidoService.buscarPedidos(pedidoDto, pageable);

        return ResponseEntity.ok().body(pedidoListDtoCreated);
    }
}
