package com.team.one.service

import com.team.one.command.ProjectCommand

interface ClientService {

  String createProductTramaPost(def params,String token)

  String getTokenTimOneForBeginTransactions()

  ProjectCommand getProductById(Integer productId)

  def getProducts()

  def sendEmailContact(def jsonContact)

  def findSubCategoryByName(String name)

  def createSubCategoryByName(String name)

}
