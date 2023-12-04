package com.pmdm.ej2practicaexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.pmdm.ej2practicaexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BotonesListener{
    private lateinit var binding:ActivityMainBinding
    var isDualPane:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**/
        isDualPane = findViewById<FragmentContainerView>(R.id.fragmentColores) != null


        if(savedInstanceState==null){
            val fragmentContainer=
                if(isDualPane){
                    binding.fragmentBotones
                }

                else{
                    binding.fragmentMain
                }
            val botonesFragment=BotonesFragment()
            supportFragmentManager
                .beginTransaction()
                .add(fragmentContainer!!.id,botonesFragment)
                .commit()



            if(isDualPane) {
                val fragmentContainer=binding.fragmentColores
                val coloresFragment = ColoresFragment()
                supportFragmentManager
                    .beginTransaction()
                    .add(fragmentContainer!!.id, coloresFragment)
                    .commit()
            }
        }
    }

    override fun onClickButton(color: Int) {
        val loadedColorFragment=supportFragmentManager.findFragmentById(R.id.fragmentColores) as ColoresFragment?
        loadedColorFragment?.cambiarColor(color)

        if(loadedColorFragment==null){
            val newColorFragment=ColoresFragment.newInstance(color)
            val fragmentContainer=binding.fragmentMain
            supportFragmentManager
                .beginTransaction()
                .replace(fragmentContainer!!.id,newColorFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}