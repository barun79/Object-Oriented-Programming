package library;
/**
 * Custom exception class for invalid runtime in Video objects.
 */
public class InvalidRuntimeException extends ArithmeticException {
    /**
     * Constructs a new InvalidRuntimeException with no detail message.
     */
    public InvalidRuntimeException(){
        super();
    }
    /**
     * Constructs a new InvalidRuntimeException with the specified detail message.
     *
     * @param message The detail message describing the exception.
     */
    public InvalidRuntimeException(String message){
        super(message);
    }
/**
     * Constructs a new InvalidRuntimeException with a specific title and runtime value.
     *
     * @param title   The title of the publication.
     * @param runtime The invalid runtime value.
     */
    public InvalidRuntimeException(String title, int runtime){
        super(title + " has invalid runtime [" + runtime +"]");
    }
}
