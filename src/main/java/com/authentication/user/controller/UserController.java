package com.authentication.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.authentication.user.model.UserModel;
import com.authentication.user.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserServiceImpl uServiceImpl;
	
	//get all users
	@GetMapping("/user")
	public Iterable<UserModel> allUser() {
		return uServiceImpl.getAllUser();
	}
	
	//get user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(uServiceImpl.getUser(id), HttpStatus.OK);
		//return new ResponseEntity<>("User is updated successfully"+id,HttpStatus.OK);
	}
	
	//save user
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody UserModel user) {
		//return new ResponseEntity<>("User is deleted", HttpStatus.OK);
		uServiceImpl.createUser(user);
		return new ResponseEntity<>("User "+user.getEmail()+" Created!", HttpStatus.OK);
	}
	
	//update user
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
		uServiceImpl.updateUser(id, user);
		return new ResponseEntity<>("User is updated successfully"+id,HttpStatus.OK);
	}
	
	//delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
		uServiceImpl.deleteUser(id);
		return new ResponseEntity<>("User "+id+" is deleted", HttpStatus.OK);
	}
	
	//upload file
	@PostMapping("/user/upload")  //not working route need help to fix this need download file as well
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File convertibleFile = new File("/var/temp/"+file.getOriginalFilename());
		convertibleFile.createNewFile();
		FileOutputStream fOutputStream= new FileOutputStream(convertibleFile);
		fOutputStream.write(file.getBytes());
		fOutputStream.close();
		return "file is uploaded";
	}
}
