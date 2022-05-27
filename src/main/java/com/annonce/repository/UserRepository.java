package com.annonce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.annonce.entities.Usermanager;

@Repository
public interface UserRepository extends JpaRepository<Usermanager, Long>{
	
	@Query("from Usermanager where login =:x and password=:y")
	public Usermanager authentificate(@Param("x") String login,@Param("y") String password);
	@Query("from Usermanager where login =:x")
	public Usermanager findbyname(@Param("x")String login);
	@Query(value="select * from usermanager where code_user= :id", nativeQuery = true)
    public abstract Usermanager findUsermanagerById(@Param("id") long id);
}
