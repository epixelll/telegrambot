package kg.aika.demo.exception;

public class FailedSendMessageException extends RuntimeException{
    public FailedSendMessageException(String message, Throwable cause){
        super(message, cause);
    }
}
