package nl.basroding.supreme.signals;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSignal {

    private List<SignalListener> listeners;

    protected BaseSignal() {
        listeners = new ArrayList<>();
    }

    public abstract void dispatch(SignalListener listener, Object... args);

    protected void dispatchInternal(Object... args) {
        for(SignalListener listener : listeners){
            dispatch(listener, args);
        }
    }

    protected void addListenerInternal(SignalListener listener) {
        listeners.add(listener);
    }

    public void removeListener(SignalListener listener){
        listeners.remove(listener);
    }
}
