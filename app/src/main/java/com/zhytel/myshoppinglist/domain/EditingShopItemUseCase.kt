package com.zhytel.myshoppinglist.domain

class EditingShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editingShopItem(shopItem: ShopItem){
        shopListRepository.editingShopItem(shopItem)
    }
}