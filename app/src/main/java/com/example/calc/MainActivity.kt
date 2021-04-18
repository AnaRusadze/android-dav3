package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var cButton: Button

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        cButton = findViewById(R.id.cButton)

    }


    fun numberClick(view: View) {
        if (view is Button) {
            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }
            resultTextView.text = result + number
        }
    }


    fun operationClick(view: View) {
        if (view is Button) {
            if (!resultTextView.text.isEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }
            resultTextView.text = ""
            operation = view.text.toString()
        }
    }

    fun equalsClick(view: View){
        if (view is Button){
            val secOperandText = resultTextView.text.toString()
            var secOperand = 0.0

            if (secOperandText.isNotEmpty()) {
                secOperand = secOperandText.toDouble()
            }

            when (operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "%" -> resultTextView.text = (operand / 100).toString()
                "√" -> resultTextView.text = ((kotlin.math.sqrt(operand)).toString())
                "+/-" -> resultTextView.text = ((operand * -1).toString())
            }
        }
    }


    fun clearResult(view: View) {
        if (view is Button) {
            if (resultTextView.text.isNotEmpty()) {

                resultTextView.text =
                    resultTextView.text.substring(0, resultTextView.text.length - 1)

                cButton.setOnLongClickListener {
                    resultTextView.text = ""
                    true
                }
            }
        }
    }

    fun pointNumber(view: View){
        if(view is Button){
            if(resultTextView.text.isNotEmpty() && !resultTextView.text.contains(".")){
                resultTextView.text = resultTextView.text.toString() + "."
            }
        }
    }


}