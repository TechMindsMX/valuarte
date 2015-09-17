package com.team.one.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.springframework.web.client.RestTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.team.one.service.ClientService
import com.team.one.service.uploadProducts.PhotoNameGeneratorService
import org.springframework.util.*
import com.google.gson.Gson
import com.team.one.command.ProjectCommand
import org.springframework.http.*
import org.codehaus.jackson.JsonGenerationException
import org.codehaus.jackson.map.JsonMappingException
import org.codehaus.jackson.map.ObjectMapper

@Service
class ClientServiceImpl implements ClientService {

  @Value('${timOne.path.create.product}')
  String pathCreateProject
  @Value('${timOne.path.get.token}')
  String pathGetToken
  @Value('${timOne.path.get.product}')
  String pathGetProduct
  @Value('${timOne.path.get.products}')
  String pathGetProducts
  @Value('${timOne.path.form.contact}')
  String pathFormContact
  @Value('${timOne.path.form.forgotPassword}')
  String pathFormForgot

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
    ObjectMapper mapper = new ObjectMapper()
    ProjectCommand command = mapper.readValue(json, ProjectCommand.class)
    log.info "Project: ${command.dump()}"
    log.info "Uploaded photos: ${command.projectPhotos?.size()}"
    command
  }

  def getProducts(){
    RestTemplate restTemplate = new RestTemplate()
    def json = restTemplate.getForObject(pathGetProducts,String.class)
    ObjectMapper mapper = new ObjectMapper()
    List<ProjectCommand> products = mapper.readValue(json, List.class)
    products
  }
  def sendEmailContact(def jsonContact) {
    RestTemplate restTemplate = new RestTemplate()
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(jsonContact,headers);
    def status = restTemplate.postForObject(pathFormContact, entity,String.class);
    log.info status
  }

  def sendEmailForgotPassword(def forgotPassword) {
    println pathFormForgot
    RestTemplate restTemplate = new RestTemplate()
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(forgotPassword,headers);
    def status = restTemplate.postForObject(pathFormForgot, entity,String.class);
    log.info status
  }

}


