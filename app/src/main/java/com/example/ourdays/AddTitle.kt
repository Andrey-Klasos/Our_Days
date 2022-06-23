package com.example.ourdays

import android.app.Application

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ourdays.database.NewsViewModelFactory
import com.example.ourdays.viewmodel.NewsViewModel

@Preview
@Composable
fun AddTextForTitle(){
    val context = LocalContext.current
    val newsViewModel: NewsViewModel = viewModel(
        factory = NewsViewModelFactory(context.applicationContext as Application)
    )


    Scaffold {
        Column(modifier = Modifier
            .background(color = Color(0xFFEBEBEB))) {
            ToolBar()
            TextField(newsViewModel)

        }
    }
}

@Composable
private fun TextField(newsViewModel: NewsViewModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        var titleText by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = titleText,
                onValueChange = { newTitleText -> titleText = newTitleText},
                textStyle = TextStyle(
                    fontStyle = Italic,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(106.dp)
            )
        }
        Text(text = "Button",
            modifier = Modifier.clickable { newsViewModel.onTitleChanged("dsdsddd") })


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