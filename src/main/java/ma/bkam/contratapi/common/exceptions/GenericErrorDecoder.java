package ma.bkam.contratapi.common.exceptions;

import com.google.gson.Gson;
import feign.Response;
import feign.codec.ErrorDecoder;
import ma.bkam.contratapi.common.exceptions.model.IGenericError;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

import static ma.bkam.contratapi.common.utils.Constants.GENERIC_EXCEPTION;

@Component
public class GenericErrorDecoder implements ErrorDecoder {


    private Class<? extends IGenericError> clientResponseClazz;


    public void setClientResponseClazz(Class<? extends IGenericError> clazz) {
        this.clientResponseClazz = clazz;
    }

    @Override
    public Exception decode(String methodKey, Response response) {

        String error = null;
        InputStream bodyStream = null;
        try {
            bodyStream = response.body().asInputStream();

            if (bodyStream != null) {
                error = IOUtils.toString(bodyStream);
                error = new Gson().fromJson(error, clientResponseClazz).getError();
            }
        } catch (IOException e) {
            error = GENERIC_EXCEPTION;
        }

        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        return new BaseContratApiExceptions(responseStatus.value(), error);
    }
}


