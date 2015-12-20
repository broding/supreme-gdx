package nl.basroding.supreme.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDispatcher implements IMessageDispatcher {

    private Map<Class<? extends Message>, List<MessageListener>> listeners;

    public MessageDispatcher(){
        listeners = new HashMap<>();
    }

    public <T extends Message> MessageListener<T> register(Class<T> messageClass, MessageListener<T> listener){
        if(listeners.get(messageClass) == null){
            listeners.put(messageClass, new ArrayList<>());
        }

        List<MessageListener> list = listeners.get(messageClass);
        list.add(listener);

        return listener;
    }

    public <T extends Message> void unregister(Class<T> messageClass, MessageListener<T> listener) {
        if(listeners.get(messageClass) == null) {
            return;
        }

        int indexOf = listeners.get(messageClass).indexOf(listener);

        listeners.get(messageClass).remove(listener);
    }

    public void dispatch(Message message){
        listeners.get(message.getClass()).forEach(listener -> listener.handle(message));
    }

}
