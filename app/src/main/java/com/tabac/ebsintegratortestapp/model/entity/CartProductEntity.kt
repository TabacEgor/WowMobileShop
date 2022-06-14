package com.tabac.ebsintegratortestapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_products")
data class CartProductEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    val details : String,
    val size : String,
    val colour : String,
    val price : Int,
    val main_image : String
)