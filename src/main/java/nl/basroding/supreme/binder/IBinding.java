package nl.basroding.supreme.binder;

public interface IBinding {
    IBinding bind(Class<?> classType);
    IBinding to(Object value);
    Class<?> getKey();
    Object getValue();
}
