package de.Rechnungen.Rechnungenbackend.Exceptions;

public class NotMatchingArgumentException extends Exception{

    public NotMatchingArgumentException() {
    }
    public NotMatchingArgumentException(String message) {
        super(message);
    }
}
