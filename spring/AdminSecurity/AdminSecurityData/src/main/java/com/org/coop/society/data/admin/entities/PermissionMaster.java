package com.org.coop.society.data.admin.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the permission_master database table.
 * 
 */
@Entity
@Table(name="permission_master")
@NamedQuery(name="PermissionMaster.findAll", query="SELECT p FROM PermissionMaster p")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class PermissionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_id")
	private int permissionId;

	@Column(name="create_date", updatable=false)
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private String permission;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="update_date", insertable=false)
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="delete_ind")
	private String deleteInd;
	
	//bi-directional many-to-one association to ModuleMaster
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="module_id")
	private ModuleMaster moduleMaster;

	//bi-directional many-to-one association to RolePermission
	@OneToMany(mappedBy="permissionMaster", fetch = FetchType.LAZY, cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	private List<RolePermission> rolePermissions;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + permissionId;
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
		PermissionMaster other = (PermissionMaster) obj;
		if (permissionId != other.permissionId)
			return false;
		return true;
	}

	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	
	public PermissionMaster() {
	}

	public int getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public ModuleMaster getModuleMaster() {
		return this.moduleMaster;
	}

	public void setModuleMaster(ModuleMaster moduleMaster) {
		this.moduleMaster = moduleMaster;
	}

	public List<RolePermission> getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public RolePermission addRolePermission(RolePermission rolePermission) {
		getRolePermissions().add(rolePermission);
		rolePermission.setPermissionMaster(this);

		return rolePermission;
	}

	public RolePermission removeRolePermission(RolePermission rolePermission) {
		getRolePermissions().remove(rolePermission);
		rolePermission.setPermissionMaster(null);

		return rolePermission;
	}
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
	    updateDate = new Timestamp(System.currentTimeMillis());
	    if (createDate == null) {
	    	createDate = new Timestamp(System.currentTimeMillis());
	    }
	}
}