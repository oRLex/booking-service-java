package exeption;

public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

    public String toString() {
        return  getMessage();
    }
}
