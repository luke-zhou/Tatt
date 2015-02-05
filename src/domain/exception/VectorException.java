package domain.exception;

/**
 * Created with IntelliJ IDEA.
 * User: lzhou
 * Date: 5/02/2015
 * Time: 1:21 PM
 */
public class VectorException extends Exception
{
    public VectorException()
    {
    }

    public VectorException(String message)
    {
        super(message);
    }

    public VectorException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public VectorException(Throwable cause)
    {
        super(cause);
    }
}
