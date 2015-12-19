package nl.basroding.supreme.binder;

public class InjectionBinding extends Binding implements IInjectionBinding{

    private InjectionBindingType type = InjectionBindingType.VALUE;

    @Override
    public IInjectionBinding toSingleton() {
        type = InjectionBindingType.SINGLETON;
        return this;
    }

    @Override
    public IInjectionBinding toInjection(Object object) {
        return (IInjectionBinding)to(object);
    }

    @Override
    public InjectionBindingType getInjectionBindingType() {
        return type;
    }

    @Override
    public void setInjectionBindingType(InjectionBindingType type) {
        this.type = type;
    }
}
