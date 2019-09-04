package com.app.storyboard.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class SubStory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String subId;
	@Size(min=5)
	private String name;
	@Size(min=5)
	private String description;
	private String assignedBy;
	private String createdBy;
	private LocalDateTime credatedDate;
	private String tastStatus;
	private LocalDateTime modifiedDate;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id")
	 
    	private Story story;
	 */
}
