package nl.basroding.supreme.binder.injection;

import nl.basroding.supreme.binder.IBinder;
import nl.basroding.supreme.binder.IBinding;

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
            Inject injectAnnotation = field.getAnnotation(Inject.class);
            if(injectAnnotation != null){
                IInjectionBinding binding = (IInjectionBinding)binder.getBinding(field.getType(), injectAnnotation.value());
                inject(target, field, binding);
            }
        }
    }

    private void inject(Object target, Field field, IInjectionBinding binding){
        Object value = null;
        if(binding.getValue() == null || binding.getValue().getClass() == Class.class){
            value = factory.create((IInjectionBinding)binding);
            if(binding.getInjectionBindingType() == InjectionBindingType.SINGLETON){
                binding.setValue(value);
            }
        }else{
            value = binding.getValue();
        }

        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
