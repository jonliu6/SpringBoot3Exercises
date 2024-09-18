package org.freecode.demo.springboot3core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// Note: Primary has lower priority than Qualifier
@Primary
public class DatabaseAdministrator implements ITProjectResource {
	
	public DatabaseAdministrator() {
		System.out.println("DatabaseAdministrator constructor called");
	}

	@Override
	public String showTitle() {
		return "DBA";
	}

}
