package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val name = findViewById<TextView>(R.id.name)
        val go = findViewById<Button>(R.id.go)
        val start = findViewById<TextView>(R.id.Start)
        val btn_group = findViewById<RadioGroup>(R.id.btn_group)
        val btn_1 = findViewById<RadioButton>(R.id.btn_1)
        val btn_2 = findViewById<RadioButton>(R.id.btn_2)
        val btn_3 = findViewById<RadioButton>(R.id.btn_3)
        val myplay = findViewById<TextView>(R.id.myplay)
        val pcplay = findViewById<TextView>(R.id.pcplay)
        val winer = findViewById<TextView>(R.id.winer)
        go.setOnClickListener{
            if(ed_name.length() == 0 || ed_name.length() < -1){
                start.text = ("請輸入ID!!!!")
                return@setOnClickListener
            }else{
                var names = ed_name.text
                name.text = ("ID\n$names")
                if(btn_1.isChecked || btn_2.isChecked || btn_3.isChecked ){ 
                    val check = when {
                        btn_1.isChecked ->"剪刀"
                        btn_2.isChecked -> "石頭"
                        else -> "布"
                    }
                    val random = (0..2).random()   //0到2(包含2)亂數
                    val pccheck = when(random){
                        0 -> "剪刀"
                        1 -> "石頭"
                        else -> "布"
                    }
                    myplay.text = ("我出\n$check")
                    pcplay.text = ("電腦\n$pccheck")

                    if(check == pccheck){
                        start.text = ("平手!!")
                        winer.text = ("勝者\n平手")
                    }else {
                        val pk = when(check){
                            "剪刀" -> 0
                            "石頭" -> 1
                            "布" -> 2
                            else -> null
                        }
                        if(pk == 0){            //我出剪刀的情況
                            if((pk + random)==1){ //電腦出石頭
                                start.text = ("嫩!你輸了!!")
                                winer.text = ("勝者\n電腦")
                            }else if((pk+random)==2){//電腦出布
                                start.text = ("恭喜!你贏了!!!")
                                winer.text = ("勝者\n你")
                            }
                        }else if(pk == 1){      //我出石頭的情況
                            if((pk + random)==1){ //電腦出剪刀
                                start.text = ("恭喜!你贏了!!!")
                                winer.text = ("勝者\n你")
                            }else if((pk+random) == 3){ //電腦出布
                                start.text = ("嫩!你輸了!!")
                                winer.text = ("勝者\n電腦")
                            }
                        }else if(pk == 2){      //我出布
                            if((pk + random) == 2){ //電腦出剪刀
                                start.text = ("嫩!你輸了!!")
                                winer.text = ("勝者\n電腦")
                            }else if((pk+random) == 3){ //電腦出石頭
                                start.text = ("恭喜!你贏了!!!")
                                winer.text = ("勝者\n你")
                            }
                        }
                    }

                }else{
                    start.text = ("請出拳!!")
                }
                btn_group.clearCheck()  //清空選項
            }






        }
    }
}