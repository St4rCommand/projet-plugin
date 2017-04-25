package org.nantes.univ.archi.platform.model;

import org.nantes.univ.archi.platform.behaviour.IDescription;

import java.util.Map;
import java.util.Observable;

/**
 * Created by romain on 08/03/17.
 */
public class Description implements IDescription, Observable {

    protected Map<String, String> proprietes;
    protected String name;
    protected String description;
    protected int status;

    public Description (String name, Map<String, String> proprietes) {
        this.name = name;
        this.proprietes = proprietes;
    }

    public Map<String, String> getProprietes() {
        return this.proprietes;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.notifyObservers(status);
    }
}
