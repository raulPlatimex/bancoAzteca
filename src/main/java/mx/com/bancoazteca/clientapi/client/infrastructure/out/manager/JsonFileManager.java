package mx.com.bancoazteca.clientapi.client.infrastructure.out.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.bancoazteca.clientapi.client.infrastructure.out.model.FileStructure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JsonFileManager {

    private final Path fileLocation;
    private final ObjectMapper objectMapper;

    public JsonFileManager(
            @Value("${bancoazteca.file.location}") String fileLocation,
            ObjectMapper objectMapper
    ) {
        this.fileLocation = Paths.get(fileLocation);
        this.objectMapper = objectMapper;
    }

    public FileStructure loadDataFromFile() {
        try {
            BufferedReader file = Files.newBufferedReader(fileLocation);
            return objectMapper.readValue(file, FileStructure.class);
        } catch (IOException e) {
            return null;
        }
    }

    public void  writeDataToFile(FileStructure fileStructure) {
        try {
            String data = objectMapper.writeValueAsString(fileStructure);
            Files.write(fileLocation, data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {

        }

    }

}
