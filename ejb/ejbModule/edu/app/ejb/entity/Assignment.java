package edu.app.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "t_assignment" )
public class Assignment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136576129760016122L;
	
	@Embeddable
	public static class Id implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -5129284485928448034L;
		
		
		private Integer employeeId;
		private Integer projectId;
		private String role;
		
		public Id() {
		}

		public Id(Integer employeeId, Integer projectId, String role) {
			this.employeeId = employeeId;
			this.projectId = projectId;
			this.role = role;
		}
		
		@Column( name = "employee_fk" )
		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}
		
		@Column( name = "project_fk" )
		public Integer getProjectId() {
			return projectId;
		}

		public void setProjectId(Integer projectId) {
			this.projectId = projectId;
		}

		@Column( name = "role" )
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((employeeId == null) ? 0 : employeeId.hashCode());
			result = prime * result
					+ ((projectId == null) ? 0 : projectId.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (employeeId == null) {
				if (other.employeeId != null)
					return false;
			} else if (!employeeId.equals(other.employeeId))
				return false;
			if (projectId == null) {
				if (other.projectId != null)
					return false;
			} else if (!projectId.equals(other.projectId))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			return true;
		}

	}
	
	private Id id;
	private Employee employee;
	private Project project;
	
	public Assignment() {
	}

	public Assignment(Project project, Employee employee, String role) {
		this.getId().setEmployeeId(employee.getId());
		this.getId().setProjectId(project.getId());
		this.getId().setRole(role); 
		this.employee = employee;
		this.project = project;
	}

	@EmbeddedId
	public Id getId() {
		if(id == null)
			id = new Id();
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn( name = "employee_fk", insertable = false, updatable = false )
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne
	@JoinColumn( name = "project_fk", insertable = false, updatable = false )
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
