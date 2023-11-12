package com.example.minggu11laprakapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minggu11laprakapi.databinding.ActivityMainBinding
import com.example.minggu11laprakapi.model.forapi.UserData
import com.example.minggu11laprakapi.recyclerview.UserAdapter
import com.example.minggu11laprakapi.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var res = mutableListOf<UserData>()
    private val baseUrl = "https://api.mihomo.me/sr_info_parsed/"
    private val extraArguments = "?lang=en&version=v1"
    private val uidList = listOf(
        "801469869",
        "801621900",
        "801286972",
        "802382061",
        "801097804",
        "810333066",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generateUserData()
    }

    private fun generateUserData() {

        val client = ApiClient.getInstance(baseUrl)

        for(uid in uidList) {
            val response = client.getPlayerData("$uid$extraArguments")
            response.enqueue(object: Callback<UserData> {
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    if(response.isSuccessful) {
                        res.add(response.body()!!)
                        responseSuccessful()
                    }
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {
//                TODO("Not yet implemented")
                }
            })
        }
    }

    private fun responseSuccessful() {
        if(res.size == uidList.size) {
            res.sortBy {
                userData ->
                userData.player.uid.toInt()
            }

            val adapterUser = UserAdapter(res) {
                    userData ->
                val intent = Intent(this@MainActivity, UserActivity::class.java)
                intent.putParcelableArrayListExtra("characters", userData.characters as ArrayList<out Parcelable>)
                startActivity(intent)
            }

            with(binding) {
                rvUser.apply {
                    adapter = adapterUser
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        }
    }
}


