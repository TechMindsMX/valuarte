package com.team.one.service.uploadProducts

import com.team.one.domain.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import com.team.one.service.uploadProducts.UploadProductsService
import jxl.*
import java.io.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class UploadProductsServiceImpl implements UploadProductsService {

  static final Logger LOGGER = LoggerFactory.getLogger(UploadProductsServiceImpl.class)
  Integer uploadProductsInValuarte(MultipartFile file) {
    try {
      Workbook archivoExcel = Workbook.getWorkbook(file.getInputStream())
      int numFilas
      (0..archivoExcel.numberOfSheets-1).each{ sheetNo ->
        Sheet hoja = archivoExcel.getSheet(sheetNo)
        int numColumnas = hoja.columns
        numFilas = hoja.rows
        String data
        (0..numFilas-1).each { fila ->
          (0..numColumnas-1).each { columna ->
            data = hoja.getCell(columna, fila).contents
            LOGGER.info(data + " ")
          }
          LOGGER.info("-----------------")
        }
      }
      numFilas
    } catch (Exception ioe) {
      LOGGER.info ioe.printStackTrace()
    }
  }

}
