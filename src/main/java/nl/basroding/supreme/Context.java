package nl.basroding.supreme;

import nl.basroding.supreme.binder.IInjectionBinder;
import nl.basroding.supreme.binder.InjectionBinder;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Context {

    public IInjectionBinder injectionBinder;
    public Collection<IView> views;

    public Context(){
        injectionBinder = new InjectionBinder();
        views = new ArrayList<>();

        mapSignals();
        setupViews();
    }

    public void addView(IView view){
        views.add(view);
        injectionBinder.inject(view);
        view.onRegister();
    }

    public abstract void mapSignals();
    public abstract void setupViews();
    public abstract void destroyViews();
}
