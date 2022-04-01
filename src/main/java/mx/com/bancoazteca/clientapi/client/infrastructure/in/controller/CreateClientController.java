package mx.com.bancoazteca.clientapi.client.infrastructure.in.controller;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.CreateClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.CreateClientUseCase;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.input.CreateClientDto;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.output.ClientDto;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.mapper.ControllerMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class CreateClientController {

    private final CreateClientUseCase createClientUseCase;
    private final ControllerMapper controllerMapper;

    public CreateClientController(CreateClientUseCase createClientUseCase, ControllerMapper controllerMapper) {
        this.createClientUseCase = createClientUseCase;
        this.controllerMapper = controllerMapper;
    }

    @PostMapping()
    ResponseEntity<ClientDto> createClient(@Valid @RequestBody CreateClientDto createClientDto) {
        CreateClientRequest createClientRequest = new CreateClientRequest(createClientDto.getName(), createClientDto.getEmail());
        Client client = createClientUseCase.create(createClientRequest);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(controllerMapper.map(client), HttpStatus.CREATED);
    }

}
