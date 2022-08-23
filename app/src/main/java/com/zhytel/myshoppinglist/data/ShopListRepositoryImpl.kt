package com.zhytel.myshoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zhytel.myshoppinglist.domain.ShopItem
import com.zhytel.myshoppinglist.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val _shopListVD = MutableLiveData<List<ShopItem>>()
    private val shopListVD: LiveData<List<ShopItem>>
        get() = _shopListVD
    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})
    private var autoIncrementId = 0

    init {
        for (i in 0..10){
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editingShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem.id)
        deleteShopItem(oldItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return _shopListVD
    }

    fun updateList(){
        _shopListVD.value = shopList.toList()
    }
}