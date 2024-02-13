package com.springSecurity.basitauth;

import com.springSecurity.basitauth.dto.CreateUserRequest;
import com.springSecurity.basitauth.model.Role;
import com.springSecurity.basitauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BasitAuthApplication implements CommandLineRunner {

	private final UserService userService;

    public BasitAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasitAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createData();
	}

	private void createData(){
		CreateUserRequest request1 = CreateUserRequest.builder()
				.name("user")
				.username("user1")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request1);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("admin")
				.username("user2")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("mod")
				.username("user3")
				.password("pass")
				.authorities(Set.of(Role.ROLE_MOD))
				.build();
		userService.createUser(request3);
	}
}
