package com.vending.machine.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Abstract class that will help children classes with annotations that will
 * automatically populate the <code>createOn</code> and <code>updateOn
 * </code> fields when the children are persisted.
 *
 * @author Mkhululi Tyukala
 *
 */
public abstract class Model implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Date createOn = new Date(System.currentTimeMillis());
    private Date updatedOn = new Date(System.currentTimeMillis());


    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
