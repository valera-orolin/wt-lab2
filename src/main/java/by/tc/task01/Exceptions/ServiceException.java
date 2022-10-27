package by.tc.task01.Exceptions;

public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

}

