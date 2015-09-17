package com.team.one.controller

import jxl.*
import java.io.*

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.multipart.MultipartFile
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.team.one.service.uploadProducts.UploadProductsService
import com.team.one.service.ClientService

@Controller
@RequestMapping("/upload")
class UploadProductsController {

  static final Logger LOGGER = LoggerFactory.getLogger(UploadProductsController.class)

  @Autowired
  UploadProductsService uploadProductsService
  @Autowired
  ClientService ClientService

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  String create() {
    "uploadFile/index"
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/upload", method=RequestMethod.GET)
  @ResponseBody String provideUploadInfo() {
    "You can upload a file by posting to this same url."
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  @ResponseBody String handleFileUpload( @RequestParam("file") MultipartFile file, @RequestParam("zipFile") MultipartFile zipFile) {
    if(!file.isEmpty()) {
      def countOfRowsSaved = uploadProductsService.uploadProductsInValuarte(file)
      uploadProductsService.uploadImagesInValuarte(zipFile)
      "El numero de filas procesadas fue de ${countOfRowsSaved}"
    } else {
      "You faild to upload because the file was empty"
    }
  }

}
