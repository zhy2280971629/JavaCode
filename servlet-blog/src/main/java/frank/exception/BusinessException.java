package frank.exception;

public class BusinessException extends BaseException{
    public BusinessException(String code, String message) {
        super(code, message, null);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(code, "业务异常" + message, cause);
    }
}
