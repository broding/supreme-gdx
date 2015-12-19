package nl.basroding.supreme.binder;

public class Binding implements IBinding {

    private Class<?> key;
    private Object value;

    public Binding(){
    }

    @Override
    public IBinding bind(Class<?> classType) {
        key = classType;
        return this;
    }

    @Override
    public IBinding to(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public Class<?> getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}
