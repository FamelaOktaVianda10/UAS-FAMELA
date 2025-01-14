package id.ac.polbeng.famela.uasfamela

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.GravityCompat
import android.view.View
import android.widget.AdapterView
import id.ac.polbeng.famela.uasfamela.DetailActivity
import id.ac.polbeng.famela.uasfamela.ListViewActivity
import id.ac.polbeng.famela.uasfamela.R
import id.ac.polbeng.famela.uasfamela.WisataAdapter
import id.ac.polbeng.famela.uasfamela.WisataData

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        listView = findViewById(R.id.menu_list)

        val wisataList = WisataData.listDataWisata
        val adapter = WisataAdapter(this, wisataList)
        listView.adapter = adapter

        val menuButton: AppCompatImageButton = findViewById(R.id.menu_button)
        menuButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

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

    fun openListViewPage(view: View) {
        // Intent atau logika untuk membuka halaman ListView
        val intent = Intent(this, ListViewActivity::class.java)
        startActivity(intent)
    }
}




