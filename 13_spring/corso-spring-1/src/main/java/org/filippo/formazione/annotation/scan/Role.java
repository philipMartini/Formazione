package org.filippo.formazione.annotation.scan;

import org.springframework.stereotype.Component;

@Component(value = "roleBean")
public class Role {
	
	public String getRole() { return "Admin"; }
}
