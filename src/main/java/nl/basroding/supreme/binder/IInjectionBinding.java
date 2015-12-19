package nl.basroding.supreme.binder;

public interface IInjectionBinding extends IBinding {
    IInjectionBinding toSingleton();
    IInjectionBinding toInjection(Object object);
    InjectionBindingType getInjectionBindingType();
    void setInjectionBindingType(InjectionBindingType type);


}
