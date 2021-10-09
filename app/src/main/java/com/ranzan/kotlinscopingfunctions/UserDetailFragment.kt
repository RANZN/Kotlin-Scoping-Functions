package com.ranzan.kotlinscopingfunctions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCallApi.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getData(etCallApi.text.toString().toInt())
            .enqueue(object : Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    response.body()?.data?.run {
                        tvFirstName.text = firstName
                        tvLastName.text = lastName
                    }
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

}