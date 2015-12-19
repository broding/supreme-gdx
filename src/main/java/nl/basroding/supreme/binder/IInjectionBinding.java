package nl.basroding.supreme.binder;

public interface IInjectionBinding extends IBinding {
    IInjectionBinding toSingleton();
    IInjectionBinding toInjection(Object object);
}
