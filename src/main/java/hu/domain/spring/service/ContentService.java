package hu.domain.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.domain.spring.entity.Content;
import hu.domain.spring.entity.Writer;
import hu.domain.spring.repository.ContentRepository;
import hu.domain.spring.repository.WriterRepository;

@Service
public class ContentService {

	private ContentRepository contentRepo;
	private WriterRepository writerRepo;

	@Autowired
	public void setStoryRepo(ContentRepository contentRepo) {
		this.contentRepo = contentRepo;
	}
	
	@Autowired
	public void setWriterRepo(WriterRepository writerRepo) {
		this.writerRepo = writerRepo;
	}

	public List<Content> getContents() {
		return contentRepo.findAll();
	}
	
	public Content getContent(){
		return contentRepo.findFirstByOrderByPostedDesc();
	}

	public List<Writer> getWriter() {
		return writerRepo.findAll();
	}
	
	public Content getSpecificContent(String title) {
		return contentRepo.findFirstByTitleIgnoreCaseContainingOrderByPostedDesc(title);
	}
	
	
}
