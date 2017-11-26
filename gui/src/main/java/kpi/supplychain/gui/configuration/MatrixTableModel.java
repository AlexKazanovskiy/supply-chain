package kpi.supplychain.gui.configuration;


import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Route;

import javax.swing.table.AbstractTableModel;
import java.util.Observable;
import java.util.Observer;

public class MatrixTableModel extends AbstractTableModel implements Observer {
    private static final long serialVersionUID = 1L;
    int m1, m2, m3, m4;
    int mc = m1 + m2 + m3 + m4;
    int mr = m1 + m2 + m3;

    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }

    public MatrixTableModel() {
        super();
        m1 = 3;
        m2 = 2;
        m3 = 4;
        m4 = 2;
        mc = m1 + m2 + m3 + m4;
        mr = m1 + m2 + m3;
        // updateData();
    }

    public String getColumnName(int column) {
        if (column == 0)
            return "";

        if (column > network.getNationalCount() + network.getRegionalCount()) {
            return network.getLocal()[column - network.getNationalCount() - network.getRegionalCount() - 1].getAdress() + " (Л)";
        }

        if (column > network.getNationalCount()) {
            return network.getRegional()[column - network.getNationalCount() - 1].getAdress() + " (Р)";
        }

        if (column > 0) {
            return network.getNational()[column - 1].getAdress() + " (Н)";
        }

        return "M" + (getNameColumnSector(column)) + " (m" + (column) + ")"; // MC
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false; // MR
        }

        if (columnIndex < network.getNationalCount() + 1) {
            if (rowIndex < network.getProducerCount()) {
                return true;
            }
            return false;
        }

        if (columnIndex < network.getNationalCount() + network.getRegionalCount() + 1) {
            int newRowIndex = rowIndex - network.getProducerCount();
            if ((newRowIndex >= 0) && (newRowIndex < network.getNationalCount())) {
                return true;
            }
            return false;
        }

        int newRowIndex = rowIndex - network.getProducerCount() - network.getNationalCount();
        if ((newRowIndex >= 0) && (newRowIndex < network.getLocalCount())) {
            return true;
        }
        return false;

    }

    public int getRowCount() {
        return network.getProducerCount() + network.getNationalCount() + network.getRegionalCount();
    }

    public int getColumnCount() {
        return network.getNationalCount() + network.getRegionalCount() + network.getLocalCount() + 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        System.out.println(aValue);

        if (columnIndex == 0) {
            return; // MR
        }
        Boolean value = (Boolean) aValue;
        if (columnIndex < network.getNationalCount() + 1) {
            if (value) {
                network.getNational()[columnIndex - 1].getRoutes().put(rowIndex, new Route(rowIndex));
            } else {
                network.getNational()[columnIndex - 1].getRoutes().remove(rowIndex);
            }
            network.notifyObservers();
            return;
        }

        if (columnIndex < network.getNationalCount() + network.getRegionalCount() + 1) {
            int newRowIndex = rowIndex - network.getProducerCount();
            int newColumnIndex = columnIndex - network.getNationalCount() - 1;
            if (value) {
                network.getRegional()[newColumnIndex].getRoutes().put(newRowIndex, new Route(newRowIndex));
            } else {
                network.getRegional()[newColumnIndex].getRoutes().remove(newRowIndex);
            }
            network.notifyObservers();
            return;
        }

        int newRowIndex = rowIndex - network.getProducerCount() - network.getNationalCount();
        int newColumnIndex = columnIndex - network.getNationalCount() - network.getRegionalCount() - 1;
        if (value) {
            network.getLocal()[newColumnIndex].getRoutes().put(newRowIndex, new Route(newRowIndex));
        } else {
            network.getLocal()[newColumnIndex].getRoutes().remove(newRowIndex);
        }

        network.notifyObservers();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (rowIndex < network.getProducerCount()) {
                return network.getProducer()[rowIndex].getAdress();
            }
            if (rowIndex < network.getNationalCount() + network.getProducerCount()) {
                return network.getNational()[rowIndex - network.getProducerCount()].getAdress() + " (Н)";
            }
            return network.getRegional()[rowIndex - network.getProducerCount() - network.getNationalCount()].getAdress() + " (Р)";
        }

        if (columnIndex < network.getNationalCount() + 1) {
            if (rowIndex < network.getProducerCount()) {
                return (network.getNational()[columnIndex - 1].getRoutes().containsKey(rowIndex)) ? Boolean.TRUE : Boolean.FALSE;
            }
            return Boolean.FALSE;
        }

        if (columnIndex < network.getNationalCount() + network.getRegionalCount() + 1) {
            int newRowIndex = rowIndex - network.getProducerCount();
            int newColumnIndex = columnIndex - network.getNationalCount() - 1;
            if ((newRowIndex >= 0) && (newRowIndex < network.getNationalCount())) {
                return (network.getRegional()[newColumnIndex].getRoutes().containsKey(newRowIndex)) ? Boolean.TRUE : Boolean.FALSE;
            }
            return Boolean.FALSE;
        }

        int newRowIndex = rowIndex - network.getProducerCount() - network.getNationalCount();
        int newColumnIndex = columnIndex - network.getNationalCount() - network.getRegionalCount() - 1;
        if ((newRowIndex >= 0) && (newRowIndex < network.getLocalCount())) {
            return (network.getLocal()[newColumnIndex].getRoutes().containsKey(newRowIndex)) ? Boolean.TRUE : Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    private int getRowSector(int row) {
        if (row >= 0 && row < m1)
            return 1;
        if (row >= m1 && row < m1 + m2)
            return 2;
        if (row >= m1 + m2 && row < m1 + m2 + m3)
            return 3;

        return -1;
    }

    private int getNameColumnSector(int column) {
        if (column >= 0 && column <= m1)
            return 1;
        if (column >= m1 + 1 && column <= m1 + m2)
            return 2;
        if (column >= m1 + m2 + 1 && column <= m1 + m2 + m3)
            return 3;
        if (column >= m1 + m2 + m3 + 1 && column <= m1 + m2 + m3 + m4)
            return 4;

        return -1;
    }

    private int getColumnSector(int column) {
        if (column >= 0 && column < m1)
            return 1;
        if (column >= m1 && column < m1 + m2)
            return 2;
        if (column >= m1 + m2 && column < m1 + m2 + m3)
            return 3;
        if (column >= m1 + m2 + m3 && column < m1 + m2 + m3 + m4)
            return 4;

        return -1;

    }

    public void setValues(int m1, int m2, int m3, int m4) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;

        this.mc = m1 + m2 + m3 + m4;
        this.mr = m1 + m2 + m3;

        // updateData();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return "".getClass();
        }
        return Boolean.TRUE.getClass();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.fireTableDataChanged();

    }

}
