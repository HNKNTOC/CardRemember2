package com.caredRemember2.view;

import com.caredRemember2.model.Model;

/**
 * Use for display {@link com.caredRemember2.model.Model}.
 * M - Model
 */
public interface View<M extends Model> {

    /**
     * Set {@link Model} for display.
     * @param model
     */
    void setModel(M model);

    /**
     * Show {@link Model}.
     */
    void show();
}
