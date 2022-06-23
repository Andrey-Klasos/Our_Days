package com.example.ourdays.database

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ourdays.dao.NewsDao
import com.example.ourdays.entity.NewsEntity
import com.example.ourdays.viewmodel.NewsViewModel


@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
    companion object{
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
class NewsViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom((NewsViewModel::class.java))){
            return NewsViewModel(application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}












