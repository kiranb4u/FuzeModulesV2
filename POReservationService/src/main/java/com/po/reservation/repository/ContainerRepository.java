package com.po.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.po.reservation.entity.Container;



public interface ContainerRepository extends JpaRepository<Container, Integer> {


	List<Container> findByCatsStatusAndMrOrderCodeIsNull(String catsStatus);

	List<Container> findByCatsStatusAndMrOrderCodeIsNotNull(String catsStatus);

	List<Container> findByCatsStatus(String catsStatus);
	
	@Query("select container from Container container where "
			+ " container.catsStatus = 'ER' and container.reservedByUser.id =:userId")
	public List<Container> findAllReservedContainerByUser(
			@Param("userId") int userId);

	Container findByContainerCode(String containerCode);
	

}
