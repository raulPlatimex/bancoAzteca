package mx.com.bancoazteca.clientapi.client.infrastructure.out.mapper;

import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.ClientData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

    Client map(ClientData clientData);
    ClientData map(Client client);
    List<Client> map(List<ClientData> clientDataList);

}
