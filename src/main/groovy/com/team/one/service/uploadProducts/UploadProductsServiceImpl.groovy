package com.team.one.service.uploadProducts

import com.team.one.domain.*
import org.springframework.beans.factory.annotation.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.*
import org.springframework.web.multipart.MultipartFile
import com.team.one.service.uploadProducts.UploadProductsService
import com.team.one.util.TokenGenerator
import jxl.*
import java.io.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.team.one.service.CallService

@Service
class UploadProductsServiceImpl implements UploadProductsService {

  static final String COMPRESS_EXTENSION = ".zip"
  static final Logger LOGGER = LoggerFactory.getLogger(UploadProductsServiceImpl.class)

  @Value('${images.path}')
  String imagesPath
  @Autowired
  CallService callService


  Integer uploadProductsInValuarte(MultipartFile file) {
    try {
      Workbook fileExcel = Workbook.getWorkbook(file.getInputStream())
      int numRows
      String token = callService.getTokenTimOneForBeginTransactions()

      (0..fileExcel.numberOfSheets-1).each{ sheetNo ->
        Sheet page = fileExcel.getSheet(sheetNo)
        int numColumns = page.columns
        numRows = page.rows
        String data
        (0..numRows-1).each { row ->
          def listElementInRow = []
          (0..numColumns-1).each { column ->
            data = page.getCell(column, row).contents
            listElementInRow.add(data)
          }
          def result = callService.createProductTramaPost(listElementInRow,token)
        }
      }
      numRows
    } catch (Exception ioe) {
      LOGGER.info ioe.printStackTrace()
    }
  }

  void uploadImagesInValuarte(MultipartFile file){
    if(file.isEmpty())return
    LOGGER.info "imagesPath: ${imagesPath}"
    def directoryDestination = new File(System.getProperty("java.io.tmpdir"))
    def fileName = TokenGenerator.generateToken() + COMPRESS_EXTENSION

    LOGGER.info "Storing zip file as: ${directoryDestination}/${fileName}"
    File fileDestination = new File(directoryDestination, fileName)
    file.transferTo(fileDestination)

    new AntBuilder().unzip(src:fileDestination.absolutePath, dest:fileDestination.parent, overwrite:"true")
  }

}
