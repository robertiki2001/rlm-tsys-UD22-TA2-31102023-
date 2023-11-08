package Model;

import java.sql.Date;

public class Cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private java.sql.Date fecha;

	
    // Constructor
    public Cliente(int id, String nombre, String apellido, String direccion, int dni, java.sql.Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha = fecha;
    }
	
	public Cliente() {		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Date getFecha() {
		return (Date) fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = (Date) fecha;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + ", fecha=" + fecha + "]";
	}
	

}
