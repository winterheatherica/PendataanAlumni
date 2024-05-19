package pnj.uts.ti.nama_mahasiswa

import android.os.Parcel
import android.os.Parcelable

data class Berita(
    val title: String,
    val description: String,
    val imageResId: Int,
    val fullDescription: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(imageResId)
        parcel.writeString(fullDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Berita> {
        override fun createFromParcel(parcel: Parcel): Berita {
            return Berita(parcel)
        }

        override fun newArray(size: Int): Array<Berita?> {
            return arrayOfNulls(size)
        }
    }
}
