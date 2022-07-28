package com.zhytel.myshoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhytel.myshoppinglist.data.ShopListRepositoryImpl
import com.zhytel.myshoppinglist.domain.DeleteShopItemUseCase
import com.zhytel.myshoppinglist.domain.EditingShopItemUseCase
import com.zhytel.myshoppinglist.domain.GetShopListUseCase
import com.zhytel.myshoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editingShopItemUseCase = EditingShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
    fun editingShopItem(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editingShopItemUseCase.editingShopItem(newItem)
    }
}