package nl.basroding.supreme.message;

@FunctionalInterface
public interface MessageListener<T extends Message> {
    void handle(T message);
}
