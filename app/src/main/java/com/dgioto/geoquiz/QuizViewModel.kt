package com.dgioto.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0

    //Создаем массив вопросов
    private val questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true))

    //добавим вычисляемые свойства, чтобы вернуть текст и ответ на текущий вопрос
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    //добавим в QuizViewModel функцию перехода к следующему вопросу
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}