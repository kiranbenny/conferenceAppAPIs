package com.conference.application.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conference.application.models.Session;
import com.conference.application.repositories.SessionRepository;

import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping
	public List<Session> getSessions(){
		return sessionRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Session getById(@PathVariable Long id) {
		return sessionRepository.getReferenceById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Session createSession(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}
	
	@DeleteMapping("{id}")
	public void deleteSession(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}
	
	@PutMapping("{id}")
	public Session updateSession(@PathVariable Long id, @RequestBody Session session) {
		Session existingSession = sessionRepository.getReferenceById(id);
		BeanUtils.copyProperties(session, existingSession, "session_id");
		return sessionRepository.saveAndFlush(existingSession);
	}
	
}
