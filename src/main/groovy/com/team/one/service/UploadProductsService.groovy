package com.team.one.service

import org.springframework.web.multipart.MultipartFile

interface UploadProductsService {

  Integer uploadProductsInValuarte(MultipartFile file)
  void uploadImagesInValuarte(MultipartFile file)

}
