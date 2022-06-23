package com.example.ourdays.repository

import androidx.lifecycle.LiveData
import com.example.ourdays.dao.NewsDao
import com.example.ourdays.entity.NewsEntity

class NewsRepository(private val newsDao: NewsDao) {
    val readAllData: LiveData<List<NewsEntity>> = newsDao.getAllData()

    suspend fun addNews(item:NewsEntity){
        newsDao.insert(item)
    }

    suspend fun updateNews(item: NewsEntity){
        newsDao.update(item)
    }

    suspend fun deleteNews(item: NewsEntity){
        newsDao.delete(item)
    }
    suspend fun deleteAllNews(){
        newsDao.deleteAllRecord()
    }


}