package com.daebaksong.myboard;

import com.daebaksong.myboard.listener.StartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyboardApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MyboardApplication.class);
		springApplication.addListeners(new StartListener());
		springApplication.run(args);

		//SpringApplication.run(MyboardApplication.class, args);
	}
}
