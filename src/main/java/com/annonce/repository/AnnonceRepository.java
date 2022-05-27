package com.annonce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonce.entities.Annonce;


public interface AnnonceRepository extends JpaRepository<Annonce,Long>{
	@Query(value="select * from annonce where id= :id", nativeQuery = true)
    public abstract Annonce findAnnonceById(@Param("id") long id);
	@Query("from Annonce where titre LIKE CONCAT('%',:t,'%')")
    public abstract List<Annonce> findbyTitle(@Param("t") String titre);
	@Query("from Annonce where texte LIKE CONCAT('%',:t,'%')")
    public abstract List<Annonce> findbyCom(@Param("t") String texte);
	@Query("from Annonce where prix <= :p")
    public abstract List<Annonce> findbyMaxPrice(@Param("p") double price);
	@Query("from Annonce where prix >= :p")
    public abstract List<Annonce> findbyMinPrice(@Param("p") double price);
	@Query("from Annonce where date LIKE CONCAT(:date,'%')")
    public abstract List<Annonce> findbyDate(@Param("date") String date);

}
