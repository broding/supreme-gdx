package nl.basroding.supreme;

import nl.basroding.supreme.binder.injection.IInjectionBinder;
import nl.basroding.supreme.binder.injection.InjectionBinder;
import nl.basroding.supreme.command.CommandExecutor;
import nl.basroding.supreme.command.ICommandExecutor;
import nl.basroding.supreme.message.IMessageDispatcher;
import nl.basroding.supreme.message.MessageDispatcher;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Context implements IContext {

    public IInjectionBinder injectionBinder;
    public ICommandExecutor commandExecutor;
    public IMessageDispatcher messageDispatcher;
    public Collection<IView> views;

    public void initialize(){
        injectionBinder = new InjectionBinder();
        commandExecutor = new CommandExecutor();
        messageDispatcher = new MessageDispatcher();
        views = new ArrayList<>();

        injectionBinder.bindInjection(IInjectionBinder.class).toInjection(injectionBinder).toSingleton();
        injectionBinder.bindInjection(ICommandExecutor.class).toInjection(commandExecutor).toSingleton();
        injectionBinder.bindInjection(IMessageDispatcher.class).toInjection(messageDispatcher).toSingleton();
        injectionBinder.bindInjection(IContext.class).toInjection(this).toSingleton();

        initializeInjections();
        initializeViews();
    }

    public void addView(IView view){
        views.add(view);
        injectionBinder.inject(view);
        view.onRegister();
    }

    public void removeView(IView view){
        views.remove(view);
        view.onDestroy();
    }

    public abstract void initializeInjections();
    public abstract void initializeViews();
    public abstract void destroyViews();
}
