package Sky.Table;

import Sky.Cat.model.Company;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CompanyJTable extends AbstractTableModel {
    private final String[] columnName = {
            "Company Code", "Company Name",
            "Tax Code", "Established Year",
            "Revenue", "Market Cap"
    };

    private List<Company> companyList;

    public CompanyJTable() {}

    public CompanyJTable(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public int getRowCount() {
        return companyList != null ? companyList.size() : 0;
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
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0, 1, 2, 4, 6, 7 -> {
                return String.class;
            }
            case 3 -> {
                return Integer.class;
            }
            case 5 -> {
                return Boolean.class;
            }
            default -> {
                return Object.class;
            }
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (companyList == null || rowIndex >= companyList.size()) return null;

        Company company = companyList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {return company.getCompanyCode();}
            case 1 -> {return company.getCompanyName();}
            case 2 -> {return company.getTaxCode();}
            case 3 -> {return company.getEstablishedYear() == 0 ? null : company.getEstablishedYear();}
            case 4 -> {return company.getWebsite();}
            case 5 -> {return company.isPublic();}
            case 6 -> {return company.getRevenue();}
            case 7 -> {return company.getMarketCap();}
            default -> {return null;}
        }
    }

    public void updateData(List<Company> companyList) {
        this.companyList = companyList;
        fireTableDataChanged();
    }

    public Company getCompanyAt(int rowIndex) {
        if (companyList != null && rowIndex >= 0 && rowIndex < companyList.size()) {
            return companyList.get(rowIndex);
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object valueAt, int rowIndex, int columnIndex) {}
}
