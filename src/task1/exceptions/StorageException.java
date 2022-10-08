package task1.exceptions;

public class StorageException extends Exception {

    public StorageException(String message) {
        super(message);
        System.out.println(message);
    }
}
