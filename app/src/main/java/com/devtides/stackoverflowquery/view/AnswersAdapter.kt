package com.devtides.stackoverflowquery.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.stackoverflowquery.R
import com.devtides.stackoverflowquery.model.Answer
import kotlinx.android.synthetic.main.answer_layout.view.*

class AnswersAdapter(val answers: ArrayList<Answer>) : RecyclerView.Adapter<AdapterViewHolder>() {

    fun addAnswers(newAnswers: List<Answer>) {
        val currentLength = answers.size
        answers.addAll(newAnswers)
        notifyItemInserted(currentLength)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.answer_layout, parent, false)
        )


    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(answers[position])
    }

    override fun getItemCount() = answers.size
}

class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.item_answer
    fun bind(answer: Answer) {
        title.text = answer.toString()
    }
}


