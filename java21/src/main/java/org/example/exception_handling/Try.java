package org.example.exception_handling;

import java.util.concurrent.Callable;
import java.util.function.Function;

public sealed interface Try<T> permits Success, Failure {
    T getResult();
    Throwable getError();
    // 関数からの例外をここでラップ
    // 例外をデータとして扱う
    static <T> Try<T> of(Callable<T> code) {
        try {
            return new Success<>(code.call());
        } catch (Throwable throwable) {
            return new Failure<>(throwable);
        }
    }

    default <R> Try<R> map(Function<T, R> mapper) {
        if (this instanceof Success<T>) {
            return of(() -> mapper.apply(getResult()));
        } else {
            return new Failure<>(getError());
        }
    }
}
