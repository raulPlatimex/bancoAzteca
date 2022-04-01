package mx.com.bancoazteca.clientapi.client.infrastructure.out.persistence;

import mx.com.bancoazteca.clientapi.client.application.port.out.ReadClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.manager.JsonFileManager;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.mapper.PersistenceMapper;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.FileStructure;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReadClientPersistence implements ReadClientPort {

    private final JsonFileManager jsonFileManager;
    private final PersistenceMapper persistenceMapper;

    public ReadClientPersistence(
            JsonFileManager jsonFileManager,
            PersistenceMapper persistenceMapper
    ) {
        this.jsonFileManager = jsonFileManager;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public List<Client> readAll() {
        FileStructure fileStructure = jsonFileManager.loadDataFromFile();
        return persistenceMapper.map(fileStructure.getData());
    }

    @Override
    public Client read(int clientId) {
        FileStructure fileStructure = jsonFileManager.loadDataFromFile();
        return persistenceMapper.map(fileStructure.getData().stream()
                .filter(clientData -> clientData.getId() == clientId)
                .findFirst()
                .orElse(null)
        );
    }

}
