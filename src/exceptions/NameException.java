package exceptions;

public class NameException extends Exception{

    public static final String ERROR_TEXT = "Nombre no valido";

    public NameException() {
        super(ERROR_TEXT);
    }
}
