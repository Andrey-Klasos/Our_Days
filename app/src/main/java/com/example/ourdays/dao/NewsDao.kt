package com.example.ourdays.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ourdays.entity.NewsEntity


@Dao
interface NewsDao {
    @Query("SELECT * FROM newsData")
    fun getAllData(): LiveData<List<NewsEntity>>

    @Query("SELECT * FROM newsData WHERE id = :id")
    fun getById(id: Int):NewsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (item: NewsEntity)

    @Update
    suspend fun update (item: NewsEntity)

    @Delete
    suspend fun delete (item : NewsEntity)

    @Query("DELETE FROM newsData")
    suspend fun deleteAllRecord()



}