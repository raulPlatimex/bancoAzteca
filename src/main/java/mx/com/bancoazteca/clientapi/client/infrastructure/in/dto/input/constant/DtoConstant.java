package mx.com.bancoazteca.clientapi.client.infrastructure.in.dto.input.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DtoConstant {

    public static final String NOT_EMAIL_ERROR_MESSAGE = "field email is not a valid email";
    public static final String EMPTY_NAME_ERROR_MESSAGE = "field name is not defined";
    public static final String EMPTY_EMAIL_ERROR_MESSAGE = "field email is not defined";

}
