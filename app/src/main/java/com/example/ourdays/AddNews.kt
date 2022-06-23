package com.example.ourdays
import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ourdays.database.NewsViewModelFactory
import com.example.ourdays.viewmodel.NewsViewModel
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun AddScreen(navController: NavController) {


    val context = LocalContext.current
    val newsViewModel: NewsViewModel = viewModel(
        factory = NewsViewModelFactory(context.applicationContext as Application)


    )
    Scaffold {
        Column(Modifier.background(color = Color(0xFFEBEBEB))) {
            ToolBar()
            Spacer(modifier = Modifier.size(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(newsViewModel,navController)
                IconBar()
            }

        }
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun TextField(newsViewModel: NewsViewModel,
              navController: NavController) {
    val date = SimpleDateFormat("dd-MM-yyyy")
    val strDate: String = date.format(Date())
    val newsId: Int by remember { mutableStateOf(0) }
    val title by newsViewModel.title.observeAsState("")
    var description by remember { mutableStateOf("Description") }
    val imgUrl by remember { mutableStateOf("imgUrl") }




        Column {
            Row(
            modifier = Modifier
                .width(336.dp)
                .padding(start = 8.dp)
                .height(106.dp)
            ){
                Box(modifier = Modifier
                    .border(BorderStroke(1.dp, color = Color.Black))
                    .width(336.dp)
                    .height(96.dp)
                    .background(color = Color.White)
                    .clickable { navController.navigate(route = Screen.AddTitle.route) })
                    {
                    Text(
                        text = title,
                        fontSize = 24.sp,
                        fontStyle = Italic
                    )
                }
        }
            Spacer(modifier = Modifier.size(6.dp))
            Row(
                modifier = Modifier
                    .width(336.dp)
                    .padding(start = 8.dp, top = 8.dp)
            ) {
                OutlinedTextField(
                    value = description,
                    onValueChange = { newDescription -> description = newDescription },
                    modifier = Modifier
                        .width(328.dp)
                        .background(color = Color.White)
                        .height(336.dp)
                        .clickable { },
                    textStyle = TextStyle(
                        fontStyle = Italic,
                        fontSize = 18.sp
                    ),
                    shape = RoundedCornerShape(6.dp),
                    )
            }
            Spacer(modifier = Modifier.size(6.dp))
            Row {
                Box(modifier = Modifier
                    .width(336.dp)
                    .height(46.dp)
                    .background(color = Color(0xFFEBEBEB))
                    .padding(top = 6.dp),
                    contentAlignment = Alignment.Center) {
                    Button(onClick = { newsViewModel.addNews(newsViewModel.createNewsEntity(
                        newsId,
                        title,
                        description,
                        imgUrl,
                        strDate)
                        )

                     }) {
                        Text(text = "Button",
                        modifier = Modifier.clickable { newsViewModel.onTitleChanged("dsdsddd") })
                    }
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


@Composable
private fun IconBar() {

        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.White))
        {
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
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Add, "Add News")
            }
            Spacer(modifier = Modifier.size(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Login, "Login")
            }

        }
    }

@Preview
@Composable
private fun PreviewText() {
    Scaffold {
        Column(Modifier.background(color = Color(0xFFEBEBEB))) {
            ToolBar()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Row(
                        modifier = Modifier
                            .width(336.dp)
                            .padding(start = 8.dp)
                            .height(106.dp)
                    ) {
                        Box(modifier = Modifier
                            .border(BorderStroke(1.dp, color = Color.Black))
                            .width(336.dp)
                            .height(96.dp)
                            .background(color = Color.White)) {
                            Text(
                                text = "Text",
                                fontSize = 24.sp,
                                fontStyle = Italic
                            )
                        }

                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Row(
                        modifier = Modifier
                            .width(336.dp)
                            .padding(start = 8.dp, top = 8.dp)
                    ) {
                        OutlinedTextField(
                            value = "Description",
                            onValueChange = { },
                            modifier = Modifier
                                .width(336.dp)
                                .background(color = Color.White)
                                .height(336.dp),
                            textStyle = TextStyle(
                                fontStyle = Italic,
                                fontSize = 18.sp
                            ),
                            shape = RoundedCornerShape(6.dp)
                            )
                    }
                    Box(
                            modifier = Modifier
                                .width(336.dp)
                                .height(86.dp)
                                .background(color = Color(0xFFEBEBEB))
                                .padding(top = 36.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Button")
                            }
                        }



                }
                    IconBar()
            }

        }

    }

}









