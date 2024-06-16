package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);


		System.out.println("=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== Test 3: department insert ===");
		Department newDepartment =  new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New ID: " + newDepartment.getId());

		System.out.println("=== Test 4: department update ===");
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Update complete");

		System.out.println("=== Test 5: department delete ===");
		System.out.println("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}
}
