package Controler;

import Student.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentController {
	ArrayList<Student> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void start() {

		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("\t\t 👨‍💻 *** Student Management System *** 👨‍💻");
			System.out.println(
					"\n1. Add\n2. Display All\n3. Search\n4. Delete\n5. Update\n6. Sort by Name\n7. Sort by Marks\n8. Exit");
			System.out.println("---------------------------------------------------------------");
			System.out.println("\t\t*** Enter Your Choice ***");
			int choice = sc.nextInt();
			System.out.println("---------------------------------------------------------------");
			switch (choice) {
			case 1:
				System.out.println("\t\t *** You Choiced Add Student ***");
				addStudent();
				break;
			case 2:
				System.out.println("\t\t *** You Choiced Display All Student ***");
				displayAll();
				break;
			case 3:
				System.out.println("\t\t *** You Choiced Search An Student ***");
				searchStudent();
				break;
			case 4:
				System.out.println("\t\t *** You Choiced Delete Student ***");
				deleteStudent();
				break;
			case 5:
				System.out.println("\t\t *** You Choiced Update An Student ***");
				updateStudent();
				break;
			case 6:
				System.out.println("\t\t *** You Choiced Sorted List By Student Names ***");
				sortByName();
				break;
			case 7:
				System.out.println("\t\t *** You Choiced Sorted List By Student Marks ***");
				sortByMarks();
				break;
			case 8:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	void addStudent() {
		System.out.println("Enter Roll, Name, Marks:");
		int roll = sc.nextInt();
		String name = sc.next();
		double marks = sc.nextDouble();
		
		boolean isFound = false;
		for (Student s : list) {
			if (s.getRoll() == roll) {
				System.out.println("Student With Id "+roll+" Already Exits");
				isFound = true;
			}
		}
		
		if(!isFound) {
			list.add(new Student(roll, name, marks));
			System.out.println("Student With Id "+roll+" Added Successfully");	
		}
		
	}

	void displayAll() {
		for (Student s : list) {
			System.out.println(s.toString());
		}
	}

	void searchStudent() {
		System.out.print("Enter Roll No To Search Student : ");
		int r = sc.nextInt();
		boolean found = false;
		for (Student s : list) {
			if (s.getRoll() == r) {
				System.out.println(s.toString());
				found = true;
			}
		}
		if (!found)
			System.out.println("Student with ID " + r + " Not found.");
	}

	void deleteStudent() {
		System.out.print("Enter Roll to Delete: ");
		int r = sc.nextInt();
		Iterator<Student> it = list.iterator();
		boolean removed = false;
		while (it.hasNext()) {
			if (it.next().getRoll() == r) {
				it.remove();
				System.out.println("Student with ID " + r + " Deleted Successfully.");
				removed = true;
				break;
			}
		}
		if (!removed)
			System.out.println("Student with ID " + r + " Not found.");
	}

	void updateStudent() {
		System.out.print("Enter Roll to Update: ");
		int r = sc.nextInt();
		for (Student s : list) {
			if (s.getRoll() == r) {
				System.out.print("Enter new Name & Marks: ");
				String name = sc.next();
				double marks = sc.nextDouble();
				s.setName(name);
				s.setMarks(marks);
				System.out.println("Student with ID " + r + " Updated Successfully.");
				return;
			}
		}
		System.out.println("Student with ID " + r + " Not found.");
	}

	void sortByName() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (Student.compareNames(list.get(i).getName(), list.get(j).getName()) > 0) {
					Student temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println("Sorted by Name:");
		displayAll();
	}

	void sortByMarks() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getMarks() < list.get(j).getMarks()) {
					Student temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println("Sorted by Marks:");
		displayAll();
	}
}
