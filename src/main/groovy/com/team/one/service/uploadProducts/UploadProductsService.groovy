package com.team.one.service.uploadProducts

import org.springframework.web.multipart.MultipartFile

public interface UploadProductsService {

  Integer uploadProductsInValuarte(MultipartFile file)
  void uploadImagesInValuarte(MultipartFile file)

}
