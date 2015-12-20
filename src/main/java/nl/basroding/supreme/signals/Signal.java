package nl.basroding.supreme.signals;

public class Signal {

    public static class Zero extends BaseSignal {

        @Override
        public void dispatch(SignalListener listener, Object... args) {
            ((SignalListener.Zero)listener).handle();
        }

        public void addListener(SignalListener.Zero listener) {
            addListenerInternal(listener);
        }

        public void dispatch(){
            dispatchInternal();
        }
    }

    public static class One<T> extends BaseSignal {

        public void addListener(SignalListener.One<T> listener){
            addListenerInternal(listener);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void dispatch(SignalListener listener, Object... args) {
            SignalListener.One<T> listenerOne = (SignalListener.One<T>)listener;
            listenerOne.handle((T)args[0]);
        }

        public void dispatch(T t){
            dispatchInternal(t);
        }
    }

    public static class Two<T, U> extends BaseSignal {

        public void addListener(SignalListener.Two<T, U> listener){
            addListenerInternal(listener);
        }

        public void dispatch(T t, U u){
            dispatchInternal(t, u);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void dispatch(SignalListener listener, Object... args) {
            ((SignalListener.Two<T, U>)listener).handle((T)args[0], (U)args[1]);
        }
    }

}
