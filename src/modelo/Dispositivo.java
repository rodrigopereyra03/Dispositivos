package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
	private int idDispositivo;
	private String nombre;
	private String codigo;
	private List<Metrica> lstMetricas;
	private Empresa empresa;
	
	
	public Dispositivo(int idDispositivo, String nombre, String codigo, Empresa empresa) throws Exception {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.setCodigo(codigo);
		this.lstMetricas = new ArrayList<>();
		this.empresa = empresa;
	}

	public boolean agregarMetricas(int valor,LocalDate fecha, LocalTime hora) {
		return lstMetricas.add(new Metrica(valor,fecha,hora));
	}
	public Metrica traerMetrica(LocalDate fecha, LocalTime hora) {
		boolean flag = false;
		Metrica met = null;
		int i = 0;
		while(i<lstMetricas.size()&&!flag) {
			if(lstMetricas.get(i).getFecha().equals(fecha) && lstMetricas.get(i).getHora().equals(hora)) {
				flag = true;
				met = lstMetricas.get(i);
			}
			i++;
		}
		return met;
	}
	
	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta){
		List<Metrica> listAux = new ArrayList<Metrica>();
		
		for(Metrica m : lstMetricas) {
			if((m.getFecha().isAfter(desde) || m.getFecha().equals(desde)) && (m.getFecha().isBefore(hasta) || m.getFecha().equals(hasta))) {
				listAux.add(m);
			}
		}
		return listAux;
	}
	
	public List<Metrica> traerMetricas(Dispositivo dispositivo,LocalDate desde, LocalDate hasta, int menorValor){
		List<Metrica> listM = new ArrayList<Metrica>();
		for(Metrica m : traerMetricas(desde,hasta)) {
			if( m.getValor() < menorValor)  {
				listM.add(m);
			}
		}
		return listM;
	}
	
	public int getIdDispositivo() {
		return idDispositivo;
	}


	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) throws Exception {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) throws Exception {
codigo = codigo.toUpperCase();
		
		if(codigo.length() != 5) {
			throw new Exception("El codigo debe ser de 5 caracteres...");
		}
		
		if(!Funciones.esCadenaNros(codigo.substring(1))){
			throw new Exception("Los 4 ultimos digitos del codigo, deben ser numeros");
		}
		
		int acum=0;
		for(int i=1; i<codigo.length() ; i++) {
			acum = acum + Character.getNumericValue(codigo.charAt(i));
		}
		
		char firstChar = codigo.charAt(0);
		switch(firstChar) {
			case 'A':
					
				if(acum % 2 != 0) {
					throw new Exception("Cuando el codigo comienza con A, la suma de sus digitos debe ser par");
				}
				break;
				
			case 'B':
				if(acum % 2 == 0) {
					throw new Exception("Cuando el codigo comienza con B, la suma de sus digitos debe ser impar");
				}
				break;
				
			default:
					throw new Exception("El codigo debe comenzar con a, o con b");
			}
		
		this.codigo=codigo;
	}


	public List<Metrica> getLstMetricas() {
		return lstMetricas;
	}


	public void setLstMetricas(List<Metrica> lstMetricas) {
		this.lstMetricas = lstMetricas;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", nombre=" + nombre + ", codigo=" + codigo
				+ ", lstMetricas=" + lstMetricas + ", empresa=" + empresa + "]\n";
	}


	
	
	


}
