package com.pmdm.ej2practicaexam

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmdm.ej2practicaexam.databinding.FragmentBotonesBinding
import java.lang.RuntimeException

private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"

class BotonesFragment : Fragment() {
    /*Inicializamos las variables para pode usar el viewBinding*/
    private var _binding:FragmentBotonesBinding?=null
    private val  binding get()=_binding!!

    lateinit var botonesListener:BotonesListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*Le pasamos valores a las variables para la inicialización*/
       _binding=FragmentBotonesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity is BotonesListener){
            botonesListener=activity as BotonesListener
        }
        else{
            throw RuntimeException("$activity must implement BotonesListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVerde.setOnClickListener{
            botonesListener.onClickButton(Color.GREEN)
        }

        binding.btnRojo.setOnClickListener{
            botonesListener.onClickButton(Color.RED)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        /*Al destruirse la app el valor de _binding sera null*/
        _binding=null
    }


    companion object{
        @JvmStatic
        fun newInstance(param1:String,param2:String){
            BotonesFragment().apply{
                arguments=Bundle().apply{
                    putString(ARG_PARAM1,param1)
                    putString(ARG_PARAM2,param2)
                }
            }
        }
    }

}