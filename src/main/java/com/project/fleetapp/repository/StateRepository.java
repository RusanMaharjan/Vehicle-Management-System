package com.project.fleetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fleetapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
