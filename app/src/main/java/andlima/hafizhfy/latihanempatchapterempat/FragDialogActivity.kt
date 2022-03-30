package andlima.hafizhfy.latihanempatchapterempat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_frag_dialog.*
import kotlinx.android.synthetic.main.fragment_custom_dialog.*

class FragDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_dialog)

        val namaBarang = et_nama_barang.text
        val jumlah = et_jumlah_barang.text
        val hargaSatuan = et_harga_barang.text
        var total : Int
//        var bayar : Int
        var kembalian : Int


        btn_hitung.setOnClickListener {
            if (namaBarang.toString() != "" && jumlah.toString() != "" && hargaSatuan.toString() != "") {
                val dialog = CustomDialogFragment()

                val bundle = Bundle()
                bundle.putString("NAMA_BARANG", namaBarang.toString())
                bundle.putString("JUMLAH", jumlah.toString())
                bundle.putString("HARGA_SATUAN", hargaSatuan.toString())

                dialog.arguments = bundle
                dialog.show(supportFragmentManager, "Pembayaran")

//                val getBayar = Bundle()
//                val bayar = getBayar.getString("BAYAR")
//                Toast.makeText(this, "$bayar", Toast.LENGTH_LONG).show()



            } else {
                Toast.makeText(this, "Mohon lengkapi struk belanja", Toast.LENGTH_LONG).show()
            }
        }


        // ~~~~ Ini masih nyobain ~~~~
        val bund = intent.extras
        val bayar = bund?.getString("BAYAR")

        if (bayar != null) {
            Toast.makeText(this, "$bayar", Toast.LENGTH_LONG).show()

            show_more_data.visibility = View.VISIBLE
//
//            total = jumlah.toString().toInt() * hargaSatuan.toString().toInt()
//            kembalian = bayar.toInt() - total
//
//            et_show_nama_barang.setText(namaBarang.toString())
//            et_show_jumlah_barang.setText(jumlah.toString())
//            et_harga_barang.setText("Rp $hargaSatuan")
//            et_show_total.setText("Rp $total")
//            et_show_kembalian.setText("Rp $kembalian")


        }

    }
}