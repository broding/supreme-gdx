package nl.basroding.supreme.binder;

public interface IBinder {
    IBinding bind(Class<?> classType);
    IBinding getBinding(Class<?> classType);
}
