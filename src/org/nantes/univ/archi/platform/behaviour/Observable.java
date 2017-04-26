package org.nantes.univ.archi.platform.behaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 26/04/17.
 */
public abstract class Observable {

    protected List<Observer> observers = new ArrayList<>();

    public void notifyObservers() {
        for (Observer o:this.observers) {
            o.update(this);
        }
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

}
