package mx.com.bancoazteca.clientapi.client.infrastructure.out.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.ClientData;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T18:17:10-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class PersistenceMapperImpl implements PersistenceMapper {

    @Override
    public Client map(ClientData clientData) {
        if ( clientData == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientData.getId() );
        client.setName( clientData.getName() );
        client.setEmail( clientData.getEmail() );

        return client;
    }

    @Override
    public ClientData map(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientData clientData = new ClientData();

        clientData.setId( client.getId() );
        clientData.setName( client.getName() );
        clientData.setEmail( client.getEmail() );

        return clientData;
    }

    @Override
    public List<Client> map(List<ClientData> clientDataList) {
        if ( clientDataList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDataList.size() );
        for ( ClientData clientData : clientDataList ) {
            list.add( map( clientData ) );
        }

        return list;
    }
}
