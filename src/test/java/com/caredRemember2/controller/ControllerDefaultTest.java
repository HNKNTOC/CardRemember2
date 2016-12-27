package com.caredRemember2.controller;

import com.caredRemember2.model.Model;
import com.caredRemember2.view.View;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerDefaultTest {

    @Test
    public void checkToInvokeMethodOnView() throws Exception {
        ControllerDefault<Model, View<Model>> controller = new ControllerDefault<Model, View<Model>>() {
            @Override
            void updateDataForView() {

            }
        };

        Model model = mock(Model.class);
        View<Model> view = mock(View.class);

        controller.setModel(model);
        controller.setView(view);
        controller.update();

        //TODO: add Order for testing order invoke.
        verify(view).setModel(model);
        verify(view).show();
    }
}