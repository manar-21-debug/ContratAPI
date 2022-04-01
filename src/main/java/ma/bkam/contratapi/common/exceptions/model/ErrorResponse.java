package ma.bkam.contratapi.common.exceptions.model;

public class ErrorResponse implements IGenericError {

    private String error;

    /**
     * Gets error.
     *
     * @return the error
     */
    @Override
    public String getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(String error) {
        this.error = error;
    }
}


