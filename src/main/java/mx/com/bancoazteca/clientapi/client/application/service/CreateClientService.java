package mx.com.bancoazteca.clientapi.client.application.service;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.CreateClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.CreateClientUseCase;
import mx.com.bancoazteca.clientapi.client.application.port.out.CreateClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class CreateClientService implements CreateClientUseCase {

    private final CreateClientPort createClientPort;

    public CreateClientService(CreateClientPort createClientPort) {
        this.createClientPort = createClientPort;
    }

    @Override
    public Client create(CreateClientRequest createClientRequest) {
        Client client = new Client();
        client.setName(createClientRequest.getName());
        client.setEmail(createClientRequest.getEmail());
        return createClientPort.create(client);
    }

}
