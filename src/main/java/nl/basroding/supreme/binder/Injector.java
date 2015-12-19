package nl.basroding.supreme.binder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Injector implements IInjector {

    private IBinder binder;
    private IInjectionFactory factory;

    public Injector(IBinder binder){
        this.binder = binder;
        this.factory = new InjectionFactory();
    }

    @Override
    public void inject(Object target) {
        performSetterInjection(target);
    }

    private void performSetterInjection(Object target){
        Class targetClass = target.getClass();
        for(Field field : targetClass.getFields()){
            for(Annotation annotation : field.getDeclaredAnnotations()){
                if(annotation.annotationType() == Inject.class){
                    IBinding binding = binder.getBinding(field.getType());
                    try {
                        Object value = factory.create((IInjectionBinding)binding);
                        field.set(target, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
