package Sky.Table;

import Sky.Cat.Main;
import dbConnect.models.ITRequest;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ITRequestJTable extends AbstractTableModel {
    private final String[] columnName = {
            "ID", "Requester",
            "Date", "Contact Email",
            "Task (Request type)", "Additional Note"
    };

    private List<ITRequest> itRequestList;

    public ITRequestJTable() {}

    public ITRequestJTable(List<ITRequest> itRequestList) {
        this.itRequestList = itRequestList;
    }

    @Override
    public int getRowCount() {
        return itRequestList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ITRequest itRequest = itRequestList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                if (Main.getDatabaseMode() == Main.DatabaseMode.MongoDB) {
                    return itRequest.get_id().toString();
                } else if (Main.getDatabaseMode() == Main.DatabaseMode.MySQL) {
                    return itRequest.getReqID();
                }
                else return null;
            }
            case 1 -> {
                return itRequest.getReqName();
            }
            case 2 -> {
                return itRequest.getReqDate();
            }
            case 3 -> {
                return itRequest.getReqEmail();
            }
            case 4 -> {
                return itRequest.getReqType();
            }
            case 5 -> {
                return itRequest.getReqDetails();
            }
            default -> {return null;}
        }
    }

    public void updateData(List<ITRequest> itRequestList) {
        this.itRequestList = itRequestList;
        fireTableDataChanged();
    }

    public ITRequest getRequestAt(int rowIndex) {
        return itRequestList.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

    @Override
    public void setValueAt(Object valueAt, int rowIndex, int columnIndex) {}
}
