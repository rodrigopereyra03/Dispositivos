package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Dispositivo;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sis = new Sistema();
		
		System.out.println("TEST 1");
		sis.agregarEmpresa("Empresa 1");
		sis.agregarEmpresa("Empresa 2");
		System.out.println(sis);
		
		System.out.println(sis.traerEmpresa("Empresa 2"));
		
		System.out.println("TEST 3");
		try {
			sis.agregarDispositivo("Sensor Humedad", "A2020", sis.traerEmpresa("Empresa 1"));
			sis.agregarDispositivo("Sensor Temperatura", "A2325", sis.traerEmpresa("Empresa 1"));
			sis.agregarDispositivo("Sensor Presion", "B2021", sis.traerEmpresa("Empresa 2"));
			sis.agregarDispositivo("Sensor Calor", "B2326", sis.traerEmpresa("Empresa 2"));
			System.out.println(sis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("TEST 4");
		try {
			sis.agregarDispositivo("Sensor Movimienro", "A2021", sis.traerEmpresa("Empresa 1"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TEST 5");
		System.out.println(sis.traerDispositivo("B2326"));
		
		System.out.println("TEST 6");
		Dispositivo disp = sis.traerDispositivo("B2326");
		disp.agregarMetricas(18, LocalDate.of(2022, 9, 18), LocalTime.of(10, 0));
		disp.agregarMetricas(19, LocalDate.of(2022, 9, 19), LocalTime.of(12, 30));
		disp.agregarMetricas(23, LocalDate.of(2022, 9, 20), LocalTime.of(15, 0));
		disp.agregarMetricas(20, LocalDate.of(2022, 9, 21), LocalTime.of(18, 30));
		disp.agregarMetricas(18, LocalDate.of(2022, 9, 22), LocalTime.of(22, 30));
		System.out.println(disp);
		
		System.out.println("TEST 7");
		System.out.println(disp.traerMetrica(LocalDate.of(2022, 9, 19), LocalTime.of(12, 30)));
		
		System.out.println("TEST 8");
		System.out.println(disp.traerMetricas(LocalDate.of(2022, 9, 19), LocalDate.of(2022, 9, 21)));
		
		System.out.println("TEST 9");
		System.out.println(disp.traerMetricas(sis.traerDispositivo("B2326") , LocalDate.of(2022, 9, 19), LocalDate.of(2022, 9, 21), 22));
	}

}
