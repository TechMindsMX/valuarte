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

@Controller
@RequestMapping("/upload")
class UploadProductsController {

  static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class)
  @Autowired
  UploadProductsService uploadProductsService

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  String create() {
    "uploadFile/index"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/upload", method=RequestMethod.GET)
  @ResponseBody String provideUploadInfo() {
    "You can upload a file by posting to this same url."
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("zipFile") MultipartFile zipFile) {
    if(!file.isEmpty()) {
      def countOfRowsSaved = uploadProductsService.uploadProductsInValuarte(file)
      "El numero de filas procesadas fue de ${countOfRowsSaved}"
    } else {
      "You faild to upload ${name} because the file was empty"
    }

    uploadProductsService.uploadImagesInValuarte(zipFile)
  }

}
