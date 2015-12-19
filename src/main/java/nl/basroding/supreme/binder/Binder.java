package nl.basroding.supreme.binder;

import java.util.HashMap;

public class Binder implements IBinder {

    private HashMap<Object, IBinding> bindings;
    private IResolver resolver;

    public Binder() {
        this.bindings = new HashMap<>();
    }

    public IBinding bind(Class<?> classType){
        IBinding binding = getRawBinding();
        binding.bind(classType);
        bindings.put(classType, binding);

        return binding;
    }

    @Override
    public IBinding getBinding(Class<?> classType) {
        IBinding binding = bindings.get(classType);

        if(binding == null){
            throw new RuntimeException("Could not find binding for " + classType.toString());
        }

        return binding;
    }

    protected IBinding getRawBinding(){
        return new Binding();
    }
}
