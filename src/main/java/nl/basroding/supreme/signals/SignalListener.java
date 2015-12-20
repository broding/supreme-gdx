package nl.basroding.supreme.signals;

public interface SignalListener {

    interface Zero extends SignalListener {
        void handle();
    }

    interface One<T> extends SignalListener {
        void handle(T t);
    }

    interface Two<T, U> extends SignalListener {
        void handle(T t, U u);
    }
}


