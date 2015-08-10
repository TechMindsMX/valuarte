package com.team.one.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.springframework.web.client.RestTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.team.one.service.CallService
import org.springframework.util.*

@Service
class CallServiceImpl implements CallService {

  @Value('${timOne.path.create.product}')
  String pathCreateProject
  @Value('${timOne.path.get.token}')
  String pathGetToken
  @Value('${timOne.path.get.project}')
  String pathGetProject


  String createProductTramaPost(def params,String token) {
    if(params[0] != ""){
      MultiValueMap<String, String> propertiesCreateProduct = new LinkedMultiValueMap<String, String>()
      String name = "${params[0]}-${params[3]}"
      String descripcion = "${params[2]}-${params[4]}-${params[5]}"
      propertiesCreateProduct.userId = 1
      propertiesCreateProduct.name = name.toString()
      propertiesCreateProduct.subcategory = params[1]
      propertiesCreateProduct.description = descripcion.toString()
      propertiesCreateProduct.photos = params[2].toString()
      propertiesCreateProduct.token = token
      propertiesCreateProduct.status = 0
      RestTemplate restTemplate = new RestTemplate()
      def resp = restTemplate.postForObject(pathCreateProject, propertiesCreateProduct, String.class)
      resp
    }
    "no available"
  }

  String getTokenTimOneForBeginTransactions() {
    RestTemplate restTemplate = new RestTemplate()
    def token = restTemplate.getForObject(pathGetToken,String.class)
    token
  }

  String getProductById(){
    RestTemplate restTemplate = new RestTemplate()
    def response = restTemplate.getForObject(pathGetProject,String.class)
    response
  }

}

class ProjectCommand {
  Long id
  String name
  String showground
  String inclosure
  String url
  String banner
  String avatar
  Integer subcategory
  Integer status
  String videoPublic
  String audioPublic
  String imagePublic
  String infoPublic
  Long timeCreated
  String type
  String projectFinancialData
  String projectRate
  String projectVideos
  String projectSoundclouds
  String projectPhotos
  String providers
  String tags
  String logs
  String description
  String cast
  BigDecimal tri
  BigDecimal cre
  BigDecimal trf
  BigDecimal tra
  BigDecimal fundedAmount
  BigDecimal investedAmount
  Float rating
  Long userId
}
