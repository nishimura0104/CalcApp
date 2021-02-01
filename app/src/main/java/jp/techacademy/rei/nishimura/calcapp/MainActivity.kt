package jp.techacademy.rei.nishimura.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar;


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        //関数を呼び出し
        val result = validation(editText1, editText2,v )

        if (result) {
            val edit1 = editText1.text.toString().toFloat()
            val edit2 = editText2.text.toString().toFloat()
            var result = 0F
            when (v.id) {
                R.id.button1 -> result = edit1 + edit2
                R.id.button2 -> result = edit1 - edit2
                R.id.button3 -> result = edit1 * edit2
                R.id.button4 -> result = edit1 / edit2
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", result)
            startActivity(intent)
        }
    }

    //値を検証する・・・falseの時のエラーをスナックバーで表示してBoolean型（trueかfalse）を戻り値として呼び出し側に返す
    private fun validation(edit1:EditText,edit2:EditText,v: View):Boolean{

        var isCalc = true

        if (edit1.text.toString() == "" || edit2.text.toString() == ""){
            isCalc = false
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_SHORT).show()
        }else if (edit1.text.toString() == "." || edit2.text.toString() == "."){
            isCalc = false
            Snackbar.make(v, ".だけでは計算できません", Snackbar.LENGTH_SHORT).show()
        }else if (v.id == R.id.button4 && edit2.text.toString() == "0"){
            isCalc = false
            Snackbar.make(v, "0で割り算はできません", Snackbar.LENGTH_SHORT).show()
        }

        return isCalc
    }
}