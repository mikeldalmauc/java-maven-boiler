package com.example.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	private List<Package> packages;
	
	public Model(){
		this.listeners = new PropertyChangeSupport(this);
		
		/**
		 * Model initial data
		 */
		
		this.count = 0;

		// Create test packages
		this.packages = Stream.iterate(0, i -> i + 1).limit(100)
		.map(i -> Package.createFakePackage())
		.collect(Collectors.toList());
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

	public List<Package> getPackages(){
		return this.packages;
	}
}