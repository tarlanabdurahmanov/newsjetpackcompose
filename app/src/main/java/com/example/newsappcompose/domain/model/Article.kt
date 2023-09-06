package com.example.newsappcompose.domain.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.Nullable

@SuppressLint("KotlinNullnessAnnotation")
@Parcelize
@Entity
data class Article(
    @Nullable val author: String?,
    @Nullable val content: String?,
    @Nullable val description: String?,
    @Nullable val publishedAt: String?,
    @Nullable val source: Source?,
    @Nullable val title: String?,
    @PrimaryKey val url: String,
    @Nullable val urlToImage: String?
) : Parcelable