package com.app.storyboard.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class Story implements Serializable {

	/**
	 * 
	 */
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static final long serialVersionUID = -6928170851370373986L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@ApiModelProperty(notes = "The database generated ID")
	private String id;
	@ApiModelProperty(notes = "The name of the story", required = true)
	@Size(min = 5, message = "Please provide valid name")
	private String name;
	@ApiModelProperty(notes = "The description of the story", required = true)
	@Size(min = 5, message = "Please provide valid description")
	private String description;
	@NotNull(message = "advId is requried")
	@NotBlank(message = "advId is requried")
	@ApiModelProperty(notes = "The advId of the Job", required = true)
	private String advId;
	@ApiModelProperty(notes = "The assignedTo of the Story", required = false)
	private String assignedTo;
	@NotNull(message = "createdBy is requried")
	@NotBlank(message = "createdBy is requried")
	@ApiModelProperty(notes = "The createdBy of the Story", required = true)
	private String createdBy;
	private LocalDateTime credatedDate;
	private LocalDateTime modifiedDate;
	@Pattern(regexp = "OPEN|TODO|INPROGRESS|DONE|VALIDATION|COMPLETED", message = "Not a valid storyStatus")
	@ApiModelProperty(notes = "The storyStatus of the Story", required = true)
	private String storyStatus;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Set<SubStory> subStory;
}
