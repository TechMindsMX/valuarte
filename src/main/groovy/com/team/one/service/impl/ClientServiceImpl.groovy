package com.team.one.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.util.*
import org.springframework.http.*
import org.codehaus.jackson.map.ObjectMapper

import com.team.one.domain.Client
import com.team.one.repository.ClientRepository
import com.team.one.service.ClientService
import com.team.one.service.PhotoNameGeneratorService
import com.team.one.command.ProjectCommand
import com.team.one.command.CategoryCommand

import org.slf4j.Logger
import org.slf4j.LoggerFactory

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
  @Value('${timOne.path.subcategory.find}')
  String pathFindSubcategory
  @Value('${timOne.path.subcategory.create}')
  String pathCreateSubCategory

  @Autowired
  PhotoNameGeneratorService photoNameGeneratorService
  @Autowired
  ClientRepository clientRepository

  static final Logger log = LoggerFactory.getLogger(this.getClass())

  String createProductTramaPost(def params,String token) {
    if(params[0] != ""){
      MultiValueMap<String, String> propertiesCreateProduct = new LinkedMultiValueMap<String, String>()
      String name = "${params[0]}-${params[4]}"
      String descripcion = "${params[2]}-${params[5]}-${params[6]}"
      propertiesCreateProduct.userId = 1
      propertiesCreateProduct.name = name.toString()
      propertiesCreateProduct.subcategory = obtainSubcategoryByName(params[0].toString())
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
    RestTemplate restTemplate = new RestTemplate()
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(forgotPassword,headers);
    def status = restTemplate.postForObject(pathFormForgot, entity,String.class);
    log.info status
  }

  def findSubCategoryByName(String name) {
    RestTemplate restTemplate = new RestTemplate()
    def resultCat = restTemplate.getForObject(pathFindSubcategory + name,String.class)
    ObjectMapper mapper = new ObjectMapper()
    CategoryCommand command = mapper.readValue(resultCat,CategoryCommand.class)
    command.id
  }

  def createSubCategoryByName(String name) {
    RestTemplate restTemplate = new RestTemplate()
    MultiValueMap<String,String> propertiesSubCategory = new LinkedMultiValueMap<String, String>()
    propertiesSubCategory.name = name
    def resultSubCat = restTemplate.postForObject(pathCreateProject,propertiesSubCategory,String.class)
    resultSubCat
  }

  private def  obtainSubcategoryByName(def name) {
    def subcategory = findSubCategoryByName(name)
    if(!subcategory)
      subcategory = createSubCategoryByName(name)
    subcategory
  }

  def findByRfc(String rfc){
    return clientRepository.findByRfc(rfc)
  }

}
