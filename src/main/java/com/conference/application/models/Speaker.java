package com.conference.application.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="speakers")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speaker_id;
	private String first_name;
	private String last_name;
	private String title;
	private String company;
	private String speaker_bio;
	
	@Lob
	//Type(type="org.hibernate.type.BinaryTree")
	private byte[] speaker_photo;
	
	@ManyToMany(mappedBy = "speakers")
	@JsonIgnore
	private List<Session> sessions;
	
}
