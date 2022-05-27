package com.annonce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.annonce.entities.Region;


public interface RegionRepository extends JpaRepository<Region,Long>{
	@Query(value="select * from region where id= :id", nativeQuery = true)
    public abstract Region findRegionById(@Param("id") long id);
	@Query("from Region where nom LIKE CONCAT('%',:reg,'%')")
    public abstract Region findRegionByNom(@Param("reg") String reg);
	
}
