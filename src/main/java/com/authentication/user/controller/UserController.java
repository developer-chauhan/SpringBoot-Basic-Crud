package com.authentication.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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


@RestController
@RequestMapping("/api/v1")
public class UserController {
	@GetMapping("/user")
	public String User() {
		return "User info";
	}
	@PostMapping("/user")
	public String saveUser(@RequestBody UserModel user) {
		return "req"+user.getName();
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
		return new ResponseEntity<>("User "+id+" is deleted", HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}/{name}")
	public String updateUser(@PathVariable(value="name", required=true) String name, @PathVariable("id") String id, @RequestBody UserModel user) {
		return user.getName()+" email="+user.getEmail()+" request param="+name;
	}
	
	@PostMapping("/user/upload")  //not working route need help to fix this
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File convertibleFile = new File("/var/temp/"+file.getOriginalFilename());
		convertibleFile.createNewFile();
		FileOutputStream fOutputStream= new FileOutputStream(convertibleFile);
		fOutputStream.write(file.getBytes());
		fOutputStream.close();
		return "file is uploaded";
	}
}
