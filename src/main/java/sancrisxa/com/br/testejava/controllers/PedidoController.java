package sancrisxa.com.br.testejava.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sancrisxa.com.br.testejava.dtos.PedidoDto;
import sancrisxa.com.br.testejava.services.PedidoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<List<PedidoDto>> createPedido(@Valid @RequestBody List<PedidoDto> pedidoListDto) {

        List<PedidoDto> pedidoListDtoCreated = this.pedidoService.savePedido(pedidoListDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoListDto);
    }
}
