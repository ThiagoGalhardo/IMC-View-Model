package com.galhardo.imccomviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.galhardo.imccomviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initDados()
        initClick()


    }

    private fun validador(): Boolean {
        val peso = binding.weight.text.toString()
        val altura = binding.height.text.toString()

        if (peso.isBlank()) {
            binding.weight.setError("Preencha o campo")
            return false
        } else if (altura.isBlank()) {
            binding.height.setError("Preencha o campo")
            return false
        } else return true
    }

    private fun initClick() {
        binding.btn.setOnClickListener {

            if (validador() == true) {
                val peso = binding.weight.text.toString().toFloat()
                val altura = binding.height.text.toString().toFloat()
                mViewModel.calculoIMC(peso, altura)
            }
        }
    }

    private fun initDados() {

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel._imc.observe(this, Observer {
            binding.result.setText(it)
        })
    }
}