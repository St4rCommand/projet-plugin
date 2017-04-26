package org.nantes.univ.archi.platform;

import org.nantes.univ.archi.platform.behaviour.IDescription;
import org.nantes.univ.archi.platform.model.Description;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 26/04/17.
 */
public class DescriptionTableModel extends AbstractTableModel {


    public static final String col1 = "Plugin";
    public static final String col2 = "Statut";
    private List<IDescription> descriptions = new ArrayList<>();
    private final String[] entetes = {col1, col2};

    public DescriptionTableModel() {
        super();
    }

    @Override
    public int getRowCount() {
        return descriptions.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return descriptions.get(rowIndex).getName();
            case 1:
                return Tools.getStatusMessage(descriptions.get(rowIndex).getStatus());
            default:
                return null;
        }
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public void updateDescription(List<IDescription> descriptions) {
        this.descriptions = descriptions;
        fireTableDataChanged();
    }
}
