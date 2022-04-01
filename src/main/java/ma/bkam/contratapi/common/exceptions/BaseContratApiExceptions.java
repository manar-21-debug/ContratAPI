package ma.bkam.contratapi.common.exceptions;

public class BaseContratApiExceptions extends RuntimeException {

    private final int status;
    private final String message;



    public BaseContratApiExceptions(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
