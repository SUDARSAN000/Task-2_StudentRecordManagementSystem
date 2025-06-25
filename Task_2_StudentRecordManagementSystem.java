package Day_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task_2_StudentRecordManagementSystem {
	
	private static final Scanner scanner = new Scanner(System.in);
	private static final List<Students> studentsList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		System.out.println("___ Welcomw To Student Record Management System ___\n");
		
		while(true) {
			showMenu();
			int choice = getChoice();
			try {
				switch(choice) {
					case 1 -> addStudent();
					case 2 -> viewStudent();
					case 3 -> updateStudent();
					case 4 -> deleteStudent();
					case 5 -> searchByName();
					case 6 -> sortByMark();
					case 7 -> viewTopper();
					case 8 -> clearAll();
					case 9 -> searchById();
					case 0 -> { System.out.println("Exiting... Thank you ^-^ \n");return;}
					default -> System.out.println("Invalid choice! Please select from 0 to 9 \n");
			}
		  }
		  catch(InputMismatchException e) {
			  System.out.println("Invalid Input! Please try again...\n");
			  scanner.nextLine();
		  }
		}
		
		
	}

	private static void searchById() {
		System.out.print("Enter id : ");
		int id = scanner.nextInt();
		
		Students student = findById(id);
		if(student == null) {
			System.out.println("No Students Record found !\n");
			return;
		}
		System.out.println("StudentID   : "+student.getId());
		System.out.println("StudentName : "+student.getName());
		System.out.println("StudentMark : "+student.getMark()+"\n");
	}

	private static void clearAll() {
		studentsList.clear();
		System.out.println("All students records have been cleared...\n");
	}

	private static void viewTopper() {
		
		if(studentsList.isEmpty()) {
			System.out.println("No Student Records to Sort !\n");
			return;
		}
		Students topper = Collections.max(studentsList,
				          Comparator.comparingDouble(Students::getMark));
		System.out.println("Top Ranking : "+topper+"\n");
	}

	private static void sortByMark() {
		
		if(studentsList.isEmpty()) {
			System.out.println("No Student Records to Sort !\n");
			return;
		}
		studentsList.stream()
		.sorted(Comparator.comparingDouble(Students::getMark).reversed())
		.forEach(System.out::println);
		System.out.println();
	}

	private static void searchByName() {
		
		System.out.print("Enter StudentName : ");
		String name = scanner.next();
		
		List<Students> student = findByName(name);
		if(student == null) {
			System.out.println("No Matching Student Found !\n");
			return;
		}
		System.out.println("Matched Students : \n");
		student.forEach(System.out::println);
		System.out.println();
	}

	private static void deleteStudent() {
		
		System.out.print("Enter the StudentID : ");
		int id =scanner.nextInt();
		
		Students student = findById(id);
		if(student == null) {
			System.out.println("Student not found!\n");
			return;
		}
		studentsList.remove(student);
		System.out.println("Student removed sucessfully...\n");
	}

	private static void updateStudent() {
		System.out.print("Enter the StudentID : ");
		int id = scanner.nextInt();
		
		Students student = findById(id);
		if(student == null) {
			System.out.println("Student not found! \n");
			return;
		}
		System.out.print("Enter new name :");
		String name = scanner.next();
		System.out.print("Enter new mark : ");
		double mark = scanner.nextDouble();
		
		student.setName(name);
		student.setMark(mark);
		System.out.println("Student Updated Sucessfully...\n");
		
	} 

	private static void viewStudent() {
		if(studentsList.isEmpty()) {
			System.out.println("No Student Records Found !\n");
			return;
		}
		System.out.println("Student Records :\n");
		studentsList.forEach(System.out::println);
		System.out.println();
	}

	private static void addStudent() {
		try {
			System.out.print("Enter StudentID : ");
			int id =scanner.nextInt();
			System.out.print("Enter StudentName : ");
			String name =scanner.next();
			System.out.print("Enter StudentMark : ");
			double mark =scanner.nextDouble();
			
			Students student = new Students(id, name, mark);
			studentsList.add(student);
			System.out.println("Student added sucessfully...\n");
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input! Please try again \n");
			scanner.nextLine();
		}
	}

	private static int getChoice() {
		try {
			return scanner.nextInt();
		}
		catch(InputMismatchException e) {
			scanner.nextLine();
			return -1;
		}
	}

	private static void showMenu() {
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. SearchByName");
		System.out.println("6. SortByMarks");
		System.out.println("7. ViewTopper");
		System.out.println("8. ClearAll");
		System.out.println("9. SearchByID");
		System.out.println("0. Exit\n");
		System.out.print("Enter the choice : ");

	}
	
	private static Students findById(int id) {
		
		for(Students student : studentsList) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	private static List<Students> findByName(String name) {

		List<Students> studentList = new ArrayList<>();
		String sName = name.toLowerCase();
		for(Students student : studentsList) {
			if(student.getName().toLowerCase().equalsIgnoreCase(sName)) {
				studentList.add(student);
			}
		}
		return studentList;
	}

}
