package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
