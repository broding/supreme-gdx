package nl.basroding.supreme.binder;

public interface IBinding {
    IBinding bind(Class<?> classType);
    IBinding to(Object value);
    Class<?> getKey();
    <T> T getValue();
    void setValue(Object value);
    IBinding toName(String name);
    String getName();
}
