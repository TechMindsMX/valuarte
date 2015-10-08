package com.team.one.repository

import com.team.one.domain.Product
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  Product findBySku(BigInteger sku)

}
