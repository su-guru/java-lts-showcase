package org.example.exception_handling;

public final class Failure<T> implements Try<T> {
    private Throwable throwable;

    Failure(Throwable throwable) {
        this.throwable = throwable;
    }
    @Override
    public T getResult() {
        throw new RuntimeException("Invalid Invocation");
    }

    @Override
    public Throwable getError() {
        return this.throwable;
    }
}
