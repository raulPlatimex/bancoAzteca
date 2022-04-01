package mx.com.bancoazteca.clientapi.client.infrastructure.in.controller;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.DeleteClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.DeleteClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class DeleteClientController {

    private final DeleteClientUseCase deleteClientUseCase;

    public DeleteClientController(DeleteClientUseCase deleteClientUseCase) {
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @DeleteMapping("/{clientId}")
    ResponseEntity deleteClient(@PathVariable int clientId) {
        DeleteClientRequest deleteClientRequest = new DeleteClientRequest(clientId);
        if(deleteClientUseCase.delete(deleteClientRequest)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
