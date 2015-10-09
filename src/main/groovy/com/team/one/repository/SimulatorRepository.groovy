package com.team.one.repository

import com.team.one.domain.Simulator

import org.springframework.data.mongodb.repository.MongoRepository

public interface SimulatorRepository extends MongoRepository<Simulator, String> {

  Simulator findById(String id)

}
