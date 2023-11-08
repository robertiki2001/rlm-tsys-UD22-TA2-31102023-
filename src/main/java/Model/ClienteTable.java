package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTable extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
    private String[] columnNames = {"id", "nombre", "apellido", "direccion", "dni", "fecha"};

    public ClienteTable(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public List<Cliente> getClientes() {
		return clientes;
	}


	// Metodo para obtener el cliente en una fila específica
    public Cliente getCliente(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < clientes.size()) {
            return clientes.get(rowIndex);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cliente.getId();
            case 1:
                return cliente.getNombre();
            case 2:
                return cliente.getApellido();
            case 3:
                return cliente.getDireccion();
            case 4:
                return cliente.getDni();
            case 5:
                return cliente.getFecha();
            default:
                return null;
        }
    }  
    
    public void removeRowAt(int row) 
    {
    	List<Cliente> nuevaTabla = new ArrayList<Cliente>();
    	
    	for (int i = 0; i < this.clientes.size(); i++) 
    	{
    		if(i != row)
			nuevaTabla.add(this.clientes.get(i));
		}
    	
    	this.clientes = nuevaTabla;
    }
}
