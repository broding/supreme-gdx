package nl.basroding.supreme.message;

public interface IMessageDispatcher {
    <T extends Message> MessageListener<T> register(Class<T> messageClass, MessageListener<T> listener);
    <T extends Message> void unregister(Class<T> messageClass, MessageListener<T> listener);
    void dispatch(Message message);
}
