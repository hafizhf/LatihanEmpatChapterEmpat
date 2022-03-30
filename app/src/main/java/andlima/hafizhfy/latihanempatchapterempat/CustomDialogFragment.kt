package andlima.hafizhfy.latihanempatchapterempat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_custom_dialog.*

class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get data dari FragDialogActivity
        val namaBarang = arguments?.getString("NAMA_BARANG")
        val jumlah = arguments?.getString("JUMLAH")
        val hargaSatuan = arguments?.getString("HARGA_SATUAN")

        val total = jumlah?.let { hargaSatuan?.toInt()?.times(it.toInt()) }

        et_show_nama_barang_temp.setText("$namaBarang x $jumlah")
        et_show_total_temp.setText(total.toString())

        btn_bayar.setOnClickListener {
            if (et_pembayaran.text.toString() == "") {
                Toast.makeText(
                    requireContext(),
                    "Mohon masukkan besar pembayaran",
                    Toast.LENGTH_LONG
                )
                    .show()

            } else if (et_pembayaran.text.toString().toInt() < total!!) {
                Toast.makeText(
                    requireContext(),
                    "Besar pembayaran kurang dari total",
                    Toast.LENGTH_LONG
                )
                    .show()

            } else {
                val bayar = et_pembayaran.text.toString()

//                val mainScreen = CustomDialogFragment()
                val bundle = Bundle()
                bundle.putString("BAYAR", bayar)
//                mainScreen.arguments = bundle

                // ~~~~ Ini nyoba pake Intent ~~~~
                val pindah = Intent(requireContext(), FragDialogActivity::class.java)
                pindah.putExtras(bundle)
                startActivity(pindah)

                dismiss()

                // ~~~~~~ apa lanjutannya ~~~~~~
            }
        }
    }
}