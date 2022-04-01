package mx.com.bancoazteca.clientapi.client.application.port.out;

import mx.com.bancoazteca.clientapi.client.domain.Client;

public interface DeleteClientPort {

    boolean delete(Client client);

}
