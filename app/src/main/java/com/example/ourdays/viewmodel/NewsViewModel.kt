package com.example.ourdays.viewmodel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.ourdays.database.NewsDatabase
import com.example.ourdays.entity.NewsEntity
import com.example.ourdays.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
class NewsViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<NewsEntity>>

    private val repository: NewsRepository

    init {
        val newsDao = NewsDatabase.getInstance(application).newsDao()
        repository = NewsRepository(newsDao = newsDao)
        readAllData = repository.readAllData
    }

    fun addNews(item:NewsEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNews(item = item)
        }
    }

    fun updateNews(item: NewsEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateNews(item)
        }
    }

    fun deleteNews(item: NewsEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteNews(item)
        }
    }
    fun updateAllRecords(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllNews()
        }
    }

    fun createNewsEntity(NewsId: Int, Title: String, Description: String, ImgUrl: String, strDate: String): NewsEntity {
        return NewsEntity(NewsId, Title, Description, ImgUrl, strDate)
    }

    val date = SimpleDateFormat("dd-MM-yyyy")
    val strDate: String = date.format(Date())

    var newsId: Int by  mutableStateOf(0)
   private var _title = MutableLiveData("")
    val title : LiveData<String> = _title
    var description by  mutableStateOf("Description")
    var imgUrl by  mutableStateOf("imgUrl")

    fun onTitleChanged(newString: String){
        _title.value = newString
    }







}
