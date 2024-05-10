package com.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {

	/*
	 * Support to add change listeners
	 */
	private PropertyChangeSupport listeners;
	
	public void setListener(PropertyChangeListener view) {
		listeners.addPropertyChangeListener(view);
	}

    /**
	 *  Model data should go here
	 */
	private Integer count;
	
	public Model(){
		this.listeners = new PropertyChangeSupport(this);
	
		/**
		 * Model initial data
		 */
		this.count = 0;
	}

    /*
	 * This will notify of a change to property change listeners
	 */
	public void setCount(Integer count) {
		Integer old = this.count;
		this.count = count;
		listeners.firePropertyChange("count", old, this.count);;
	}

    public Integer getCount(){
        return this.count;
    }
}