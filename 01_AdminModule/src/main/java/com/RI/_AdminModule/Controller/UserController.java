package com.RI._AdminModule.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RI._AdminModule.Entities.User;
import com.RI._AdminModule.Services.IUserService;
import com.RI._AdminModule.Utils.AppConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController{
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/addcaseworker")
	public ResponseEntity<User> addCaseWorker(@RequestBody User user){
		
		if(user!=null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(userService.addCaseworker(user));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("/updatecaseworker")
	public ResponseEntity<User> updateCaseWorker(@RequestBody User user){
		
		if(user!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(userService.updateCaseworker(user));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping("/deactivate/{emailId}")
	public ResponseEntity<String> deactivateCaseworker(
			@PathVariable("emailId") String emailId){
		if(emailId!=null) {
			userService.deactivateCaseworker(emailId);
			return ResponseEntity.ok(AppConstants.responseAfterAccountDeactivated);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping("/activate/{emailId}")
	public ResponseEntity<String> activateCaseworker(
			@PathVariable("emailId") String emailId){
	
			userService.activateCaseworker(emailId);
			return ResponseEntity.ok(AppConstants.responseAfterAccountActivated);
		
	}
	
	
	@GetMapping("/viewcaseworkers")
	public ResponseEntity<List<User>> viewAllCaseworkers(){
		return ResponseEntity.ok(userService.viewCaseworkerList());
	
	}
	
	
	
	@GetMapping("/login/{emailId}/{userPassword}")
	public ResponseEntity<String> doLogin(@PathVariable("emailId") String emailId,
			@PathVariable("userPassword") String userPassword){
		
		return ResponseEntity.ok(userService.Login(emailId, userPassword));
	}
	
	
	@GetMapping("/forgotpassword/{emailId}")
	public ResponseEntity<String> forgotPassword(@PathVariable("emailId")
			String emailId){
		return ResponseEntity.ok(userService.forgotPassword(emailId));
	}
	
	
	@GetMapping("/changepassword/{oldPassword}/{newPassword}")
	public ResponseEntity<String> changePassword(@PathVariable("oldPassword") 
		String oldPassword,@PathVariable("newPassword") String newPassword){
		
		return ResponseEntity.ok(userService.changePassword(oldPassword, newPassword));
	}
	
}
