package com.sameer.myprojects.yclass.Api

data class Mydata(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)