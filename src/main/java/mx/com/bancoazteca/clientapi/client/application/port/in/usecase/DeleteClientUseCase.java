package mx.com.bancoazteca.clientapi.client.application.port.in.usecase;

import mx.com.bancoazteca.clientapi.client.application.port.in.request.DeleteClientRequest;

public interface DeleteClientUseCase {

    boolean delete(DeleteClientRequest deleteClientRequest);

}
