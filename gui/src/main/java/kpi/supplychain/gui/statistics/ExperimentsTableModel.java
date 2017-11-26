/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.gui.statistics;

import kpi.supplychain.pojo.Experiment;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author I
 */
public class ExperimentsTableModel extends AbstractTableModel{

    private List<Experiment> expList;
    @Override
    public int getRowCount() {
        return expList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return expList.get(rowIndex).getId();
            case 1: return expList.get(rowIndex).getConfig_id();
            case 2: return expList.get(rowIndex).getDate();
            case 3: return expList.get(rowIndex).getService_degree()*100;
              default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "ID";
            case 1: return "№ конфигурации";
            case 2: return "Дата проведения";
            case 3: return "Результат";
            default: return "N/A";
        }
    }

    
    public ExperimentsTableModel(List<Experiment> expList) {
        this.expList = expList;
    }

    public ExperimentsTableModel() {
    }
    
    
    
}
