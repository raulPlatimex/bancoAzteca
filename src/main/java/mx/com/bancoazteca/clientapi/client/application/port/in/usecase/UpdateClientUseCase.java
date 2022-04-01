package mx.com.bancoazteca.clientapi.client.application.port.in.usecase;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.UpdateClientRequest;
import mx.com.bancoazteca.clientapi.client.domain.Client;

public interface UpdateClientUseCase {

    Client update(UpdateClientRequest updateClientRequest);

}
