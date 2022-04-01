package mx.com.bancoazteca.clientapi.client.application.port.out;

import mx.com.bancoazteca.clientapi.client.domain.Client;

import java.util.List;

public interface ReadClientPort {

    List<Client> readAll();
    Client read(int clientId);

}
