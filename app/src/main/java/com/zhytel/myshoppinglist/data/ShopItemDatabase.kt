package com.zhytel.myshoppinglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zhytel.myshoppinglist.domain.ShopItem
import com.zhytel.myshoppinglist.domain.ShopListRepository

@Database(entities = [ShopItem::class], version = 1, exportSchema = false)
abstract class ShopItemDatabase : RoomDatabase() {

    abstract fun shopListDao() : ShopListRepository

    companion object {
        @Volatile
        private var INSTANCE: ShopItemDatabase? = null

        fun getInstance(context: Context): ShopItemDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ShopItemDatabase::class.java,
                        "shopList.db").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}