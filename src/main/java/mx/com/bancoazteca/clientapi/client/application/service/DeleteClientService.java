package mx.com.bancoazteca.clientapi.client.application.service;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.DeleteClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.DeleteClientUseCase;
import mx.com.bancoazteca.clientapi.client.application.port.out.DeleteClientPort;
import mx.com.bancoazteca.clientapi.client.application.port.out.ReadClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientService implements DeleteClientUseCase {

    private final DeleteClientPort deleteClientPort;
    private final ReadClientPort readClientPort;

    public DeleteClientService(
            DeleteClientPort deleteClientPort,
            ReadClientPort readClientPort
    ) {
        this.deleteClientPort = deleteClientPort;
        this.readClientPort = readClientPort;
    }

    @Override
    public boolean delete(DeleteClientRequest deleteClientRequest) {
        Client client = readClientPort.read(deleteClientRequest.getId());
        if (client == null) {
            return false;
        }
        return deleteClientPort.delete(client);
    }

}
