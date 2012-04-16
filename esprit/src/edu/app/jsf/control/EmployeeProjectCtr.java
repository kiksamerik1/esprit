package edu.app.jsf.control;

import java.util.List;

import javax.ejb.EJB;

import edu.app.ejb.entity.Employee;
import edu.app.ejb.entity.Project;
import edu.app.ejb.stateless.EmployeeProjectManagerLocal;

public class EmployeeProjectCtr {
	
	@EJB
	private EmployeeProjectManagerLocal local;
	
	private List<Employee> employees;
	private Employee employee;
	private List<Project> projects;
	private Project project;
	
	public EmployeeProjectCtr() {
	}
	
	public String createEmployee(){
		local.createEmployee(employee);
		return listEmployees();
	}
	public String newEmployee(){
		employee = new Employee();
		return "employees.new";
	}
	public String destroyEmployee(){
		local.removeEmployee(employee);
		return listEmployees();
	}
	public String updateEmployee(){
		local.updateEmployee(employee);
		return "employees.show";
	}
	public String listEmployees(){
		employees = local.findAllEmployees();
		return "employees.list";
	}
	
	
	public String createProject(){
		local.createProject(project);
		return listProjects();
	}
	public String newProject(){
		project = new Project();
		return "projects.new";
	}
	public String destroyProject(){
		local.removeProject(project);
		return listProjects();
	}
	public String updateProject(){
		local.updateProject(project);
		return "projects.show";
	}
	public String listProjects(){
		projects = local.findAllProjects();
		return "projects.list";
	}
	
	
	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
	
	
	

}
