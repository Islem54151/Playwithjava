package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.Optional;

public class Level2 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Retourner le nombre des employés dont le nom commence avec n */

		long nbr = employees.stream()
				.filter(e -> e.getName().startsWith("n"))
				.count();

		/* TO DO 2: Retourner la somme des salaires de tous les employés (hint: mapToInt) */

		long sum = employees.stream()
				.mapToLong(Employee::getSalary)
				.sum();

		/* TO DO 3: Retourner la moyenne des salaires des employés dont le nom commence avec s */

		double average = employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);

		/* TO DO 4: Retourner la liste de tous les employés */

		List<Employee> emps = employees.stream()
				.toList();

		/* TO DO 5: Retourner la liste des employés dont le nom commence par s */

		List<Employee> emps2 = employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.toList();

		/* TO DO 6: Retourner true si il y a au moins un employé dont le salaire > 1000, false sinon */

		boolean test = employees.stream()
				.anyMatch(e -> e.getSalary() > 1000);

		/* TO DO 7: Afficher le premier employé dont le nom commence avec s avec deux manières différentes */
		/* First way */
		System.out.println("To DO 7 :");
		Optional<Employee> firstEmp = employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.findFirst();
		firstEmp.ifPresent(System.out::println);

		/* Second way */
		employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.limit(1)
				.forEach(System.out::println);

		/* TO DO 8: Afficher le second employé dont le nom commence avec s */
		System.out.println("To DO 8 :");
		employees.stream()
				.filter(e -> e.getName().startsWith("s"))
				.skip(1)
				.findFirst()
				.ifPresent(System.out::println);
	}
}
