package nl.basroding.supreme.binder;

public interface IInjectionBinder extends IBinder {
    void inject(Object target);
    IInjectionBinding bindInjection(Class<?> classType);
}
