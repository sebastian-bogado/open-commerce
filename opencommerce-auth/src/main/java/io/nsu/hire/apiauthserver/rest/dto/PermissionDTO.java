package io.nsu.hire.apiauthserver.rest.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class PermissionDTO implements GrantedAuthority {
	private String name;

	@Override
	public String getAuthority() {
		return this.name;
	}
}
