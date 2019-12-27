package be.seeseemelk.mockbukkit;

public class UnimplementedOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnimplementedOperationException() {
        super("Not implemented");
    }

    public UnimplementedOperationException(String message) {
        super(message);
    }
}
