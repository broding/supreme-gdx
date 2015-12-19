package nl.basroding.supreme.binder;

public class InjectionFactory implements IInjectionFactory {

    @Override
    public Object create(IInjectionBinding binding) {
        if(binding.getValue() == null) {
            if(binding.getKey().isInterface()){
                throw new InjectionException("Can not create instance of " + binding.getKey().toString());
            }
            return createInstance(binding);
        }else if(binding.getValue().getClass() == Class.class){
            return createInstance(binding);
        }else{
            return binding.getValue();
        }

    }

    private Object createInstance(IInjectionBinding binding){
        Class classType;
        if(binding.getValue() == null){
            classType = (Class)binding.getKey();
        }else{
            classType = (Class)binding.getValue();
        }

        if(classType.isInterface()){
            throw new InjectionException("Can not create instance of " + binding.getKey().toString());
        }

        try {
            return classType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
