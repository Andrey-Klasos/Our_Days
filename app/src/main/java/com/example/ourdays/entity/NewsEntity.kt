package com.example.ourdays.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsData")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description : String,

    @ColumnInfo(name = "imgUrl")
    var imgUrl : String,

    @ColumnInfo(name = "createdData")
    var createdData: String
)
