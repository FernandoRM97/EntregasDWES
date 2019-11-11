package Laboral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws IOException, SQLException {

		OpcionesMenu om = new OpcionesMenu();

		Scanner s = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);

		int op = 0;

		do {
			System.out.println("-----MENÚ PRINCIPAL-----");
			System.out.println("1. APARTADO 1 DEL EXAMEN(FICHEROS)");
			System.out.println("2. APARTADO 2 DEL EXAMEN(BD)");
			System.out.println("3. APARTADO 3 DEL EXAMEN(INSERTAR EMPLEADO)");
			System.out.println("4. INFORMACIÓN DE TODOS LOS EMPLEADOS");
			System.out.println("5. BUSCAR SALARIO DE UN EMPLEADO");
			System.out.println("6. MODIFICAR DATOS DE UN EMPLEADO");
			System.out.println("7. ACTUALIZAR SUELDO DE UN EMPLEADO");
			System.out.println("8. ACTUALIZAR SUELDO DE TODOS LOS EMPLEADOS");
			System.out.println("9. REALIZAR COPIA DE SEGURIDAD EN UN FICHERO");
			System.out.println("10. SALIR");
			op = s.nextInt();

			if (op == 1) {
				om.opcion1escribe();
				om.opcion1lee();
				om.opcion1actualiza();
				om.opcion1lee();
				om.opcion1binario();
			} else if (op == 2) {
				System.out.println("La definición de la base de datos y la inserción de los dos primeros registros "
						+ "está guardado en un .sql");
			} else if (op == 3) {
				// Aqui tira la exception NoSuchElementException pero no le encuentro solución,
				// aun asi mete correctamente
				// los datos en base de datos
				try {
					om.altaEmpleado();
				} catch (NoSuchElementException e) {
					System.out.println("No se por que tira exception");
				}

			} else if (op == 4) {
				om.opcion4();
			} else if (op == 5) {
				om.opcion5();
			} else if (op == 6) {
				om.opcion6();
			} else if (op == 7) {

			} else if (op == 8) {

			} else if (op == 9) {
				om.opcion9();
			}

		} while (op != 10);

		s.close();
		ss.close();

	}

}