package org.nantes.univ.archi.platform.model;

import org.nantes.univ.archi.platform.behaviour.IDescription;

import java.util.Map;
import org.nantes.univ.archi.platform.behaviour.Observable;

/**
 * Created by romain on 08/03/17.
 */
public class Description extends Observable implements IDescription {

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

    @Override
    public String getPropriete(String key) {
        return proprietes.get(key);
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
        this.notifyObservers();
    }
}
