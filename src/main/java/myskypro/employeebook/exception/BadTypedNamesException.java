package myskypro.employeebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class BadTypedNamesException extends HttpStatusCodeException {

    public BadTypedNamesException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
