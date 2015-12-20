package nl.basroding.supreme.binder;

public interface IBinder {
    IBinding bind(Class<?> classType);
    IBinding getBinding(Class<?> classType);
    IBinding getBinding(Class<?> classType, String name);
    boolean hasBinding(Class<?> classType);
}
