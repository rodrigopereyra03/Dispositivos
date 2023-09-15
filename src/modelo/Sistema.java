package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empresa> lstEmpresas;
	private List<Dispositivo> lstDispositivos;
	
	
	public Sistema() {
		super();
		this.lstEmpresas = new ArrayList<>();
		this.lstDispositivos = new ArrayList<>();
	}

	
	public boolean agregarEmpresa(String nombre) {
		int id=1;
		if(lstEmpresas.size()>0) {
			int tamanio = lstEmpresas.size();
			id = lstEmpresas.get(tamanio-1).getIdEmpresa()+1;
		}
		return lstEmpresas.add(new Empresa(id,nombre));
	}

	public Empresa traerEmpresa(String nombre) {
		boolean flag = false;
		Empresa devolverEmpresa = null;
		
		int i=0;
		while(i<lstEmpresas.size()&&!flag) {
			if(lstEmpresas.get(i).getNombre().equals(nombre)) {
				flag = true;
				devolverEmpresa = lstEmpresas.get(i);
			}
			i++;
		}
		return devolverEmpresa;
	}
	
	public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		if(traerDispositivo(codigo)!=null) {
			throw new Exception("Error: dispositivo ya agregado");
		}
		int id =1;
		if(lstDispositivos.size()>0) {
			int tamanio = lstDispositivos.size();
			id = lstDispositivos.get(tamanio-1).getIdDispositivo()+1;
		}
		return lstDispositivos.add(new Dispositivo(id, nombre, codigo,empresa));	
	}
	
	public Dispositivo traerDispositivo(String codigo) {
		boolean flag = false;
		Dispositivo devolverDispositivo = null;
		int i = 0;
		while(i<lstDispositivos.size()&&!flag) {
			if(lstDispositivos.get(i).getCodigo().equals(codigo)) {
				flag = true;
				devolverDispositivo = lstDispositivos.get(i);
			}
			i++;
		}
		return devolverDispositivo;
	}
	
	
	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}


	public void setLstEmpresas(List<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
	}


	public List<Dispositivo> getLstDispositivos() {
		return lstDispositivos;
	}


	public void setLstDispositivos(List<Dispositivo> lstDispositivos) {
		this.lstDispositivos = lstDispositivos;
	}


	@Override
	public String toString() {
		return "Sistema [lstEmpresas=" + lstEmpresas + ", lstDispositivos=" + lstDispositivos + "]\n";
	}
	
	
}
