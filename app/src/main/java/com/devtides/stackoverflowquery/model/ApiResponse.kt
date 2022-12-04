package com.devtides.stackoverflowquery.model

import android.icu.text.DateFormat
import android.icu.util.Calendar
import android.os.Build
import android.text.Html
import android.text.format.DateFormat.format
import androidx.annotation.RequiresApi
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

fun getDate(timestamp: Long?): String {
    var time = ""
    timestamp?.let {
        val cal = java.util.Calendar.getInstance()
        cal.timeInMillis = timestamp * 1000
        time = android.text.format.DateFormat.format("dd/MM/yyyy hh:mm:ss", cal).toString()
    }

    return time
}
