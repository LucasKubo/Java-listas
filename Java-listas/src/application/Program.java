package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered ? ");
		int registersAmount = sc.nextInt();
		
		for (int i=1; i<=registersAmount; i++) {
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id,name,salary));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		
		Employee result = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		
		if (result != null) {
			System.out.print("Enter percentage: ");
			double percentage = sc.nextDouble();
			result.salaryIncrease(percentage);
			System.out.println();
		}else {
			System.out.print("This id does not exist !");
			System.out.println();
		}
			
		System.out.println("List of employees: ");
		for (Employee x : list) {
			System.out.println(x);
		}
	
		sc.close();
	}

}
