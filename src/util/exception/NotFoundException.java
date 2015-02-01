package util.exception;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 30/01/2015
 * Time: 11:13 AM
 */
public class NotFoundException extends Exception
{
    public NotFoundException()
    {
        super();
    }

    public NotFoundException(String message)
    {
        super(message);
    }

    public NotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NotFoundException(Throwable cause)
    {
        super(cause);
    }

    protected NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
