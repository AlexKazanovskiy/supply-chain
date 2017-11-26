/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.gui.statistics;




import kpi.supplychain.pojo.NetworkConfig;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author I
 */
public class EfficiencyTableModel extends AbstractTableModel{

    private List<NetworkConfig> nConfigList;
    private double[] networkDegree;
    
    
    @Override
    public int getRowCount() {
        return nConfigList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return nConfigList.get(rowIndex).getId();
            case 1: return nConfigList.get(rowIndex).getTotalCost();
            case 2: return networkDegree[rowIndex]*100;
              default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "№ конфигурации";
            case 1: return "Общие затраты";
            case 2: return "Уровень сервиса";
            default: return "N/A";
        }
    }

    public EfficiencyTableModel(List<NetworkConfig> nConfigList, double[] networkDegree) {
        this.nConfigList = nConfigList;
        this.networkDegree = networkDegree;
    }

    public void setRowColour(int row, Color c) {
       
        //rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }
    
    
}
