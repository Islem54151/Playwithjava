package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Afficher tous les employés */
		System.out.println("To DO 1 :");
		employees.stream().forEach(System.out::println);

		/*
		 * TO DO 2: Afficher les employés dont le nom commence par la lettre n
		 */
		System.out.println("To DO 2 :");
		employees.stream()
				.filter(e -> e.getName().startsWith("n"))
				.forEach(System.out::println);

		/*
		 * TO DO 3: Afficher les employés dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
		System.out.println("To DO 3 :");
		employees.stream()
				.filter(e -> e.getName().startsWith("n") && e.getSalary() > 1000)
				.forEach(System.out::println);

		/*
		 * TO DO 4: Afficher les employés dont le nom commence par la lettre s
		 * triés par salaire
		 */
		System.out.println("To DO 4 :");
		employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.sorted((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
				.forEach(System.out::println);

		/*
		 * TO DO 5: Afficher les noms des employés dont le salaire > 600 avec 2
		 * manières différentes
		 */
		/* First Way */
		System.out.println("To DO 5 :");
		employees.stream()
				.filter(e -> e.getSalary() > 600)
				.forEach(e -> System.out.println(e.getName()));

		/* Second Way */
		employees.stream()
				.filter(e -> e.getSalary() > 600)
				.map(Employee::getName)
				.forEach(System.out::println);

		/*
		 * TO DO 6: Ajouter 200 D pour les employés dont le nom commence avec m
		 * et les afficher ensuite
		 */
		System.out.println("To DO 6 :");
		employees.stream()
				.filter(e -> e.getName().startsWith("m"))
				.peek(e -> e.setSalary(e.getSalary() + 200))
				.forEach(System.out::println);
	}
}
