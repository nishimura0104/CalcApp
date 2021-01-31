package jp.techacademy.rei.nishimura.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
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

        if (editText1.text.toString() != "" && editText2.text.toString() != "" ){

            val edit1 =  editText1.text.toString().toFloat()
            val edit2 =  editText2.text.toString().toFloat()
            var result = 0F
            when (v.id){
                R.id.button1 -> result = edit1 + edit2
                R.id.button2 -> result = edit1 - edit2
                R.id.button3 -> result = edit1 * edit2
                R.id.button4 -> result = edit1 / edit2
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", result)
            startActivity(intent)
        }else {
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_SHORT).show()
        }
    }

}