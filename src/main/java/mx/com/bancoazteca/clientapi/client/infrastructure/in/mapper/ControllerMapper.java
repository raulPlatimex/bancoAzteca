package mx.com.bancoazteca.clientapi.client.infrastructure.in.mapper;

import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.output.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControllerMapper {

    ClientDto map(Client client);
    List<ClientDto> map(List<Client> clients);

}
