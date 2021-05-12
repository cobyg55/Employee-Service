package co.com.employee.service.faceId.core.config;

import co.com.employee.service.faceId.common.ex.BasketException;
import co.com.employee.service.faceId.common.ex.ErrorCodes;
import co.com.employee.service.faceId.common.ex.ErrorMessages;
import co.com.employee.service.faceId.common.response.ApiResponse;
import co.com.employee.service.faceId.core.service.MessageService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Autowired
    private MessageService messageService;

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            try {
                Reader reader = response.body().asReader(Charset.defaultCharset());
                String result = CharStreams.toString(reader);
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                ApiResponse apiError = mapper.readValue(result, ApiResponse.class);
                return new BasketException(ErrorCodes.VALIDATION, apiError.getMessage(), HttpStatus.BAD_REQUEST);
            } catch (IOException e) {
                return new BasketException(ErrorCodes.UNKNOWN, messageService.getMessage(ErrorMessages.UNKNOWN_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new BasketException(ErrorCodes.UNKNOWN, messageService.getMessage(ErrorMessages.UNKNOWN_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
