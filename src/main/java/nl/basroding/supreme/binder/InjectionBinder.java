package nl.basroding.supreme.binder;

public class InjectionBinder extends Binder implements IInjectionBinder {

    private IInjector injector;

    public InjectionBinder(){
        injector = new Injector(this);
    }

    @Override
    public IBinding bind(Class<?> classType) {
        return super.bind(classType);
    }

    @Override
    public void inject(Object target) {
        injector.inject(target);
    }

    @Override
    public IInjectionBinding bindInjection(Class<?> classType) {
        return (IInjectionBinding)bind(classType);
    }

    @Override
    protected IBinding getRawBinding() {
        return new InjectionBinding();
    }
}
