package ma.bkam.contratapi.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputsException extends BaseContratApiExceptions{



    public InvalidInputsException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);

    }
}
