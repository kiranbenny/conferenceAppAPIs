package com.conference.application.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conference.application.models.Speaker;
import com.conference.application.repositories.SpeakerRepository;


@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
	
	@Autowired
	private SpeakerRepository speakerRepository;

	@GetMapping
	public List<Speaker> getSpeakers(){
		return speakerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Speaker getSpeakerById(@PathVariable Long id) {
		return speakerRepository.getReferenceById(id);
	}
	
	@PostMapping
	public Speaker createSpeaker(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@DeleteMapping("{id}")
	public void deleteSpeaker(@PathVariable Long id) {
		speakerRepository.deleteById(id);
	}
	
	@PutMapping("{id}")
	public Speaker updateSession(@PathVariable Long id, @RequestBody Speaker session) {
		Speaker existingSession = speakerRepository.getReferenceById(id);
		BeanUtils.copyProperties(session, existingSession, "speaker_id");
		return speakerRepository.saveAndFlush(existingSession);
	}
	
	
	
}
