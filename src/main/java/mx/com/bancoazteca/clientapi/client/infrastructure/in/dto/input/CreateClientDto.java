package mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.input;

import lombok.Getter;
import lombok.Setter;
import mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.input.constant.DtoConstant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateClientDto {

    @NotBlank(message = DtoConstant.EMPTY_NAME_ERROR_MESSAGE)
    private String name;
    @NotBlank(message = DtoConstant.EMPTY_EMAIL_ERROR_MESSAGE)
    @Email(message = DtoConstant.NOT_EMAIL_ERROR_MESSAGE)
    private String email;

}
