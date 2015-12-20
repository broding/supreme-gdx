package nl.basroding.supreme.binder.injection;

import nl.basroding.supreme.binder.IBinder;

public interface IInjectionBinder extends IBinder {
    void inject(Object target);
    IInjectionBinding bindInjection(Class<?> classType);
}
