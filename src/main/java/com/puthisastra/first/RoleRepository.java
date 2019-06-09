package com.puthisastra.first;

import java.util.List;

import javax.persistence.QueryHint;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	List<Role> findByName(String name);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE ROLE SET CREATED_TIME = CURRENT_TIMESTAMP()", nativeQuery = true)
	int updateCreatedTime();
}
