package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		//Configurações para I/O
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered ? ");
		int registersAmount = sc.nextInt();
		int i = 1;
		
		//Istanciando os elementos da lista 
		while (i <= registersAmount) {
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			//Validando id (não pode haver repetição).
			Employee resultId = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			if (resultId == null) {
				list.add(new Employee(id,name,salary));
				i++;
			}else {
				System.out.println("The id must be different !");
			}
		}
		
		//Recebendo id pertencente ao funcinário que terá aumento de salário.
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		
		//Verificando se o id passado existe.
		Employee result = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		
		if (result != null) {
			System.out.print("Enter percentage: ");
			double percentage = sc.nextDouble();
			result.increaseSalary(percentage);
			System.out.println();
		}else {
			System.out.print("This id does not exist !");
			System.out.println();
		}
		
		//Imprimindo dados dos elementos da lista.
		System.out.println("List of employees: ");
		for (Employee x : list) {
			System.out.println(x);
		}
	
		sc.close();
	}

}
