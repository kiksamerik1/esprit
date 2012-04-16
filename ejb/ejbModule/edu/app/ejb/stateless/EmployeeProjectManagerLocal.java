package edu.app.ejb.stateless;
import java.util.List;

import javax.ejb.Local;

import edu.app.ejb.entity.Employee;
import edu.app.ejb.entity.Project;

@Local
public interface EmployeeProjectManagerLocal {
	
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void removeEmployee(Employee employee);
	Employee findEmployeeById(Integer id);
	List<Employee> findAllEmployees();
	List<Employee> searchEmployeesByKeyword(String keyword);
	
	void createProject(Project project);
	void updateProject(Project project);
	void removeProject(Project project);
	Project findProjectById(Integer id);
	List<Project> findAllProjects();
	List<Project> searchProjectsByKeyword(String keyword);
	
	
	void removeEmployeeFromProject(Employee employee, Project project);
	void assignEmployeeToProject(Employee employee, Project project, String role);

}
