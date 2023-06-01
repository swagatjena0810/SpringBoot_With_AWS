package com.RI._AdminModule.Repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.RI._AdminModule.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByemailId(String emailId);
//	User findByEmailIdAndUserPassword(String emailId,String userPassword);
	Optional<User> findByUserPassword(String userPassword);
}
