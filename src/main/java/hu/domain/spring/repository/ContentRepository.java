package hu.domain.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.domain.spring.entity.Content;


@Repository
public interface ContentRepository extends CrudRepository<Content, Long>{

// Get all content from database
	List<Content> findAll();
	
//	Get last content from database
	Content findFirstByOrderByPostedDesc();

//	@Query(value="select c from Content c where c.title= :title")
	Content findFirstByTitleIgnoreCaseContainingOrderByPostedDesc(String title);
}
