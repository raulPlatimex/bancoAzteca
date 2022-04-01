package mx.com.bancoazteca.clientapi.client.infrastructure.out.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FileStructure {

    private Metadata metadata;
    private List<ClientData> data;

}
