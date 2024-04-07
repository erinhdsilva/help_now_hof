package com.example.helpnow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.helpnow.databinding.FragmentMedicalBinding
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MedicalFragment : Fragment() {

    private lateinit var binding: FragmentMedicalBinding
    private lateinit var data: MedicalInfo // Declare data variable at the class level

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicalBinding.inflate(inflater, container, false)
        val name = binding.name.text.toString()
        val condition = binding.medicalConditions.text.toString()
        val blood = binding.bloodGroup.text.toString()
        val medication = binding.medication.text.toString()
        val allergy = binding.allergy.text.toString()
        val organdonor = binding.Organ.text.toString()

        data = MedicalInfo(name, condition, blood, medication, allergy, organdonor) // Initialize data variable
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Saved.setOnClickListener {
            // Populate MedicalInfo object with data from UI
            val name = binding.name.text.toString()
            val condition = binding.medicalConditions.text.toString()
            val blood = binding.bloodGroup.text.toString()
            val medication = binding.medication.text.toString()
            val allergy = binding.allergy.text.toString()
            val organdonor = binding.Organ.text.toString()
            val medicalInfo = MedicalInfo(name, condition, blood, medication, allergy, organdonor)

            // Make API call to post medical document
            RetrofitInstance.apiInterface.postMedicalDocument(medicalInfo)
                .enqueue(object : Callback<MedicalInfo> {
                    override fun onResponse(
                        call: Call<MedicalInfo>,
                        response: Response<MedicalInfo>
                    ) {
                        if (response.isSuccessful) {
                            // Handle successful response
                            val responseBody = response.body()
                            // Update UI or take action based on response
                        } else {
                            // Handle unsuccessful response
                        }
                    }

                    override fun onFailure(call: Call<MedicalInfo>, t: Throwable) {
                        // Handle failure
                    }
                })
        }
    }

    private fun uploadToIPFS() {
        val gson = Gson()
        val jsonData = gson.toJson(data)

        val client = OkHttpClient()

        val ipfsUrl = "http://localhost:3000/request-ipfs-data"
        val requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file", "data.json", RequestBody.create("application/json".toMediaTypeOrNull(), jsonData))
            .build()

        val request = Request.Builder()
            .url(ipfsUrl)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback<MedicalInfo?>, okhttp3.Callback {

            override fun onFailure(call: okhttp3.Call, e: IOException) {
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {

                    // Handle successful response, you can parse responseBody for further processing
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<MedicalInfo?>, t: Throwable) {
            }

            override fun onResponse(call: Call<MedicalInfo?>, response: Response<MedicalInfo?>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    // Handle successful response, you can parse responseBody for further processing
                } else {
                    // Handle unsuccessful response
                }
            }
        })

    }
}
