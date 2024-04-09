package myskypro.employeebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class WrongTypedException extends HttpStatusCodeException {

    public WrongTypedException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
