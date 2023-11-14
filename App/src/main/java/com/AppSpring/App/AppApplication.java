package com.AppSpring.App;

import com.AppSpring.App.Dao.UserRepository;
import com.AppSpring.App.Entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppApplication.class, args);


		UserRepository userRepository = context.getBean(UserRepository.class);

		Scanner scanner = new Scanner(System.in);

		int choice;

		while(true){
			System.out.println("CRUD Application Menu : ");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");

			System.out.println("Enter your choice : ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice){
				case 1:
					System.out.println("Creating a new person");
					Employee employee = new Employee();
					System.out.println("Enter the name : ");
					String name=scanner.nextLine();
					employee.setName(name);

					System.out.println("Enter the username : ");
					String username = scanner.nextLine();
					employee.setUsername(username);

					System.out.println("Enter the Mobile Number : ");
					String mobileno = scanner.nextLine();
					employee.setMobileNo(mobileno);


					System.out.println("Enter the Email : ");
					String email = scanner.nextLine();
					employee.setEmail(email);

					System.out.println("Enter the salary : ");
					int salary = scanner.nextInt();
					employee.setSalary(salary);

					userRepository.save(employee);
					System.out.println("Employee created successfully");
					break;

				case 2 :
					System.out.println("Listing all people : ");
					List<Employee> employees = new ArrayList<>();
					for(Employee employee1 : employees){
						System.out.println("Name : " + employee1.getName() + " " + "UserName : " + employee1.getUsername() + " " + "Mobile Number : " + employee1.getMobileNo() + " " + "Email : " + employee1.getEmail() + "Salary : " + employee1.getSalary());
						break;

					}
				case 3 :
					System.out.println("Updating a employee : ");
					System.out.println("Enter the id to update ");
					int idtoupdate =scanner.nextInt();
					scanner.nextLine();
					Optional<Employee> optional = userRepository.findById(idtoupdate);
					Employee employee3 = optional.get();
					System.out.println("Enter the name : ");
					String nametoupdate = scanner.nextLine();



					Employee result = userRepository.save(employee3);

					System.out.println("Updated");
					break;

				case 4 :
					System.out.println("Deleting a person!!😒😒");
					System.out.println("Enter the index to delete ");
					int idtodelete = scanner.nextInt();
					userRepository.deleteById(idtodelete);
					System.out.println("Deleted");


				case 5 :
					System.out.println("Exiting the application. GoodBye!!😊😊😊😊");
					scanner.close();
					System.exit(0);

				default:
					System.out.println("Invalid Choice . Please enter the number between 1 to 5");


			}

		}
	}

}
