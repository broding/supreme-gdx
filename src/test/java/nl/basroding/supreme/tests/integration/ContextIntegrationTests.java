package nl.basroding.supreme.tests.integration;

import nl.basroding.supreme.Context;
import nl.basroding.supreme.binder.injection.InjectionException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ContextIntegrationTests {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void context_injectInterface_throwException(){
        exception.expect(InjectionException.class);
        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class);
            }

            @Override
            public void setupViews() {
                WorldView worldView = new WorldView();
                addView(worldView);
            }

            @Override
            public void destroyViews() {

            }
        };
    }

    @Test
    public void context_bindInterfaceToInterface_throwException(){
        exception.expect(InjectionException.class);
        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(IWorld.class);
            }

            @Override
            public void setupViews() {
                WorldView worldView = new WorldView();
                addView(worldView);
            }

            @Override
            public void destroyViews() {

            }
        };
    }

    @Test
    public void context_bindInterfaceToConcreteClass_noException(){
        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(World.class);
            }

            @Override
            public void setupViews() {
                WorldView worldView = new WorldView();
                addView(worldView);
            }

            @Override
            public void destroyViews() {

            }
        };
    }

    @Test
    public void context_injectClassIntoView_viewHasClass(){
        WorldView worldView = new WorldView();
        World world = new World();

        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(world);
            }

            @Override
            public void setupViews() {
                addView(worldView);
            }

            @Override
            public void destroyViews() {

            }
        };

        Assert.assertEquals(world, worldView.world);
    }

    @Test
    public void context_injectValue_viewHasValueInjected(){
        WorldView worldView = new WorldView();

        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(World.class);
            }

            @Override
            public void setupViews() {
                addView(worldView);
            }

            @Override
            public void destroyViews() {

            }
        };

        Assert.assertNotNull(worldView.world);
    }

    @Test
    public void context_injectWithNoSingleton_viewHasNewInstanceInjected(){
        WorldView worldViewOne = new WorldView();
        WorldView worldViewTwo = new WorldView();

        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(World.class);
            }

            @Override
            public void setupViews() {
                addView(worldViewOne);
                addView(worldViewTwo);
            }

            @Override
            public void destroyViews() {

            }
        };

        Assert.assertNotEquals(worldViewOne.world, worldViewTwo.world);
    }

    @Test
    public void context_injectToSingleton_viewSameInstanceInjected(){
        WorldView worldViewOne = new WorldView();
        WorldView worldViewTwo = new WorldView();

        Context context = new Context(){

            @Override
            public void mapSignals() {
                injectionBinder.bindInjection(IWorld.class).toInjection(World.class).toSingleton();
            }

            @Override
            public void setupViews() {
                addView(worldViewOne);
                addView(worldViewTwo);
            }

            @Override
            public void destroyViews() {

            }
        };

        Assert.assertEquals(worldViewOne.world, worldViewTwo.world);
    }

}
