package mx.com.bancoazteca.clientapi.client.application.port.in.usecase;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.CreateClientRequest;
import mx.com.bancoazteca.clientapi.client.domain.Client;

public interface CreateClientUseCase {

    Client create(CreateClientRequest createClientRequest);

}
