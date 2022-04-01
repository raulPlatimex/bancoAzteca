package mx.com.bancoazteca.clientapi.client.application.port.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateClientRequest {

    private int id;
    private String name;
    private String email;

}
