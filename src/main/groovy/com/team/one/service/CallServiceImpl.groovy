package com.team.one.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.springframework.web.client.RestTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.team.one.service.CallService
import com.team.one.service.uploadProducts.PhotoNameGeneratorService
import org.springframework.util.*
import com.google.gson.Gson
import com.team.one.command.ProjectCommand

@Service
class CallServiceImpl implements CallService {

  @Value('${timOne.path.create.product}')
  String pathCreateProject
  @Value('${timOne.path.get.token}')
  String pathGetToken
  @Value('${timOne.path.get.product}')
  String pathGetProduct
  @Value('${timOne.path.get.products}')
  String pathGetProducts

  @Autowired
  PhotoNameGeneratorService photoNameGeneratorService

  static final Logger log = LoggerFactory.getLogger(this.getClass())

  String createProductTramaPost(def params,String token) {
    if(params[0] != ""){
      MultiValueMap<String, String> propertiesCreateProduct = new LinkedMultiValueMap<String, String>()
      String name = "${params[0]}-${params[4]}"
      String descripcion = "${params[2]}-${params[5]}-${params[6]}"
      propertiesCreateProduct.userId = 1
      propertiesCreateProduct.name = name.toString()
      propertiesCreateProduct.subcategory = params[1]
      propertiesCreateProduct.description = descripcion.toString()
      propertiesCreateProduct.photos = photoNameGeneratorService.getNames(params[2].toString(), params[3].toInteger())
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

  ProjectCommand getProductById(Integer productId){
    RestTemplate restTemplate = new RestTemplate()
    def json = restTemplate.getForObject(pathGetProduct + productId,String.class)
    ProjectCommand command = new Gson().fromJson(json, ProjectCommand.class);
    log.info "Project: ${command.dump()}"
    log.info "Uploaded photos: ${command.projectPhotos?.size()}"
    command
  }

  def getProducts(){
    RestTemplate restTemplate = new RestTemplate()
    def json = restTemplate.getForObject(pathGetProducts,String.class)
    List<ProjectCommand> products = new Gson().fromJson(json, List.class);
    products
  }

}


