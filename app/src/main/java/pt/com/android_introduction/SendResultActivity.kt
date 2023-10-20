package pt.com.android_introduction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SendResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_result)

        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)

        btYes.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RESULT", getString(R.string.yes))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        btNo.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RESULT", getString(R.string.no))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}