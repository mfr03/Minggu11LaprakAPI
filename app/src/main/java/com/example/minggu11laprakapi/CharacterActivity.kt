package com.example.minggu11laprakapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.marginTop
import com.bumptech.glide.Glide
import com.example.minggu11laprakapi.databinding.ActivityCharacterBinding
import com.example.minggu11laprakapi.model.forapi.Characters
import com.example.minggu11laprakapi.model.forapi.Relics


class CharacterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCharacterBinding.inflate(layoutInflater)
    }

    private val imageBaseUrl = "https://github.com/Mar-7th/StarRailRes/blob/master/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val character = intent.getParcelableExtra<Characters>("character")

        with(binding) {
            setEidolon(character!!)
            setImage(sprite, character.portrait!!)
            setRelics(character)
            setLightCone(character)
        }

    }

    private fun setImage(sprite: ImageView, url: String) {
        Glide.with(this)
            .load("$imageBaseUrl$url?raw=true")
            .into(sprite)
        Log.d("glider", "$imageBaseUrl$url?raw=true")
    }

    private fun setLightCone(character: Characters) {
        val imageViews: List<ImageView> = listOf(
            binding.cone,
            binding.cone1
        )

        val cones = character.lightCone!!

        for(i in 0 until 2) {
            when(i) {
                0 -> {
                    setImage(imageViews[i], cones.icon!!)
                }
                1 -> {
                    setImage(imageViews[i], cones.icon!!)
                }
            }
        }

        binding.coneName.text = cones.name
        binding.coneSubText.text = "Lvl. " + cones.level.toString() + " Superimposition " + cones.rank.toString()
        addRelicDesc(character.relics!!)
    }


    private fun setRelics(character: Characters) {
        val imageViews: List<ImageView> = listOf(
            binding.relic1,
            binding.relic2,
            binding.relic3,
            binding.relic4,
            binding.relic5,
            binding.relic6,
        )
        val relics = character.relics!!

        for(i in 0 until 6) {
            when(i) {
                0 -> {
                    setImage(imageViews[i], relics.headPiece!!.icon!!)
                }
                1 -> {
                    setImage(imageViews[i], relics.glovePiece!!.icon!!)
                }
                2 -> {
                    setImage(imageViews[i], relics.chestPiece!!.icon!!)
                }
                3 -> {
                    setImage(imageViews[i], relics.bootsPiece!!.icon!!)
                }
                4 -> {
                    setImage(imageViews[i], relics.planarPiece!!.icon!!)
                }
                5 -> {
                    setImage(imageViews[i], relics.ropePiece!!.icon!!)
                }
            }
        }


    }
    private fun setEidolon(character: Characters) {
        val imageViews: List<ImageView> = listOf(
            binding.eidolon1,
            binding.eidolon2,
            binding.eidolon3,
            binding.eidolon4,
            binding.eidolon5,
            binding.eidolon6,
        )

        val rankIcons = character.rankIcons!!

        for(i in 0 until character.rankIcons.size) {
            setImage(imageViews[i], rankIcons[i].icon !!)
        }
    }


    private fun addRelicDesc(relics: Relics) {
        for( i in 0 until 6) {
            val constraintLayout = ConstraintLayout(this)
            constraintLayout.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                leftMargin = setDP(8)
                bottomMargin = setDP(8)
            }
            val relicImage = ImageView(this)
            relicImage.id = View.generateViewId()
            val relicName = TextView(this)
            relicName.id = View.generateViewId()
            relicName.setTextColor(ContextCompat.getColor(this, R.color.white))
            val relicSubText = TextView(this)
            relicSubText.id = View.generateViewId()
            relicSubText.setTextColor(ContextCompat.getColor(this, R.color.white))

            relicImage.layoutParams = ConstraintLayout.LayoutParams(
                setDP(48),
                setDP(48),
            ).apply {
                topMargin = setDP(8)
                rightMargin = setDP(8)
            }

            when(i) {
                0 -> {
                    setImage(relicImage, relics.headPiece!!.icon!!)
                    relicName.text = relics.headPiece.name
                    relicSubText.text = relics.headPiece.mainProperty!!.name + " " + relics.headPiece.mainProperty.value
                }
                1 -> {
                    setImage(relicImage, relics.glovePiece!!.icon!!)
                    relicName.text = relics.glovePiece.name
                    relicSubText.text = relics.glovePiece.mainProperty!!.name + " " + relics.glovePiece.mainProperty.value
                }
                2 -> {
                    setImage(relicImage, relics.chestPiece!!.icon!!)
                    relicName.text = relics.chestPiece.name
                    relicSubText.text = relics.chestPiece.mainProperty!!.name + " " + relics.chestPiece.mainProperty.value
                }
                3 -> {
                    setImage(relicImage, relics.bootsPiece!!.icon!!)
                    relicName.text = relics.bootsPiece.name
                    relicSubText.text = relics.bootsPiece.mainProperty!!.name + " " + relics.bootsPiece.mainProperty.value
                }
                4 -> {
                    setImage(relicImage, relics.planarPiece!!.icon!!)
                    relicName.text = relics.planarPiece.name
                    relicSubText.text = relics.planarPiece.mainProperty!!.name + " " + relics.planarPiece.mainProperty.value
                }
                5 -> {
                    setImage(relicImage, relics.ropePiece!!.icon!!)
                    relicName.text = relics.ropePiece.name
                    relicSubText.text = relics.ropePiece.mainProperty!!.name + " " + relics.ropePiece.mainProperty.value
                }
            }

            constraintLayout.addView(relicImage)
            constraintLayout.addView(relicName)
            constraintLayout.addView(relicSubText)

            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            // setting constraint for image
            connectConstraint(constraintSet, relicImage.id, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connectConstraint(constraintSet, relicImage.id, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connectConstraint(constraintSet, relicImage.id, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connectConstraint(constraintSet, relicImage.id, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            // for name
            connectConstraint(constraintSet, relicName.id, relicImage.id, ConstraintSet.START, ConstraintSet.END)
            connectConstraint(constraintSet, relicName.id, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connectConstraint(constraintSet, relicName.id, ConstraintSet.PARENT_ID, ConstraintSet.END)
            // for subtext
            connectConstraint(constraintSet, relicSubText.id, relicName.id, ConstraintSet.TOP, ConstraintSet.BOTTOM)
            connectConstraint(constraintSet, relicSubText.id, relicImage.id, ConstraintSet.START, ConstraintSet.END)
            connectConstraint(constraintSet, relicSubText.id, ConstraintSet.PARENT_ID, ConstraintSet.END)
            connectConstraint(constraintSet, relicSubText.id, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            // setting bias
            constraintSet.setHorizontalBias(relicImage.id,0.0f)
            constraintSet.setVerticalBias(relicImage.id, 0.0f)
            constraintSet.setHorizontalBias(relicName.id, 0.025f)
            constraintSet.setHorizontalBias(relicSubText.id, 0.025f)
            constraintSet.setVerticalBias(relicSubText.id, 0.5f)

            constraintSet.applyTo(constraintLayout)

            binding.itemDesc.addView(constraintLayout)
            Log.d("added", "${constraintLayout.id}")

        }
    }

    private fun connectConstraint(set: ConstraintSet, viewID: Int, destID: Int, constraintLocation: Int) {
        set.connect(
            viewID,
            constraintLocation,
            destID,
            constraintLocation,
        )
    }

    private fun connectConstraint(set: ConstraintSet, viewID: Int, destID: Int,
                                  constraintLocationStart: Int, constraintLocationEnd: Int) {
        set.connect(
            viewID,
            constraintLocationStart,
            destID,
            constraintLocationEnd
        )
    }

    private fun setDP(dp: Int): Int {
        return (dp * resources.displayMetrics.density + 0.5f).toInt()
    }
}