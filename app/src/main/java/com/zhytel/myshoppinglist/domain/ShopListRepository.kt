package com.zhytel.myshoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editingShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int):ShopItem
    fun getShopList():LiveData<List<ShopItem>>
}