package com.example.minggu11laprakapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.minggu11laprakapi.databinding.ActivityMainBinding
import com.example.minggu11laprakapi.model.Characters
import com.example.minggu11laprakapi.model.Player
import com.example.minggu11laprakapi.model.UserData
import com.example.minggu11laprakapi.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val baseUrl = "https://api.mihomo.me/sr_info_parsed/"
    private val extraArguments = "?lang=en&version=v1"

    private lateinit var player: Player

    private lateinit var characters: List<Characters>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.getInstance(baseUrl)
        val response = client.getPlayerData("801469869$extraArguments")

        response.enqueue(object: Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                player = response.body()?.player !!
                characters = response.body()?.characters !!

                with(binding) {
                    Log.d("MainActivity", "onResponse: $player")
                    test.text = player.name
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
//                TODO("Not yet implemented")
            }
        })
    }

}