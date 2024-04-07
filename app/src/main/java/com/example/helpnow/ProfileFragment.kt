package com.example.helpnow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helpnow.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)

        val view = binding.root

        binding.button9.setOnClickListener {
            val activity = activity as MainActivity
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_profile,MedicalFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        return view
    }


}