package com.caredRemember2.controller;

import com.caredRemember2.model.Model;
import com.caredRemember2.view.View;

/**
 * TODO: Add doc
 * Created by Nikita on 27.12.2016.
 */
public abstract class ControllerDefault<M extends Model, V extends View<M>> implements Controller<M, V> {
    private M model;
    private V view;

    @Override
    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public void setView(V view) {
        this.view = view;
    }

    @Override
    public void update() {
        view.setModel(model);
        view.show();
    }

    /**
     * Update data for {@link View}.
     */
    abstract void updateDataForView();
}
