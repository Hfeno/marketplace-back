package com.annonce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.annonce.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value="select * from role where role_name =:role", nativeQuery = true)
    public abstract Role findRoleByName(@Param("role") String role);
	
}
