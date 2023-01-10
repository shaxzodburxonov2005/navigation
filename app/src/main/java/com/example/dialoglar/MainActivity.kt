package com.example.dialoglar

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialoglar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list= arrayOf("java","kotlin","python","PHP")
        binding.btn.setOnLongClickListener {
            val dialog=AlertDialog.Builder(this)
//            dialog.setCancelable(true)
            dialog.setMultiChoiceItems(list, BooleanArray(list.size),object :DialogInterface.OnMultiChoiceClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                    Toast.makeText(this@MainActivity, "${list[p1]}", Toast.LENGTH_SHORT).show()
                }
            })


//            dialog.setMessage("Android development")
            dialog.setTitle("IT House")
            dialog.setPositiveButton("xa",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity, "uchirildi", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.setNegativeButton("yoq",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }

            })
            dialog.setNeutralButton("boshqa",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                }

            })
            dialog.setSingleChoiceItems(list,-1,object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity, "${list[p1]}", Toast.LENGTH_SHORT).show()
                }

            })
            dialog.show()
            true
        }
    }
}