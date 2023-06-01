package com.RI._AdminModule.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RI._AdminModule.Entities.User;
import com.RI._AdminModule.Exceptions.CaseWorkerAlreadyExistsException;
import com.RI._AdminModule.Exceptions.CaseworkerNotFoundException;
import com.RI._AdminModule.Exceptions.InvalidCredentialsException;
import com.RI._AdminModule.Repositories.UserRepository;
import com.RI._AdminModule.Utils.AppConstants;
import com.RI._AdminModule.Utils.EmailUtils;
import com.RI._AdminModule.Utils.PasswordUtils;
import com.RI._AdminModule.Utils.PasswordValidator;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Autowired
	private PasswordUtils passwordUtils;
	
	@Override
	public User addCaseworker(User caseworker) {
		Optional<User> user=this.userRepository.findByemailId(caseworker.getEmailId());
		if(user.isPresent()) {
			throw new CaseWorkerAlreadyExistsException(
					caseworker.getEmailId()+AppConstants.caseworkerExists);
		}
		else {
			String randomPass=passwordUtils.generateRandompwdUUID();
			caseworker.setUserPassword(randomPass);
			caseworker.setUserRole(AppConstants.roleCaseworker);
			String to=caseworker.getEmailId();
			String subject=AppConstants.passwordGeneratedSubject;
			String body=AppConstants.passwordGeneratedBody+randomPass;
			emailUtils.sendMail(subject, body, to);
			return userRepository.save(caseworker);
		}
	}
	
	

	@Override
	public User updateCaseworker(User caseworker) {
		Optional<User> user=this.userRepository.findByemailId(caseworker.getEmailId());
		if(user.isPresent()) {
			return userRepository.save(caseworker);
		}
		else {
			return addCaseworker(caseworker);
		}
	}

	
	
	@Override
	public String deactivateCaseworker(String emailId) {
		Optional<User> op=this.userRepository.findByemailId(emailId);
		if(op.isPresent()) {
			User user=op.get();
			user.setActive(false);
			userRepository.save(user);
			return user.getEmailId()+AppConstants.responseAfterAccountDeactivated;
		}
		else {
			throw new CaseworkerNotFoundException(AppConstants.emailNotRegistered+emailId);
		}
	}
	
	

	@Override
	public String activateCaseworker(String emailId) {
		Optional<User> op=this.userRepository.findByemailId(emailId);
		if(op.isPresent()) {
			User user=op.get();
			user.setActive(true);
			userRepository.save(user);
			return user.getEmailId()+AppConstants.responseAfterAccountActivated;
		}
		else {
			throw new CaseworkerNotFoundException(AppConstants.emailNotRegistered+emailId);
		}
	}

	
	
	@Override
	public List<User> viewCaseworkerList() {
		return this.userRepository.findAll();
	}



	@Override
	public String Login(String emailId, String userPassword) {
		Optional<User> opuser=this.userRepository.findByemailId(emailId);
		if(opuser.isPresent()) {
			if(opuser.get().getUserPassword().equals(userPassword)) {
				return AppConstants.loginSucess;
			}
			else {
				throw new InvalidCredentialsException(AppConstants.invalidPassword);
			}
		}
		else {
			throw new InvalidCredentialsException(AppConstants.emailNotRegistered + emailId);
			
		}
	}



	@Override
	public String forgotPassword(String emailId) {
		Optional<User> opu=this.userRepository.findByemailId(emailId);
		if(opu.isPresent()) {
			String to=emailId;
			String subject=AppConstants.forgotPasswordSubject;
			String body="<h2>"+"password :"+opu.get().getUserPassword()+"</h2>";
			emailUtils.sendMail(subject, body, to);
			return AppConstants.passwordSent+opu.get().getEmailId();
		}
		else {
			throw new InvalidCredentialsException(AppConstants.emailNotRegistered+ emailId);
		}
	}



	@Override
	public String changePassword(String oldPassword, String newPassword) {
		Optional<User> opuser=this.userRepository.findByUserPassword(oldPassword);
		if(opuser.isPresent()) {
			User user=opuser.get();
			if(passwordValidator.validatePassword(newPassword)==true) {
				user.setUserPassword(newPassword);
				this.userRepository.save(user);
				return AppConstants.passwordchanged;
			}
			else {
				throw new InvalidCredentialsException(AppConstants.passwordPatternMismatched);
			}
		}
		else {
			throw new InvalidCredentialsException(AppConstants.invalidOldPassword);
		}
	}

	

}
