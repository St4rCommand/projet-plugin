package org.nantes.univ.archi.platform;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by romain on 08/03/17.
 */
public class Description implements IDescription {

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
}
