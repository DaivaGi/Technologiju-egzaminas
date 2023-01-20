package lt.techin.exception;


public class BloggingServiceDisabledException extends RuntimeException {


    public BloggingServiceDisabledException() {
    }

    public BloggingServiceDisabledException(String message) {
        super(message);
    }

}
