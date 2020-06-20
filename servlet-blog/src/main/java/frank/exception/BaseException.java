package frank.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseException extends RuntimeException{

    protected String code;

    public BaseException(String code, String message) {
        this(code, message, null);
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
