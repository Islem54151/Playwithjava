package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

import edu.esprit.game.utils.Data;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des employés */
		System.out.println("To DO 1 :");
		String names = employees.stream()
				.map(Employee::getName)
				.reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2);
		System.out.println(" names: " + names);

		/* TO DO 2: Retourner une chaine de caractère qui contient tous les noms des employés en majuscule séparés par # */
		System.out.println("To DO 2 :");
		String namesMajSplit = employees.stream()
				.map(Employee::getName)
				.map(String::toUpperCase)
				.collect(Collectors.joining("#"));
		System.out.println("Names separated by #: " + namesMajSplit);

		/* TO DO 3: Retourner un set d'employés */
		System.out.println("To DO 3 :");
		Set<Employee> emps = employees.stream().collect(Collectors.toSet());
		System.out.println("Set  employees: " + emps);

		/* TO DO 4: Retourner un TreeSet d'employés (tri par nom) */
		System.out.println("To DO 4 :");
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
		System.out.println("TreeSet des employees : " + emps2);

		/* TO DO 5: Retourner une Map qui regroupe les employés par salaire */
		System.out.println("To DO 5 :");
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("Map grouper par salary: " + map);

		/* TO DO 6: Retourner une Map qui regroupe les noms des employés par salaire */
		System.out.println("To DO 6 :");
		Map<Integer, String> mm = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
		System.out.println("Map grouped names by salary: " + mm);

		/* TO DO 7: Retourner le min, max, average, sum, count des salaires */
		System.out.println("To DO 7 :");
		IntSummaryStatistics stats = employees.stream()
				.collect(Collectors.summarizingInt(Employee::getSalary));
		System.out.println("Salary  min=" + stats.getMin() + ", max=" + stats.getMax() +
				", average=" + stats.getAverage() + ", sum=" + stats.getSum() + ", count=" + stats.getCount());
	}
}