/**
 * 
 */
package com.iStudy.springboot.model;

import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Role {
	
	private String id;
	
    private String roleName;
    
    private Set<Permissions> permissions;
    
	public Role(String id, String roleName, Set<Permissions> permissions) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permissions = permissions;
	}
	public Set<Permissions> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
