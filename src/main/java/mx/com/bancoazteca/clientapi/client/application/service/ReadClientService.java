package mx.com.bancoazteca.clientapi.client.application.service;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.ReadClientRequest;
import mx.com.bancoazteca.clientapi.client.application.port.in.usecase.ReadClientUseCase;
import mx.com.bancoazteca.clientapi.client.application.port.out.ReadClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadClientService implements ReadClientUseCase {

    private final ReadClientPort readClientPort;

    public ReadClientService(ReadClientPort readClientPort) {
        this.readClientPort = readClientPort;
    }

    @Override
    public List<Client> readAll() {
        return readClientPort.readAll();
    }

    @Override
    public Client read(ReadClientRequest readClientRequest) {
        return readClientPort.read(readClientRequest.getId());
    }

}
