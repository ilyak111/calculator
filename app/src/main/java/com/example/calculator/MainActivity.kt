package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.evaluateButton.setOnClickListener {
            if (binding.operand1Input.text.isNotBlank() && binding.operand2Input.text.isNotBlank())
                evaluate()
            else
                binding.resultOutput.text = getString(R.string.not_all_operands_error_text)
        }
        binding.aboutAuthorButton.setOnClickListener { startActivity(Intent(this@MainActivity, AboutAuthorActivity::class.java)) }
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
        val operand1 = binding.operand1Input.text.toString().toDouble()
        val operand2 = binding.operand2Input.text.toString().toDouble()
        val operator = binding.operatorInput.selectedItemPosition
        if (operator == 3 && operand2 == 0.0)
            binding.resultOutput.text = getString(R.string.division_by_zero_error_text)
        else {
            val result = when (operator) {
                0 -> operand1 + operand2
                1 -> operand1 - operand2
                2 -> operand1 * operand2
                3 -> operand1 / operand2
                else -> 0.0
            }
            binding.resultOutput.text = result.toString()
        }
    }

    companion object {
        const val RESULT_BUNDLE = "result"
    }
}