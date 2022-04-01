package mx.com.bancoazteca.clientapi.client.infrastructure.out.persistence;

import mx.com.bancoazteca.clientapi.client.application.port.out.CreateClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.manager.JsonFileManager;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.mapper.PersistenceMapper;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.FileStructure;
import org.springframework.stereotype.Component;

@Component
public class CreateClientPersistence implements CreateClientPort {

    private final JsonFileManager jsonFileManager;
    private final PersistenceMapper persistenceMapper;

    public CreateClientPersistence(
            JsonFileManager jsonFileManager,
            PersistenceMapper persistenceMapper
    ) {
        this.jsonFileManager = jsonFileManager;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public Client create(Client client) {
        FileStructure fileStructure = jsonFileManager.loadDataFromFile();
        int nextVal = fileStructure.getMetadata().getNextVal();
        fileStructure.getMetadata().setNextVal(nextVal + fileStructure.getMetadata().getStep());
        client.setId(nextVal);
        fileStructure.getData().add(persistenceMapper.map(client));
        jsonFileManager.writeDataToFile(fileStructure);
        return client;
    }

}
