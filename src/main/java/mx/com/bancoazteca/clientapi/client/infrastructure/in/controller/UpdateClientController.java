package mx.com.bancoazteca.clientapi.client.infrastructure.in.controller;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.UpdateClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.UpdateClientUseCase;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.input.UpdateClientDto;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.output.ClientDto;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.mapper.ControllerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class UpdateClientController {

    private final UpdateClientUseCase updateClientUseCase;
    private final ControllerMapper controllerMapper;

    public UpdateClientController(UpdateClientUseCase updateClientUseCase, ControllerMapper controllerMapper) {
        this.updateClientUseCase = updateClientUseCase;
        this.controllerMapper = controllerMapper;
    }

    @PutMapping("/{clientId}")
    ResponseEntity<ClientDto> updateClient(@PathVariable int clientId, @Valid @RequestBody UpdateClientDto updateClientDto) {
        UpdateClientRequest updateClientRequest = new UpdateClientRequest(clientId, updateClientDto.getName(), updateClientDto.getEmail());
        Client client = updateClientUseCase.update(updateClientRequest);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(controllerMapper.map(client), HttpStatus.OK);
    }

}
