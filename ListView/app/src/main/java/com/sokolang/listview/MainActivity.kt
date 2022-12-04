package com.sokolang.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sokolang.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i
        )

        val name = arrayOf(
            "Tom", "Bob", "Mike", "Alex", "Lisa", "Helen", "Marta","Tod", "Sam"
        )

        val lastMessage = arrayOf(
            "Hey", "Supp", "Lets go", "Yes", "No", "Gotta do", "I m in meeting", "Gotcha", "Any plans?"
        )
        val lastmsgTime = arrayOf(
            "7:45 pm","7:45 pm","7:45 pm","7:45 pm","7:45 pm","7:45 pm","7:45 pm","7:45 pm","7:45 pm"
        )
        val phoneNo = arrayOf(
            "237548","237548","237548","237548","237548","237548","237548","237548","237548"
        )
        val country = arrayOf(
            "USA", "Germany", "Sweden", "China","USA", "Germany", "Sweden", "China","Thai"
        )

        userArrayList = ArrayList()

        for( i in name.indices){
            val user = User(name[i], lastMessage[i], lastmsgTime[i], phoneNo[i], country[i], imageId[i])
            userArrayList.add(user)
        }
        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val imageId = imageId[position]


            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("phone", phone)
            i.putExtra("country", country)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
}