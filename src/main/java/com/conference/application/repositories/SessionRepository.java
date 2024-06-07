package com.conference.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conference.application.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
