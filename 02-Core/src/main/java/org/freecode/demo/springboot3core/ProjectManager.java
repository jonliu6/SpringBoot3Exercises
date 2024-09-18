package org.freecode.demo.springboot3core;

import org.springframework.stereotype.Component;

@Component
public class ProjectManager implements ITProjectResource {

	public ProjectManager() {
		System.out.println("ProjectManager constructor called");
	}

	@Override
	public String showTitle() {
		return "PM";
	}
}
