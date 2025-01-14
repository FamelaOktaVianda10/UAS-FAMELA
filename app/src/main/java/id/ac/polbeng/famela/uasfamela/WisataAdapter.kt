package id.ac.polbeng.famela.uasfamela

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.BaseAdapter
import id.ac.polbeng.famela.uasfamela.R
import id.ac.polbeng.famela.uasfamela.Wisata

class WisataAdapter(private val context: Context, private val wisataList: List<Wisata>) : BaseAdapter() {

    override fun getCount(): Int = wisataList.size

    override fun getItem(position: Int): Any = wisataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)

        val wisata = getItem(position) as Wisata
        val imageView: ImageView = view.findViewById(R.id.imageWisata)
        val namaText: TextView = view.findViewById(R.id.namaWisata)

        imageView.setImageResource(wisata.gambar)
        namaText.text = wisata.nama

        return view
    }
}
