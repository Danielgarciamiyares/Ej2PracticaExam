package com.pmdm.ej2practicaexam

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import com.pmdm.ej2practicaexam.databinding.FragmentColoresBinding

private const val COLOR_PARAM="bgcolor"

class ColoresFragment : Fragment() {
    private var _binding:FragmentColoresBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentColoresBinding.inflate(inflater,container,false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*variable que carga el valor de COLOR_PARAM, si es null carga Color.WHITE*/
        val color = arguments?.getInt(COLOR_PARAM) ?: Color.WHITE
        super.onViewCreated(view, savedInstanceState)
        cambiarColor(color)

    }
    /*funcion que cambia el color del fondo del layoutColor*/
    fun cambiarColor(@ColorInt color:Int){
        binding.layoutColor.setBackgroundColor(color)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    /*Crea una nueva instancia de ColoresFragment y le pasa a los argumentos el color*/
    companion object{
        @JvmStatic
        fun newInstance(@ColorInt color:Int)=
            ColoresFragment().apply {

                arguments = Bundle().apply{
                    putInt(COLOR_PARAM,color)
                }
            }
    }
}