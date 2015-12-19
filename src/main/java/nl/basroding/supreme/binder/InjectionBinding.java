package nl.basroding.supreme.binder;

public class InjectionBinding extends Binding implements IInjectionBinding{

    private boolean isSingleton;

    @Override
    public IInjectionBinding toSingleton() {
        isSingleton = true;
        return this;
    }

    @Override
    public IInjectionBinding toInjection(Object object) {
        return (IInjectionBinding)to(object);
    }
}
