package edu.app.ejb.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.app.ejb.entity.Assignment;
import edu.app.ejb.entity.Employee;
import edu.app.ejb.entity.Project;

@Stateless
public class EmployeeProjectManager implements EmployeeProjectManagerRemote, EmployeeProjectManagerLocal {

	@PersistenceContext( unitName = "espritPU" )
	private EntityManager em;
	
    public EmployeeProjectManager() {
    }
    
	@Override
	public void createEmployee(Employee employee) {
		em.persist(em.merge(employee));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees;
		Query query = em.createQuery("select e from Employee e");
		employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return em.find(Employee.class, id);
	}

	@Override
	public void removeEmployee(Employee employee) {
		em.remove(em.merge(employee));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> searchEmployeesByKeyword(String keyword) {
		List<Employee> employees;
		Query query = em.createQuery(
			"select e from Employee e where UPPER(e.firstname) like :param or UPPER(e.lastname) like :param order by e.firstname, e.lastname");
		query.setParameter("param", "%" + keyword.toUpperCase() + "%");
		employees = query.getResultList();
		return employees;
	}

	@Override
	public void updateEmployee(Employee employee) {
		em.merge(employee);
		
	}
	
	@Override
	public void createProject(Project project) {
		em.persist(em.merge(project));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findAllProjects() {
		List<Project> projects;
		Query query = em.createQuery("select p from Project p");
		projects = query.getResultList();
		return projects;
	}

	@Override
	public Project findProjectById(Integer id) {
		return em.find(Project.class, id);
	}

	@Override
	public void removeProject(Project project) {
		em.remove(em.merge(project));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> searchProjectsByKeyword(String keyword) {
		List<Project> projects;
		Query query = em.createQuery(
			"select p from Project p where UPPER(p.name) like :param order by p.name");
		query.setParameter("param", "%" + keyword.toUpperCase() + "%");
		projects = query.getResultList();
		return projects;
	}

	@Override
	public void updateProject(Project project) {
		em.merge(project);
		
	}
	
	@Override
	public void removeEmployeeFromProject(Employee employee, Project project) {
		Assignment assignment = new Assignment(project, employee, "");
		em.remove(em.merge(assignment));
		
	}
	
	@Override
	public void assignEmployeeToProject(Employee employee, Project project, String role) {
		Assignment assignment = new Assignment(project, employee, role);
		em.persist(assignment);
	}
}
