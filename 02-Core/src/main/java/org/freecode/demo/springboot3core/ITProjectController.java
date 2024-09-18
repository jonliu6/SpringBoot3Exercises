package org.freecode.demo.springboot3core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ITProjectController {
	
	private ITProjectResource dba;
	private ITProjectResource developer;

	// @Autowired // optional
//	public ITProjectController(@Qualifier("databaseAdministrator") ITProjectResource aDBA, @Qualifier("softwareDeveloper") ITProjectResource aDeveloper) {
//		// System.out.println("ITProjectController constructor called to set a DBA and a Developer");
//	    dba = aDBA;
//		developer = aDeveloper;
//	}
	
	@Autowired
	public void setDba(@Qualifier("databaseAdministrator") ITProjectResource aDBA) {
		System.out.println("setDba() called to set a DBA");
		dba = aDBA;
	}
	
	@Autowired
	public void setDeveloper(@Qualifier("softwareDeveloper") ITProjectResource aDeveloper) {
		System.out.println("setDba() called to set a Developer");
		developer = aDeveloper;
	}
	
	@GetMapping("/introduce")
	// URL: http://localhost:8000/sb3core/introduce
	public String introduce() {
		StringBuilder sb = new StringBuilder();
		sb.append("I'm a " + dba.showTitle() + "<br/>");
		sb.append("I'm a " + developer.showTitle() + "<br />");
		
		return sb.toString();
	}
}
