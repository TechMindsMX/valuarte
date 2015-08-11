package com.team.one.service

interface CallService {

	String createProductTramaPost(def params,String token)

  String getTokenTimOneForBeginTransactions()

  String getProductById(Integer productId)

  def getProducts()

}
