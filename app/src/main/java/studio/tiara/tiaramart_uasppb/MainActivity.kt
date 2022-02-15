package studio.tiara.tiaramart_uasppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import studio.tiara.tiaramart_uasppb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>
    private lateinit var container : LinearLayout
    private lateinit var makanminum : LinearLayout
    private lateinit var rumahdapur : LinearLayout
    private lateinit var ibuanak : LinearLayout
    private lateinit var sehatcantik : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        container = findViewById(R.id.container)
        container.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        makanminum = findViewById(R.id.makanminum)
        makanminum.setOnClickListener {
            val intent = Intent(this, Food_DrinkActivity::class.java)
            startActivity(intent)
        }

        rumahdapur = findViewById(R.id.rumahdapur)
        rumahdapur.setOnClickListener {
            val intent = Intent(this, Rumah_DapurActivity::class.java)
            startActivity(intent)
        }

        ibuanak = findViewById(R.id.ibuanak)
        ibuanak.setOnClickListener {
            val intent = Intent(this, Ibu_AnakActivity::class.java)
            startActivity(intent)
        }

        sehatcantik = findViewById(R.id.sehatcantik)
        sehatcantik.setOnClickListener {
            val intent = Intent(this, Sehat_CantikActivity::class.java)
            startActivity(intent)
        }


        val image = intArrayOf(
            R.drawable.baner5,
            R.drawable.baner2,
            R.drawable.baner3,
            R.drawable.baner4,
            R.drawable.baner1,
        )
        for (i in image.indices){
            list.add(ImageData(image[i]))
        }
        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size) {
            if (position == i) {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.green_1))
            } else {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.green_200))
            }
        }
    }

    private fun setIndicator() {
        for (i in 0 until list.size) {
            dots.add(TextView(this))
            dots[i].text = " ● "
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }
}


