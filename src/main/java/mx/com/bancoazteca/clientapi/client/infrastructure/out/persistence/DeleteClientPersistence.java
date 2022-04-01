package mx.com.bancoazteca.clientapi.client.infrastructure.out.persistence;

import mx.com.bancoazteca.clientapi.client.application.port.out.DeleteClientPort;
import mx.com.bancoazteca.clientapi.client.domain.Client;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.manager.JsonFileManager;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.FileStructure;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DeleteClientPersistence implements DeleteClientPort {

    private final JsonFileManager jsonFileManager;

    public DeleteClientPersistence(JsonFileManager jsonFileManager) {
        this.jsonFileManager = jsonFileManager;
    }

    @Override
    public boolean delete(Client client) {
        FileStructure fileStructure = jsonFileManager.loadDataFromFile();
        fileStructure.setData(
                fileStructure.getData().stream()
                        .filter(clientData -> clientData.getId() != client.getId())
                        .collect(Collectors.toList())
        );
        jsonFileManager.writeDataToFile(fileStructure);
        return true;
    }
}
