package com.annonce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonce.entities.Categorie;


public interface CategorieRepository extends JpaRepository<Categorie,Long>{
	@Query(value="select * from categorie where id= :id", nativeQuery = true)
    public abstract Categorie findCategorieById(@Param("id") long id);
	@Query("from Categorie where nom LIKE CONCAT('%',:cat,'%')")
    public abstract Categorie findCategorieByNom(@Param("cat") String cat);
	
}
