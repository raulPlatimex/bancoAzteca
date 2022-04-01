package mx.com.bancoazteca.clientapi.client.infrastructure.in.controller;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.ReadClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.ReadClientUseCase;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.output.ClientDto;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.mapper.ControllerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ReadClientController {

    private final ReadClientUseCase readClientUseCase;
    private final ControllerMapper controllerMapper;

    public ReadClientController(
            ReadClientUseCase readClientUseCase,
            ControllerMapper controllerMapper
    ) {
        this.readClientUseCase = readClientUseCase;
        this.controllerMapper = controllerMapper;
    }

    @GetMapping()
    List<ClientDto> readClients(){
        return controllerMapper.map(readClientUseCase.readAll());
    }

    @GetMapping("/{clientId}")
    ResponseEntity<ClientDto> readClient(@PathVariable Integer clientId) {
        ReadClientRequest readClientRequest = new ReadClientRequest(clientId);
        Client client = readClientUseCase.read(readClientRequest);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(controllerMapper.map(client), HttpStatus.OK);
    }

}
