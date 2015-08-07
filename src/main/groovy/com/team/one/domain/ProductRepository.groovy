package com.team.one.domain

import org.springframework.data.repository.PagingAndSortingRepository

interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  Product findBySku(BigInteger sku)

}
