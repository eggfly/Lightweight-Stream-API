package com.annimon.stream.function;

/**
 * Represents an operation on two input arguments.
 * 
 * @param <T> the type of the first argument
 * @param <U> the type of the second argument
 * @see Consumer
 */
@FunctionalInterface
public interface BiConsumer<T, U> {
    
    /**
     * Performs operation on two arguments.
     * 
     * @param value1  first argument
     * @param value2  second argument
     */
    void accept(T value1, U value2);
    
    class Util {
        /**
         * Compose {@code BiConsumer} calls.
         * 
         * <p>{@code c1.accept(t, u); c2.accept(t, u); }
         * 
         * @param <T> the type of the first argument
         * @param <U> the type of the second argument
         * @param c1  first {@code BiConsumer}
         * @param c2  second {@code BiConsumer}
         * @return composed {@code BiConsumer}
         * @throws NullPointerException if {@code c1} or {@code c2} is null
         */
        public static <T, U> BiConsumer<T, U> andThen(
                final BiConsumer<? super T, ? super U> c1,
                final BiConsumer<? super T, ? super U> c2) {
            return new BiConsumer<T, U>() {
                @Override
                public void accept(T t, U u) {
                    c1.accept(t, u);
                    c2.accept(t, u);
                }
            };
        }
    }
}
