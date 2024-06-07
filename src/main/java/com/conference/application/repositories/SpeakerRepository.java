package com.conference.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conference.application.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
