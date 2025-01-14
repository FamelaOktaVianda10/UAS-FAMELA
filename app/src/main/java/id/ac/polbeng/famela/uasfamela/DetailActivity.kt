package id.ac.polbeng.famela.uasfamela

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.polbeng.famela.uasfamela.R

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        val namaWisata = intent.getStringExtra("namaWisata")
        val detailWisata = intent.getStringExtra("detailWisata")
        val gambarWisata = intent.getIntExtra("gambarWisata", R.drawable.ic_launcher_background)
        val lokasiWisata = intent.getStringExtra("lokasiWisata")
        val ratingWisata = intent.getFloatExtra("ratingWisata", 0f)
        val ulasanWisata = intent.getIntExtra("ulasanWisata", 0)

        val imageView: ImageView = findViewById(R.id.img_item_photo)
        val namaText: TextView = findViewById(R.id.tv_nama)
        val detailText: TextView = findViewById(R.id.tv_detail)
        val lokasiText: TextView = findViewById(R.id.tv_lokasi)
        val ratingText: TextView = findViewById(R.id.tv_rating)
        val ulasanText: TextView = findViewById(R.id.tv_ulasan)

        imageView.setImageResource(gambarWisata)
        namaText.text = namaWisata
        detailText.text = detailWisata
        lokasiText.text = lokasiWisata
        ratingText.text = ratingWisata.toString()
        ulasanText.text = ulasanWisata.toString()
    }
    }
