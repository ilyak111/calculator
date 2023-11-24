package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.evaluateButton.setOnClickListener { evaluate() }
        binding.aboutAuthorButton.setOnClickListener { binding.resultOutput.text = "Автора зовут Илья" }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(RESULT_BUNDLE, binding.resultOutput.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.resultOutput.text = savedInstanceState.getString(RESULT_BUNDLE)
    }

    private fun evaluate() {
        val op1 = binding.operand1Input.text.toString().toDouble()
        val op2 = binding.operand2Input.text.toString().toDouble()
        val result = when (binding.operatorInput.selectedItemPosition) {
            0 -> op1 + op2
            1 -> op1 - op2
            2 -> op1 * op2
            3 -> op1 / op2
            else -> 0.0
        }
        binding.resultOutput.text = result.toString()
    }

    companion object {
        const val RESULT_BUNDLE = "result"
    }
}