package sancrisxa.com.br.testejava.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.services.PedidoService;

import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDto> createPedido(@Valid @RequestBody PedidoDto pedidoDto) {

        PedidoDto pedidoDtoCreated = this.pedidoService.savePedido(pedidoDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoDtoCreated.getCodigoCliente()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
