package com.example.minggu11laprakapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.minggu11laprakapi.databinding.ActivityUserBinding
import com.example.minggu11laprakapi.model.forapi.Characters

class UserActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityUserBinding.inflate(layoutInflater)
    }

    private val imageBaseUrl = "https://github.com/Mar-7th/StarRailRes/blob/master/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val characters = intent.getParcelableArrayListExtra<Characters>("characters") as ArrayList<Characters>

        with(binding) {
            for(i in 0 until characters.size){
                val character = characters[i]
                when(i) {
                    0 -> {
                        setContent(character, supportBg, supportText, supportSprite)
                    }
                    1 -> {
                        setContent(character, starFaringBg1, starfaringText1, starFaringSprite1)
                    }
                    2 -> {
                        setContent(character, starFaringBg2, starfaringText2, starFaringSprite2)
                    }
                    3 -> {
                        setContent(character, starFaringBg3, starfaringText3, starFaringSprite3)
                    }
                }
            }

            supportSprite.setOnClickListener {
                val intent = Intent(this@UserActivity, CharacterActivity::class.java)
                intent.putExtra("character", characters[0])
                startActivity(intent)
            }

            starFaringSprite1.setOnClickListener {
                val intent = Intent(this@UserActivity, CharacterActivity::class.java)
                intent.putExtra("character", characters[1])
                startActivity(intent)
            }

            starFaringSprite2.setOnClickListener {
                val intent = Intent(this@UserActivity, CharacterActivity::class.java)
                intent.putExtra("character", characters[2])
                startActivity(intent)
            }

            starFaringSprite3.setOnClickListener {
                val intent = Intent(this@UserActivity, CharacterActivity::class.java)
                intent.putExtra("character", characters[3])
                startActivity(intent)
            }

        }
    }

    private fun setImage(sprite: ImageView, url: String) {
        Glide.with(this)
            .load("$imageBaseUrl$url?raw=true")
            .into(sprite)
    }
    private fun checkRarity(rarity: Int, bg: ImageView) {
        if(rarity == 4) {
            bg.setImageResource(R.drawable.image)
        }
    }
    fun setContent(character: Characters, bg: ImageView, text: TextView, sprite: ImageView) {
        checkRarity(character.rarity, bg)
        text.text = "Lvl. " + character.level + " " + character.name
        setImage(sprite, character.portrait !!)
    }
}