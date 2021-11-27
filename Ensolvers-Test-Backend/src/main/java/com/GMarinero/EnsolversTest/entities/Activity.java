package com.GMarinero.EnsolversTest.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="activity")
@Data
public class Activity implements Serializable{
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="name")
	private String name;
	
	@NotEmpty
	@Column(name="detail")
	private String detail;
	
	@Column(name="isDone")
	private boolean isDone;
	
	@NotNull
	@Column(name="dateCreated")
	private String dateCreated;
	
	@Column(name="dateStarted")
	private String dateStarted;
	
	@Column(name="dateFinished")
	private String dateFinished;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="fk_person")
	Person person;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_folder")
	Folder folder;
	
}
