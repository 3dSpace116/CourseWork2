package pro.sky.course2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class QuestionNotFound extends RuntimeException{
    public QuestionNotFound() {
        super();
    }

    public QuestionNotFound(String message) {
        super(message);
    }

    public QuestionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotFound(Throwable cause) {
        super(cause);
    }

    protected QuestionNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
