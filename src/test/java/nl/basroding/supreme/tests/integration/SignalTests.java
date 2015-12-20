package nl.basroding.supreme.tests.integration;

import org.junit.Assert;
import org.junit.Test;

public class SignalTests {

    private boolean signalDispatched = false;

    @Test
    public void signals_dispatchesIntSignal_intIsFound() {
        SingleParameterSignal signal = new SingleParameterSignal();
        signal.addListener(i -> Assert.assertEquals(5, (int)i));
        signal.dispatch(5);
    }
}
