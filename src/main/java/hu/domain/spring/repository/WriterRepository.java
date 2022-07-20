package hu.domain.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.domain.spring.entity.Writer;

public interface WriterRepository extends CrudRepository<Writer, Long> {

//	Get all writer from database
	List<Writer> findAll();
}
