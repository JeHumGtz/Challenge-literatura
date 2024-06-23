package com.alurachalleng.Challenge_Literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ChallengeLiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		GutendexService service = new GutendexService();

		boolean running = true;
		while (running) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Buscar por título");
			System.out.println("2. Listar libros registrados");
			System.out.println("3. Listar autores registrados");
			System.out.println("4. Lista de autores vivos en el año");
			System.out.println("5. Salir");
			System.out.print("Opción: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consumir nueva línea

			switch (option) {
				case 1:
					System.out.print("Ingrese el título del libro: ");
					String title = scanner.nextLine();
					service.searchByTitle(title);
					break;
				case 2:
					service.listRegisteredBooks();
					break;
				case 3:
					service.listRegisteredAuthors();
					break;
				case 4:
					System.out.print("Ingrese el año: ");
					int year = scanner.nextInt();
					scanner.nextLine(); // Consumir nueva línea
					service.listAuthorsAliveInYear(year);
					break;
				case 5:
					running = false;
					break;
				default:
					System.out.println("Opción inválida.");
					break;
			}
		}

		System.out.println("¡Hasta luego!");
		scanner.close();
	}
}
