package co.com.employee.service.faceId.app.handler;

import co.com.employee.service.faceId.common.ex.ApiError;
import co.com.employee.service.faceId.common.ex.BasketException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BasketExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BasketException.class)
    public ResponseEntity<ApiError> exceptionHandler(BasketException ex) {
        ApiError apiMessage = new ApiError(ex.getHttpStatus(), ex.getMessage(), ex.getCode(), ex);
        return new ResponseEntity<>(apiMessage, new HttpHeaders(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handleAllUncaughtException(Exception ex, WebRequest request) {
        ApiError apiMessage = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "basket_uncaught_error", ex);
        return new ResponseEntity<>(apiMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
