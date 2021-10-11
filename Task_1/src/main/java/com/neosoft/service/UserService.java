package com.neosoft.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Role;
import com.neosoft.entity.User;
import com.neosoft.repository.RoleRepository;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// To initialize Role & User
    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default Role For Newly Created Record");
        roleRepo.save(userRole);

        
        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserEmail("admin@admin.com");
        adminUser.setUserPassword(getEncodedPassword("admin123"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

        /*User user = new User();
        user.setUserName("nishargi169");
        user.setUserPassword("nishargi@123");
        user.setUserFirstName("Nishargi");
        user.setUserLastName("Shah");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepo.save(user);*/
    }
    
    // To Register New User
    public User registerNewUser(User user) {
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }
    
    // To Encode The Password
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
