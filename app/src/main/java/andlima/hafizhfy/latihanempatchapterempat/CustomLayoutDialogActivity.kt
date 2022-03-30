package andlima.hafizhfy.latihanempatchapterempat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_custom_layout_dialog.*
import kotlinx.android.synthetic.main.activity_custom_layout_dialog.view.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class CustomLayoutDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout_dialog)

        val namaBarang = et_nama_barang.text
        val jumlah = et_jumlah_barang.text
        val hargaSatuan = et_harga_barang.text
        var bayar : Int
        var kembalian : Int

        btn_hitung.setOnClickListener {
            if (namaBarang.toString() != "" && jumlah.toString() != "" && hargaSatuan.toString() != "") {
                val customDialog = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)

                val total = jumlah.toString().toInt() * hargaSatuan.toString().toInt()

                customDialog.et_show_nama_barang_temp.setText("$namaBarang x $jumlah")
                customDialog.et_show_total_temp.setText("Rp $total")

                val alert = AlertDialog.Builder(this)
                    .setView(customDialog)
                    .create()

                customDialog.btn_bayar.setOnClickListener {
                    if (customDialog.et_pembayaran.text.toString() == "") {
                        Toast.makeText(
                            this,
                            "Mohon masukkan besar pembayaran",
                            Toast.LENGTH_LONG
                        )
                            .show()

                    } else if (customDialog.et_pembayaran.text.toString().toInt() < total) {
                        Toast.makeText(
                            this,
                            "Besar pembayaran kurang dari total",
                            Toast.LENGTH_LONG
                        )
                            .show()

                    } else {
                        show_more_data.visibility = View.VISIBLE

                        bayar = customDialog.et_pembayaran.text.toString().toInt()

                        kembalian = bayar - total

                        et_show_nama_barang.setText(namaBarang.toString())
                        et_show_jumlah_barang.setText(jumlah.toString())
                        et_show_harga_barang.setText("Rp $hargaSatuan")
                        et_show_total.setText("Rp $total")
                        et_show_kembalian.setText("Rp $kembalian")

                        alert.dismiss()
                    }
                }

                alert.show()

            } else {
                Toast.makeText(this, "Mohon lengkapi struk belanja", Toast.LENGTH_LONG).show()
            }
        }
    }
}