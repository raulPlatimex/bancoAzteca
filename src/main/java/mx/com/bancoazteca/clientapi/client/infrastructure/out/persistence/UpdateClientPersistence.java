package mx.com.bancoazteca.clientapi.client.infrastructure.out.persistence;

import mx.com.bancoazteca.clientapi.client.application.port.out.UpdateClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.manager.JsonFileManager;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.mapper.PersistenceMapper;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.FileStructure;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UpdateClientPersistence implements UpdateClientPort {

    private final JsonFileManager jsonFileManager;
    private final PersistenceMapper persistenceMapper;

    public UpdateClientPersistence(
            JsonFileManager jsonFileManager,
            PersistenceMapper persistenceMapper
    ) {
        this.jsonFileManager = jsonFileManager;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public Client update(Client client) {
        FileStructure fileStructure = jsonFileManager.loadDataFromFile();
        fileStructure.setData(
                fileStructure.getData().stream()
                        .filter(clientData -> clientData.getId() != client.getId())
                        .collect(Collectors.toList())
        );
        fileStructure.getData().add(persistenceMapper.map(client));
        jsonFileManager.writeDataToFile(fileStructure);
        return client;
    }

}
