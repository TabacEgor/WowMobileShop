package com.tabac.ebsintegratortestapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tabac.ebsintegratortestapp.model.entity.FavoriteProductEntity

@Dao
interface CartProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: FavoriteProductEntity)
}