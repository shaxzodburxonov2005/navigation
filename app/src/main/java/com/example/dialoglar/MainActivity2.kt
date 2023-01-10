package com.example.dialoglar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.dialoglar.adapter.Adapter
import com.example.dialoglar.databinding.ActivityMain2Binding
import com.example.dialoglar.databinding.ItemBinding
import com.example.dialoglar.model.Dialog

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    lateinit var adapter:Adapter
    lateinit var list:ArrayList<Dialog>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
         list=ArrayList()
        adapter= Adapter(list)
        binding.rv.adapter=adapter
        binding.btnCustom.setOnClickListener {
            val customDialog=AlertDialog.Builder(this).create()
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setCancelable(false)
            val dialogview=LayoutInflater.from(this).inflate(R.layout.item,binding.root,false)
            customDialog.setView(dialogview)
            val bind=ItemBinding.bind(dialogview)
            bind.cacel.setOnClickListener {
                customDialog.dismiss()
            }
            bind.botomSave.setOnClickListener {
                val name=bind.etName.text.toString()
                val number=bind.etNumber.text.toString()
                val user=Dialog(name,number)
                list.add(user)
                adapter.notifyItemInserted(list.size-1)
                customDialog.dismiss()

            }
            customDialog.show()
        }
    }
}