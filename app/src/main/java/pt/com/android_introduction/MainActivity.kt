package pt.com.android_introduction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultado = findViewById<TextView>(R.id.tvResultado);
        val etNome = findViewById<EditText>(R.id.etNome)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val btEnviar2 = findViewById<Button>(R.id.btEnviar2)
        val btEnviar3 = findViewById<Button>(R.id.btEnviar3)

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
               result?.let{
                   val data: Intent? = result.data
                   val resultText = data?.getStringExtra("RESULT")
                   tvResultado.text = resultText
               }
            }


        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                tvResultado.text = getString(R.string.hello_name, etNome.text.toString())
                etNome.text.clear()
            }
            else
                etNome.error = getString(R.string.type_your_name)
        }
        btEnviar2.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                val nomeDigitado = etNome.text.toString()
                etNome.text.clear()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("NOME_DIGITADO", nomeDigitado)
                startActivity(intent)
            }
            else
                etNome.error = getString(R.string.type_your_name)
        }
        btEnviar3.setOnClickListener {
            val intent = Intent(this, SendResultActivity::class.java)
            startForResult.launch(intent)
        }
    }
}