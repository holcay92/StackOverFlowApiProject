package com.devtides.stackoverflowquery.model

import android.os.Build
import android.text.Html
import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    val items: List<T>
)

data class Question(
    @SerializedName("question_id")
    val questionId: String,
    val title: String,
    val score: String,
    @SerializedName("creation_date")
    val date: Long
)

fun convertTitle(title: String?) =
    if (Build.VERSION.SDK_INT >= 24)
        Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY).toString()
    else
        Html.fromHtml(title).toString()
