package co.com.employee.service.faceId.common.ex;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasketException extends RuntimeException {
    private String code;
    private String message;
    private HttpStatus httpStatus;

    public BasketException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
