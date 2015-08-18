package com.team.one.service

import com.team.one.command.ProjectCommand

interface CallService {

	String createProductTramaPost(def params,String token)

  String getTokenTimOneForBeginTransactions()

  ProjectCommand getProductById(Integer productId)

  def getProducts()

}
