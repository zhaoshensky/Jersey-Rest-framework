package com.sdc.utils.weixinUtil;

import java.util.Date;

public abstract class BaseInfo {
	//主键
	private long id;
	// 创建时间
	private Date createTime;
	// 创建用户
	private int createUser;
	// 修改用户
	private int updateUser;
	// 修改时间
	private Date updateTime;
	//创建用户
	private String strCreateUser;
	//修改用户
	private String strUpdateUser;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public int getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStrCreateUser() {
		return strCreateUser;
	}

	public void setStrCreateUser(String strCreateUser) {
		this.strCreateUser = strCreateUser;
	}

	public String getStrUpdateUser() {
		return strUpdateUser;
	}

	public void setStrUpdateUser(String strUpdateUser) {
		this.strUpdateUser = strUpdateUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
