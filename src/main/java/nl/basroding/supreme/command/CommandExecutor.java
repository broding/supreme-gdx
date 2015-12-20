package nl.basroding.supreme.command;

import nl.basroding.supreme.binder.injection.IInjectionBinder;
import nl.basroding.supreme.binder.injection.Inject;

public class CommandExecutor implements ICommandExecutor {

    @Inject
    public IInjectionBinder injectionBinder;

    @Override
    public void execute(Command command) {
        injectionBinder.inject(command);
        command.execute();
    }
}
