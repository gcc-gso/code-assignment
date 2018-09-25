package org.gso.codeassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "org.gso.codeassignment" })
public class CodeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeAssignmentApplication.class, args);
	}
}
