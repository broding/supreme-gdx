package nl.basroding.supreme.binder;

import java.util.*;

public class Binder implements IBinder {

    private Map<Object, List<IBinding>> bindings;

    public Binder() {
        this.bindings = new HashMap<>();
    }

    public IBinding bind(Class<?> classType){
        IBinding binding = getRawBinding();
        binding.bind(classType);

        if(!bindings.containsKey(classType)){
            bindings.put(classType, new ArrayList<>());
        }

        List list = bindings.get(classType);
        list.add(binding);

        return binding;
    }

    @Override
    public IBinding getBinding(Class<?> classType) {
        IBinding binding = bindings.get(classType).get(0);

        if(binding == null){
            throw new RuntimeException("Could not find binding for " + classType.toString());
        }

        return binding;
    }

    @Override
    public IBinding getBinding(Class<?> classType, String name) {
        IBinding binding = bindings.get(classType).stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);

        if(binding == null){
            throw new RuntimeException("Could not find binding for " + classType.toString() + " with name " + name);
        }

        return binding;
    }

    @Override
    public boolean hasBinding(Class<?> classType) {
        return bindings.containsKey(classType);
    }

    protected IBinding getRawBinding(){
        return new Binding();
    }
}
