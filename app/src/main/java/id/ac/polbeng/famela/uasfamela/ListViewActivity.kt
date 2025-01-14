package id.ac.polbeng.famela.uasfamela

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.polbeng.famela.uasfamela.R
import id.ac.polbeng.famela.uasfamela.WisataAdapter
import id.ac.polbeng.famela.uasfamela.WisataData

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.listViewData)

        val wisataList = WisataData.listDataWisata
        val adapter = WisataAdapter(this, wisataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val wisata = wisataList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("namaWisata", wisata.nama)
                putExtra("detailWisata", wisata.detail)
                putExtra("gambarWisata", wisata.gambar)
                putExtra("lokasiWisata", wisata.lokasi)
                putExtra("ratingWisata", wisata.rating.toFloat())
                putExtra("ulasanWisata", wisata.ulasan)
            }
            startActivity(intent)
        }
    }
}
