package com.caredRemember2.controller;

import com.caredRemember2.model.Model;
import com.caredRemember2.view.View;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerDefaultTest {

    private ControllerDefault<Model, View> controller = new ControllerDefaultMock();
    private Model model = mock(Model.class);
    private View view = mock(View.class);

    @Test
    public void checkToInvokeMethodOnView() throws Exception {
        controller.setModel(model);
        controller.setView(view);
        controller.update();

        verify(view).show();
    }

    @Test(expected = IllegalStateException.class)
    public void whenNotSetMadel() throws Exception {
        controller.setView(view);
        controller.update();
    }

    @Test(expected = IllegalStateException.class)
    public void whenNotSetView() throws Exception {
        controller.setModel(model);
        controller.update();
    }

    private class ControllerDefaultMock extends ControllerDefault<Model, View> {
        @Override
        void updateDataForView() {

        }
    }
}