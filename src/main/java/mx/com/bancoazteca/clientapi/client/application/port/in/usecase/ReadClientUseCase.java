package mx.com.bancoazteca.clientapi.client.application.port.in.usecase;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.ReadClientRequest;
import mx.com.bancoazteca.clientapi.client.domain.Client;

import java.util.List;

public interface ReadClientUseCase {

    List<Client> readAll();
    Client read(ReadClientRequest readClientRequest);

}
