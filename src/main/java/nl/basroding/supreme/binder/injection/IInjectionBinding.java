package nl.basroding.supreme.binder.injection;

import nl.basroding.supreme.binder.IBinding;

public interface IInjectionBinding extends IBinding {
    IInjectionBinding toSingleton();
    IInjectionBinding toInjection(Object object);
    InjectionBindingType getInjectionBindingType();
    void setInjectionBindingType(InjectionBindingType type);


}
