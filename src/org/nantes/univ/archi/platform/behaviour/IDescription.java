package org.nantes.univ.archi.platform.behaviour;

import java.util.Map;
import java.util.Observable;

/**
 * Created by romain on 08/03/17.
 */
public interface IDescription{

    Map<String, String> getProprietes();
    String getPropriete(String key);
    String getName();
    int getStatus();
    void setStatus(int status);
}
