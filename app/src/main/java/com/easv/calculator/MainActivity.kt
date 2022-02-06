package com.easv.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var calculateType: Int = 0;
    val mCalculate = Calculate();

    var x: Double = 0.0;
    var y: Double = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd);
        val btnSubtract = findViewById<Button>(R.id.btnSubtract);
        val btnDivide = findViewById<Button>(R.id.btnDivide);
        val btnMultiply = findViewById<Button>(R.id.btnMultiply);
        val btnResult = findViewById<Button>(R.id.btnResult);
        val btnClear = findViewById<Button>(R.id.btnClear);

        btnAdd.setOnClickListener { v -> setAdd()}
        btnSubtract.setOnClickListener { v -> setSubtract() }
        btnDivide.setOnClickListener { v -> setDivide() }
        btnMultiply.setOnClickListener { v -> setMultiply() }
        btnResult.setOnClickListener { v -> setResult() }
        btnClear.setOnClickListener { v -> setClear()}
    }

    fun numberPressed(view: View) {
        val textView = findViewById<TextView>(R.id.textView);
        val symbols = "+-*/";

        if (textView.text.any{it in symbols}) {
            textView.setText("");
            val currentValue = textView.text;
            val numberPressed = (view as Button).text;
            textView.setText("${currentValue}${numberPressed}")
        } else {
            val currentValue = textView.text;
            val numberPressed = (view as Button).text;
            textView.setText("${currentValue}${numberPressed}")
        }
    }

    fun setClear() {
        val textView = findViewById<TextView>(R.id.textView);
        textView.setText("");
    }

    fun setResult() {
        val textView = findViewById<TextView>(R.id.textView);
        y =  textView.text.toString().toDouble();

        when (calculateType) {
            1 -> textView.setText(mCalculate.add(x, y).toString())
            2 -> textView.setText(mCalculate.subtract(x, y).toString())
            3 -> textView.setText(mCalculate.divide(x, y).toString())
            4 -> textView.setText(mCalculate.multiply(x, y).toString())
        }
    }

    fun setAdd() {
        val textView = findViewById<TextView>(R.id.textView);
        x = textView.text.toString().toDouble();
        calculateType = 1;
        textView.setText("+")
    }

    fun setSubtract() {
        val textView = findViewById<TextView>(R.id.textView);
        x = textView.text.toString().toDouble();
        calculateType = 2;
        textView.setText("-")
    }

    fun setDivide() {
        val textView = findViewById<TextView>(R.id.textView);
        x = textView.text.toString().toDouble();
        calculateType = 3;
        textView.setText("/")
    }

    fun setMultiply() {
        val textView = findViewById<TextView>(R.id.textView);
        x = textView.text.toString().toDouble();
        calculateType = 4;
        textView.setText("*")
    }
}
