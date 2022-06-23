package com.example.ourdays

import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {
    var title :String = " "

    fun onTitleChanged(newString: String) {
        title = newString
    }
}