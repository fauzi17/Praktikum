package com.e.praktikumc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import java.util.*
import kotlin.random.nextInt

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3
class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var pilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener{
            textPlayer.text = "BATU"
            pilihanPlayer = BATU
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil1.text = suwit(pilihanPlayer, pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            }, 2000)

        }

        buttonGunting.setOnClickListener{
            textPlayer.text = "GUNTING"
            pilihanPlayer = GUNTING
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
            textHasil1.text = suwit(pilihanPlayer,pilihanKomputer)
            showPilihanKomputer(pilihanKomputer)
            }, 2000)


        }

        buttonKertas.setOnClickListener{
            textPlayer.text = "KERTAS"
            pilihanPlayer = KERTAS
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil1.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            }, 2000)

        }
    }

    fun getPilihanKomputer():Int{
        return Random().nextInt(3) + 1;

    }

    fun suwit(PilihanPlayer: Int, pilihanKomputer: Int):String {
        var hasil: String = ""
        if (PilihanPlayer == pilihanKomputer){
            hasil = "SERI"
            textHasil1.setTextColor(Color.GRAY)
        }
        else if ((PilihanPlayer == BATU && pilihanKomputer == KERTAS) ||
            (PilihanPlayer == GUNTING && pilihanKomputer == BATU) ||
            (PilihanPlayer == KERTAS && pilihanKomputer == GUNTING)) {
            hasil = "YOU LOSE"
            textHasil1.setTextColor(Color.RED)
        }
        else{
            hasil = "YOU WIN"
            textHasil1.setTextColor(Color.GREEN)

        }



        return hasil
    }

    fun showPilihanKomputer(pilihanKomputer: Int){
        when(pilihanKomputer){
            1 -> textKomputer.text = "Komputer memilih BATU"
            2 -> textKomputer.text = "Komputer memilih GUNTING"
            3 -> textKomputer.text = "Komputer memilih KERTAS"


        }
    }
}
