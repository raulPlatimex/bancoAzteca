package mx.com.bancoazteca.clientapi.client.application.service;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.UpdateClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.UpdateClientUseCase;
import mx.com.bancoazteca.clientapi.client.application.port.out.ReadClientPort;
import mx.com.bancoazteca.clientapi.client.application.port.out.UpdateClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientService implements UpdateClientUseCase {

    private final ReadClientPort readClientPort;
    private final UpdateClientPort updateClientPort;

    public UpdateClientService(
            ReadClientPort readClientPort,
            UpdateClientPort updateClientPort
    ) {
        this.readClientPort = readClientPort;
        this.updateClientPort = updateClientPort;
    }

    @Override
    public Client update(UpdateClientRequest updateClientRequest) {
        Client client = readClientPort.read(updateClientRequest.getId());
        if (client == null) {
            return null;
        }
        client.setName(updateClientRequest.getName());
        client.setEmail(updateClientRequest.getEmail());
        return updateClientPort.update(client);
    }

}
