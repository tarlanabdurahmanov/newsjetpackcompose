package com.example.newsappcompose.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsappcompose.R

data class Page(
    val title: String, val description: String, @DrawableRes val image: Int
)


val pages = listOf<Page>(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboard1,
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboard2,
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboard3,
    ),
)