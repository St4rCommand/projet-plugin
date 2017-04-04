package org.nantes.univ.archi.platform.behaviour;

import java.util.Map;

/**
 * Created by romain on 08/03/17.
 */
public interface IDescription {

    Map<String, String> getProprietes();
    String getName();
    int getStatus();
}
