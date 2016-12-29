package com.caredRemember2.controller;

import com.caredRemember2.model.Model;
import com.caredRemember2.view.View;

/**
 * Use for control {@link Model} and {@link View}
 * M - Model
 * V - View
 */
public interface Controller<M extends Model, V extends View> {
    /**
     * Set {@link Model} for control.
     *
     * @param model {@link Model} which need control.
     */
    void setModel(M model);

    /**
     * Set {@link View} for control.
     *
     * @param view {@link View} which need control.
     */
    void setView(V view);

    /**
     * Show {@link Model} on {@link View}.
     */
    void update();
}
