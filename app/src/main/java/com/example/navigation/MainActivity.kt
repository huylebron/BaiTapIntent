package com.example.navigation

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.databinding.MainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: MainBinding
    lateinit var myDB: MyDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = MainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        myDB = MyDB(this, "huylebron", 1)

        // Load data from database into EditText fields
        val sql = myDB.readableDatabase
        val cursor = sql.rawQuery("select * from sv", null)
        if (cursor.moveToFirst()) {
            bind.edTt1.setText(cursor.getString(0))
            bind.edTt2.setText(cursor.getString(1))
            bind.edTt3.setText(cursor.getString(2))
        }
        cursor.close()

        bind.btOk.setOnClickListener {
            val nav = Intent(this, MainActivity2::class.java)
            nav.putExtra("tt1", bind.edTt1.text.toString())
            nav.putExtra("tt2", bind.edTt2.text.toString())
            nav.putExtra("tt3", bind.edTt3.text.toString())
            nav.putExtra("tt4", bind.edTt4.text.toString())

            var t = "có"
            if (bind.rgMain.checkedRadioButtonId == R.id.rb_khong)
                t = "không"
            nav.putExtra("tt6", t)

            startActivity(nav)
        }

        bind.btSubmit.setOnClickListener {
            val sql = myDB.writableDatabase
            val content = ContentValues()
            content.put("ten", bind.edTt1.text.toString())
            content.put("lop", bind.edTt2.text.toString())
            content.put("sdt", bind.edTt3.text.toString())
            val k = sql.insert("sv", null, content)
            if (k > 0) {
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_LONG).show()
            }
        }

        bind.btUpdate.setOnClickListener {
            val name = bind.edTt1.text.toString()

            editStudent(name)
            Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_LONG).show()
        }

        bind.btDelete.setOnClickListener {
            val name = bind.edTt1.text.toString()
            deleteStudent(name)
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_LONG).show()
        }
    }

    fun editStudent(name: String) {
        val sql = myDB.writableDatabase
        val content = ContentValues()

        val whereClause = "ten = ?"
        val whereArgs = arrayOf(name)
        sql.update("sv", content, whereClause, whereArgs)
    }

    fun deleteStudent(name: String) {
        val sql = myDB.writableDatabase
        val whereClause = "ten = ?"
        val whereArgs = arrayOf(name)
        sql.delete("sv", whereClause, whereArgs)
    }
}