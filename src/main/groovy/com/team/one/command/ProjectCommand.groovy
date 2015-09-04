package com.team.one.command

class ProjectCommand {
  BigInteger id
  String name
  String showground
  String inclosure
  String url
  String banner
  String avatar
  Integer subcategory
  Integer status
  String videoPublic
  String audioPublic
  String imagePublic
  String infoPublic
  Long timeCreated
  String type
  def projectFinancialData
  String projectRate
  def projectVideos
  def projectSoundclouds
  def projectPhotos
  def providers
  def tags
  def logs
  String description
  String cast
  BigDecimal tri
  BigDecimal cre
  BigDecimal trf
  BigDecimal tra
  BigDecimal fundedAmount
  BigDecimal investedAmount
  Float rating
  Long userId


  def getElementInDescriptionByPosition(def position) {
    def content = description.split("-")
    content[position]
  }

  def getNameOfProduct() {
    def content = name.split("-")
    content[1]
  }

}


