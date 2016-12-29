package com.caredRemember2.controller;

import com.caredRemember2.model.Model;
import com.caredRemember2.view.View;

/**
 * Default implementation for update().
 * Add method updateDataForView() in which update data for view.
 */
public abstract class ControllerDefault<M extends Model, V extends View> implements Controller<M, V> {
    protected M model;
    protected V view;

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
        if (view == null)
            throw new IllegalStateException("View not needs equal null. Set the View in to the Controller.");
        if (model == null)
            throw new IllegalStateException("Model not needs equal null. Set the Model in to the Controller.");
        updateDataForView();
        view.show();
    }

    /**
     * Update data for {@link View}.
     */
    abstract void updateDataForView();
}
