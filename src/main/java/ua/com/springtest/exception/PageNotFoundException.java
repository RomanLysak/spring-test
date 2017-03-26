package ua.com.springtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Page Not Found")
public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException() {
        super();
    }

    public PageNotFoundException(String messsage) {
        super(messsage);
    }

    public PageNotFoundException(String messsage, Throwable cause) {
        super(messsage, cause);
    }

}
