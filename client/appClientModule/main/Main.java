package main;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.ejb.entity.Employee;
import edu.app.ejb.entity.Project;
import edu.app.ejb.stateless.EmployeeProjectManagerRemote;

public class Main {
	
	
	
	
	private void foo() throws NamingException {
		InitialContext ctx= new InitialContext();
		EmployeeProjectManagerRemote remote = (EmployeeProjectManagerRemote)ctx.lookup("app/EmployeeProjectManager/remote");
		Employee e = remote.findEmployeeById(2);
		System.out.println(e);
		Project p = remote.findProjectById(1);
		System.out.println(p);
		remote.removeEmployeeFromProject(e, p);

	}
	public static void main(String[] args) throws NamingException {
		new Main().foo();
	}

	

}