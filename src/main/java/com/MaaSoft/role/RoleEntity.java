package com.MaaSoft.role;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.MaaSoft.configuration.BaseInfo;
import com.MaaSoft.user.UserEntity;

@Entity
@Table(name="role")
public class RoleEntity extends BaseInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	private String roleName;
	@ManyToMany(mappedBy = "roleEntities", cascade = CascadeType.DETACH)
	private List<UserEntity> userEntities = new ArrayList<UserEntity>();
	public RoleEntity() {
	}
	public RoleEntity(String roleName, List<UserEntity> userEntities) {
		this.roleName = roleName;
		this.userEntities = userEntities;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserEntity> getUserEntities() {
		return userEntities;
	}
	public void setUserEntities(List<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}
	
	
	

}
