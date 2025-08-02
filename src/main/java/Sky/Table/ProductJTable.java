package Sky.Table;

import Sky.Cat.model.Product;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProductJTable extends AbstractTableModel {
    private final String[] columnName = {
            "Product Code", "Product Name",
            "Import Price", "Profit Rate",
            "Selling Price", "Import Date",
            "Company Code", "Stock Quantity",
            "Warranty", "Is Business Model"
    };

    private List<Product> productList;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ProductJTable() {}

    public ProductJTable(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getRowCount() {
        return productList != null ? productList.size() : 0;
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
            case 0, 1, 5, 6, 8 -> {
                return String.class;
            }
            case 2, 3, 4 -> {
                return Double.class;
            }
            case 7 -> {return Integer.class;}
            case 9 -> {return Boolean.class;}
            default -> {return Object.class;}
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (productList == null || rowIndex >= productList.size()) {
            return null;
        }

        Product product = productList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {return product.getProductCode();}
            case 1 -> {return product.getProductName();}
            case 2 -> {return product.getImportPrice();}
            case 3 -> {return product.getProfitRate();}
            case 4 -> {return product.getSellingPrice();}
            case 5 -> {return product.getImportDate() != null ? dateFormat.format(product.getImportDate()) : null;}
            case 6 -> {return product.getCompanyCode();}
            case 7 -> {return product.getStockQuantity();}
            case 8 -> {return product.getWarranty();}
            case 9 -> {return product.isBusinessModel();}
            default -> {return null;}
        }
    }

    public void updateData(List<Product> productList) {
        this.productList = productList;
        fireTableDataChanged();
    }

    public Product getProductAt(int rowIndex) {
        if (productList != null && rowIndex >= 0 && rowIndex < productList.size()) {
            return productList.get(rowIndex);
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
