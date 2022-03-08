package domain;

public class NotRegisteredException extends Exception {
    public NotRegisteredException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
