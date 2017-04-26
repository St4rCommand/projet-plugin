package org.nantes.univ.archi.plugins.gestionEtudiants.moteurMiageSims;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.plugins.gestionEtudiants.stubMiageSims.StubInterface;

import java.util.List;

/**
 * Created by denis on 26/04/2017.
 */
public interface SimsMiageInterface {

    void init(StubInterface stub, List<IDescription> pluginList);

}
