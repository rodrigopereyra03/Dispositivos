package modelo;



public class Empresa {
	private int idEmpresa;
	private String nombre;
	
	public Empresa(int idEmpresa, String nombre) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nombre=" + nombre + "]\n";
	}

	
	
	
	
}
