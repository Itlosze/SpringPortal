package hu.domain.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// Content table handling
@Entity
public class Content {

	
	@GeneratedValue
	@Id
	private Long id;
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	private Date posted;
	
	@ManyToOne
	private Writer writer;

	public Content() {
		
	}
	
	public Content(String title, String text, Date posted, Writer writer) {
		this.title = title;
		this.text = text;
		this.posted = posted;
		this.writer = writer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
	
}
