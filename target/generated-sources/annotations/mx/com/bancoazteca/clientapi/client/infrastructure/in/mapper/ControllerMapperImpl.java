package mx.com.bancoazteca.clientapi.client.infrastructure.in.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.output.ClientDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T18:17:10-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ControllerMapperImpl implements ControllerMapper {

    @Override
    public ClientDto map(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setEmail( client.getEmail() );

        return clientDto;
    }

    @Override
    public List<ClientDto> map(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( map( client ) );
        }

        return list;
    }
}
