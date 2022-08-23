package com.zhytel.myshoppinglist.domain

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopListRepository {
    @Insert
    fun addShopItem(shopItem: ShopItem)
    @Delete
    fun deleteShopItem(shopItem: ShopItem)
    @Update
    fun editingShopItem(shopItem: ShopItem)
    @Query("SELECT * FROM shopList WHERE id == :shopItemId")
    fun getShopItem(shopItemId: Int):ShopItem
    @Query("SELECT * FROM shopList")
    fun getShopList():LiveData<List<ShopItem>>
}