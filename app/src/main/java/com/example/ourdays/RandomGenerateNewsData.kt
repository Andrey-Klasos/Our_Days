package com.example.ourdays

import com.example.ourdays.entity.NewsEntity



fun RandomGenerateNewsData(): NewsEntity {
    val message = listOf(
        "Make it easy Sample 1",
        "Make it easy Sample 2"

    ).random()
    return NewsEntity(id = 1, message, message , message, "10-06-2009")
}