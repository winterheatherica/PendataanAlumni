package pnj.uts.ti.nama_mahasiswa

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String,
    val nim: String,
    val nama: String,
    val kelas: String
) : Parcelable
