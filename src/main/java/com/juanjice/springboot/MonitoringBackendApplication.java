package com.juanjice.springboot;

import com.juanjice.springboot.model.Authority;
import com.juanjice.springboot.model.User;
import com.juanjice.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MonitoringBackendApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(MonitoringBackendApplication.class, args);
	}
	@PostConstruct
	public void init(){
		List<Authority> autList=new ArrayList<>();
		autList.add(new Authority("USER","User role"));
		autList.add(new Authority("ADMIN","Admin role"));
		autList.add(new Authority("GUEST","User role"));
		autList.add(new Authority("FRIEND","User role"));
		User user=new User();
		user.setUserName("juanjice");
		user.setEmail("juanjice@gmail.com");
		user.setFirstName("juan prueba");
		user.setLastName("jimenez prueba");
		user.setPassword(passwordEncoder.encode("abc123"));
		user.setEnabled(true);
		userRepository.save(user);

	}
	private Authority createAut(String rolCode,String roleDescription){
		Authority authority=new Authority();
		authority.setRoleCode(rolCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
