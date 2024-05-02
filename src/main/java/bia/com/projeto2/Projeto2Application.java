package bia.com.projeto2;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projeto2Application {

	public static void main(String[] args)  throws ParseException{
		SpringApplication.run(Projeto2Application.class, args);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Digite os dados do Funcionário: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Nível: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário Bruto: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("Quantos contratos tem este funcionário?: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (i+1) + "º contrato");
			System.out.print("Data(DD/MM/AAAA): ");
			Date contracDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contracDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Digite o mês e o ano para calcular o salário(MM/AAAA): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Salário de: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();






	}

}
