package com.example.ourdays

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ourdays.database.NewsViewModelFactory
import com.example.ourdays.entity.NewsEntity
import com.example.ourdays.ui.theme.OurDaysTheme
import com.example.ourdays.viewmodel.NewsViewModel

@Composable
fun MainScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val newsViewModel: NewsViewModel = viewModel(
        factory = NewsViewModelFactory(context.applicationContext as Application)
    )
    val getAllDataBase = newsViewModel.readAllData.observeAsState(listOf()).value
    OurDaysTheme() {
        Scaffold {
            Column {
                ToolBar()
                Spacer(modifier = Modifier.size(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LazyColumn(content = {
                        items(getAllDataBase.size) { index ->
                            CardWithNews(getAllDataBase.reversed()[index])
                        }
                    })
                    IconBar(navController)
                }
            }
        }
    }
}
@Composable
private fun IconBar(navController: NavController) {
    Column {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.AccountCircle, "Login")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Try, "Заявка на модера")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Forum, "Chat")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Settings, "Settings")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Help, "Question")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { navController.navigate(route = Screen.AddNews.route) }) {
            Icon(Icons.Filled.Add, "Add News")
        }
        Spacer(modifier = Modifier.size(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Login, "Login")
        }

    }
}


@Composable
fun CardWithNews(newsEntity: NewsEntity) {
    Spacer(modifier = Modifier.size(20.dp))
    Card(
        modifier = Modifier.size(336.dp),
        shape = RoundedCornerShape(6.dp),
        backgroundColor = Color(0xFFEBEBEB)
    ) {
        Column {
            Spacer(modifier = Modifier.size(14.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = newsEntity.createdData,
                    modifier = Modifier.padding(start = 246.dp))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(86.dp)) {
                Text(
                    text = newsEntity.title,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            LazyRow(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
            ){

            }
        }

    }
}


@Composable
private fun ToolBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Our Days")
    }
}



@Preview
@Composable
fun PreviewCardWithNews(){
    val newsItem = remember { RandomGenerateNewsData()}
    CardWithNews(newsEntity = newsItem)
}
