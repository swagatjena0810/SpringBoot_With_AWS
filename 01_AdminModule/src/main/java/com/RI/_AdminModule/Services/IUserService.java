package com.RI._AdminModule.Services;

import java.util.List;


import com.RI._AdminModule.Entities.User;

public interface IUserService {

	public User addCaseworker(User caseworker);
	
	public User updateCaseworker(User caseworker);
	
	public String deactivateCaseworker(String emailId);
	
	public String activateCaseworker(String emailId);
	
	public List<User> viewCaseworkerList();
	
	public String Login(String emailId, String userPassword);
	
	public String forgotPassword(String userPassword);
	
	public String changePassword(String oldPassword,String newPassword);
	
}
