package com.team.one.service.impl

import com.team.one.repository.SourceRepository

@Service
class SourceServiceImpl implements SourceService {

  @Autowired
  SourceRepository sourceRepository

  def findSources(){
    sourceRepository.findAll()
  }

}
