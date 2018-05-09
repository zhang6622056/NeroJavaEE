package tree.exception;

/**
 * Created by Nero on 2018/3/5.
 */
public class NodeMisMatchException extends RuntimeException{

    public NodeMisMatchException() {
        super();
    }

    public NodeMisMatchException(String message) {
        super(message);
    }

    public NodeMisMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public NodeMisMatchException(Throwable cause) {
        super(cause);
    }

    protected NodeMisMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
