package com.app.storyboard.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class SubStory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@ApiModelProperty(notes = "The database generated subId")
	private String subId;
	@Size(min=5, message = "Please provide valid name")
	@ApiModelProperty(notes = "The name of the story", required = true)
	private String name;
	@Size(min=5, message = "Please provide valid description")
	@ApiModelProperty(notes = "The description of the story", required = true)
	private String description;
	@ApiModelProperty(notes = "The assignedTo of the Story", required = false)
	private String assignedTo;
	@NotNull(message = "createdBy is requried")
	@NotBlank(message = "createdBy is requried")
	@ApiModelProperty(notes = "The createdBy of the Story", required = true)
	private String createdBy;
	@Pattern(regexp = "OPEN|TODO|INPROGRESS|DONE|VALIDATION|COMPLETED", message = "Not a valid StoryStatus")
	@ApiModelProperty(notes = "The storyStatus of the Story", required = true)
	private String storyStatus;
	private LocalDateTime credatedDate;
	private LocalDateTime modifiedDate;
	
}
