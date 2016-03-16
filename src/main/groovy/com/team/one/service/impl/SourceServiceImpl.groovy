package com.team.one.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.team.one.service.SourceService
import com.team.one.repository.SourceRepository

@Service
class SourceServiceImpl implements SourceService {

  @Autowired
  SourceRepository sourceRepository

  def findSources(){
    sourceRepository.findAll()
  }

}
