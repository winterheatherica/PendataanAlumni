//BeritaFragment.kt
package pnj.uts.ti.nama_mahasiswa

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment(), OnBeritaClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inisialisasi daftar berita
        val beritaList = mutableListOf(
            Berita("Pesawat Jatuh di BSD City", "Sebuah pesawat jatuh di BSD City, Serpong, Tangerang Selatan. (CNN Indonesia/Suriyanto)", R.drawable.ber1, "Jakarta, CNN Indonesia -- Sebuah pesawat jatuh di Lapangan Sunburst, BSD City, Serpong, Tangerang Selatan, Minggu (19/5). Peristiwa terjadi sekitar 13.40 WIB. Kondisi badan pesawat dengan kode PK-IFR terlihat hancur, terutama di bagian depan. Dikabarkan ada korban jiwa dalam peristiwa ini, namun belum dipastikan berapa jumlahnya."),
            Berita("Pakai Jet Pribadi, Potret Detik-Detik Elon Musk Tiba di Bali", "Pengusaha teknologi AS, Elon Musk tiba di Terminal VVIP Bandara I Gusti Ngurah Rai, Bali dengan jet pribadinya untuk peluncuran Starlink di Indonesia.", R.drawable.ber2, "Pengusaha teknologi AS, Elon Musk tiba di Terminal VVIP Bandara I Gusti Ngurah Rai, Bali dengan jet pribadinya untuk peluncuran Starlink di Indonesia."),
            Berita("Pengakuan Mengejutkan Saka Tatal soal Kasus Vina dan Eky Cirebon", "Cirebon - Saka Tatal, salah satu dari delapan terpidana kasus pembunuhan Vina dan Muhammad Rizky atau Eky, kini sudah menghirup udara bebas. Pemuda tersebut sempat menjalani hukuman penjara selama 3 tahun 8 bulan.", R.drawable.ber3, "Cirebon - Saka Tatal, salah satu dari delapan terpidana kasus pembunuhan Vina dan Muhammad Rizky atau Eky, kini sudah menghirup udara bebas. Pemuda tersebut sempat menjalani hukuman penjara selama 3 tahun 8 bulan.\n" +
                    "Ditemui detikJabar, Sabtu (18/5/2024) malam, Saka bercerita tentang penangkapan atas kasus tersebut. Saat itu dia masih berusia 15 tahun. Tiba-tiba Saka ditangkap polisi pada 31 Agustus 2016 karena dianggap telah membunuh Vina dan Eky.\n" +
                    "\n" +
                    "\"Jadi waktu sebelum penangkapan saya diminta tolong sama paman saya (Eka Sandi) buat isiin bensin motor. Udah beres mengisi bensin, saya kembalikan motor ke paman saya yang lagi nongkrong di dekat SMPN 11 Kota Cirebon,\" kata dia Saka.\n" +
                    "\n" +
                    "Ketika Saka mengembalikan sepeda motor milik pamannya, tanpa diduga terdapat anggota polisi sudah berada di lokasi dan sedang mengamankan sejumlah orang berikut pamannya. \"Motor saja belum dikasihin ke paman saya (Eka Sandi), tahu-tahu saya langsung ditangkap. Pas nangkap saja nggak ada penjelasan apapun, terus saya di bawa ke Polres Cirebon Kota,\" ujar Saka.\n" +
                    "\n" +
                    "Sesampainya di Polres Cirebon Kota, Saka mengaku dibawa ke salah satu ruangan dan menerima sejumlah bentuk penganiayaan dari sejumlah oknum polisi yang memaksanya untuk mengakui sebagai pelaku pembunuh Vina dan Eky.\n" +
                    "\n" +
                    "\"Pas sampai di kantor polisi itu saya nggak ditanya, tahu-tahu saya langsung disiksa, dipukulin, diinjak-injak sampai disetrum. Dipaksa buat mengaku,\" kata Saka.\n"),
            Berita("Innalillahi, Pengamat Militer dan Eks Wartawan Prof Salim Said Berpulang", "Salim Said wafat di Rumah Sakit Cipto Mangunkusumo, Sabtu malam WIB.", R.drawable.ber4, "Kabar duka menghampiri dunia jurnalis. Tokoh pers yang merupakan wartawan peliput Gerakan 30 September 1965/Partai Komunis Indonesia (G3S/PKI) Prof Salim Said dilaporkan berpulang pada Sabtu (18/5/2024). Kabar itu dibenarkan oleh sang istri Hera.\n" +
                    "Salim Said yang merupakan mantan duta besar RI untuk Republik Ceko dikenal sebagai pengamat militer sekaligus dosen di Universitas Pertahanan (Unhan). Salim mengembuskan napas terakhirnya di Rumah Sakit Cipto Mangunkusumo (RSCM), Jakarta Pusat pada Sabtu sekitar pukul 19.33 WIB.\n" +
                    "\"Malam ini jenazah disemayamkan di rumah duka, Jalan Redaksi Nomor 149, Komplek Wartawan PWI Cipinang, Jakarta Timur. Menurut rencana almarhum akan dikebumikan di TPU Tanah Kusir, Ahad (19/5/2024) siang WIB.\n"),
            Berita("Ribuan Jemaah RI Dilaporkan Belum Pulang, Diduga Lanjut Haji", "Ilustrasi. Wakil Ketua Komisi VIII DPR RI Marwan Dasopang menerima laporan 40 ribu jemaah umrah yang belum pulang ke Indonesia.", R.drawable.ber5, "Jakarta, CNN Indonesia -- Wakil Ketua Komisi VIII DPR RI Marwan Dasopang menerima laporan setidaknya ada 40 ribuan jemaah umrah belum pulang ke Indonesia. Mereka disinyalir hendak melanjutkan ibadah haji tanpa visa resmi.\n" +
                    "Marwan mengatakan, ribuan jemaah umrah ini dikhawatirkan akan diamankan otoritas Arab Saudi yang sedang memperketat pengawasan untuk jemaah haji.\n" +
                    "\n" +
                    "\"Pengawasan yang ketat ini, dilalui dengan cara diamankan. Diamankan itu, ya, ditahan dulu. Kita enggak bisa ngurus nanti setelah selesai haji, kan, cukup lama, paling tidak 40 hari,\" kata Marwan dikutip detikcom, Sabtu (18/5).\n" +
                    "\n" +
                    "\n" +
                    "Melihat itu, Marwan mengimbau masyarakat yang ingin ibadah haji untuk tetap sabar dan taat pada regulasi yang ada. Sebab, tanpa visa resmi, ibadah yang dilakukan nantinya tidak akan memenuhi standar pelaksanaan haji.\n" +
                    "\n" +
                    "Marwan juga mengingatkan pemerintah untuk melakukan pengawasan yang ketat terhadap jemaah haji ilegal tersebut.\n" +
                    "\n"),
            Berita("Libur Cuti Bersama Terancam, Bos-Bos Pengusaha Teriak ke Jokowi", "Antrean truk kontainer di Pelabuhan Tanjung Priok", R.drawable.ber6, "Jakarta, CNBC Indonesia - Para pengusaha di Indonesia telah meminta pemerintah untuk menghapus kebijakan cuti bersama atau menghapus libur untuk bidang usaha tertentu. Mereka pun telah meminta Presiden Joko Widodo (Jokowi) turun tangan dalam hal tersebut.\n" +
                    "Menurut mereka, cuti bersama karyawan di bidang usaha tertentu memiliki efek domino yang bisa mengganggu kegiatan ekonomi usaha lainnya.\n" +
                    "Hal itu disampaikan pengusaha nasional saat merespons kemacetan parah yang sempat terjadi di jalur menuju pelabuhan Tanjung Priok pada Rabu (15/5/2024) kemarin.\n" +
                    "Pasalnya kemacetan horor truk-truk kontainer di Jl. Raya Yos Sudarso - Sulawesi dan Jampea Tanjung Priok itu sebagai dampak dari libur panjang di pekan sebelumnya.\n" +
                    "Ketua Umum Gabungan Pengusaha Ekspor Indonesia (GPEI) Benny Soetrisno kepada CNBC Indonesia pekan ini menyebut Pelabuhan Laut Tanjung Priok atau mana pun yang melayani impor dan ekspor seharusnya buka selama 24 jam dan 7 hari dalam seminggu.\n" +
                    "\"Tidak ada libur karena jadwal kapal luar tidak mengikuti waktu libur Indonesia,\" katanya.\n" +
                    "Ia menyebut perlu ada peraturan dari pemerintah agar tak ada libur bagi kegiatan usaha terkait pelayanan publik. Benny menyebut regulasi dimaksud cukup berupa Keputusan Presiden (Keppres).\n" +
                    "\n"),
            Berita("Ini Gang Buntu yang Bikin Maling Berpistol Dikepung Warga Bekasi", "Gang buntu di Bekasi lokasi maling berpistol terkepung warga.", R.drawable.ber7, "Bekasi - Aksi maling berpistol di Pondok Gede, Bekasi sempat melepaskan tiga kali tembakan lalu kabur ke sebuah gang. Namun warga berhasil mengepung pelaku karena gang yang menjadi lokasi pelarian ternyata buntu.\n" +
                    "Gang itu terletak di Jalan H Gering, Rawa Bacang, Pondok Gede, Bekasi. Jaraknya sekitar 20 meter dari pertigaan tempat awal maling itu terjatuh dan melepaskan tembakan.\n" +
                    "\n" +
                    "Pantauan di lokasi, Minggu (19/5/2024), Jalan masuk gang itu punya lebar sekitar satu meter atau hanya masuk untuk satu motor. Di sana terdapat tower yang menjulang dan gerbang yang bisa dibuka tutup.\n"),
            Berita("Pesawat Latih yang Jatuh di BSD Tangsel Sempat Hilang Kontak", "Pesawat Jatuh", R.drawable.ber8, "Jakarta - Kepala Seksi Operasi (Kasiop) Badan SAR Nasional (Basarnas) DKI Jakarta Agung Priambodo mengatakan pesawat latih yang jatuh di kawasan BSD, Serpong, Tangsel, sempat hilang kontak. Tiga orang tewas dalam peristiwa ini.\n" +
                    "\"Lost contact pukul 14.43 WIB, komunikasi terakhir. Jatuhnya ini kita masih koordinasi,\" ujar Agung, kepada wartawan, Minggu (19/5/2024).\n" +
                    "\n" +
                    "Agung mengatakan pesawat yang jatuh merupakan pesawat latih. Pesawat jatuh di area Lapangan Sunburst, BSD.\n" +
                    "\n" +
                    "Sementara itu, Kabid Humas Polda Metro Jaya Kombes Ade Ary Syam Indradi menyampaikan dua orang tewas masih berada di dalam pesawat. Sementara satu korban tergeletak di tepi jalan.\n"),
            Berita("Jenazah Salim Said Disemayamkan di Rumah Duka di Kompleks PWI Jaktim", "Jenazah Prof Salim Said disemayamkan di rumah duka", R.drawable.ber9, "Jakarta - Prof Salim Haji Said meninggal dunia malam ini di RS Cipto Mangunkusumo (RSCM), Jakarta Pusat. Jenazah Salim Said disemayamkan di kediamannya di Kompleks PWI, Cipinang, Jakarta Timur.\n" +
                    "Dilansir Antara, Sabtu (18/5/2024), iring-iringan mobil ambulans yang mengangkut jenazah Salim Said tiba di kediaman sekitar pukul 22.30 WIB. Mobil jenazah diikuti beberapa mobil dari keluarganya.\n" +
                    "\n" +
                    "Keluarga dan beberapa kerabat dekat yang menunggu di rumah duka, yang beberapa di antaranya terlihat menitikkan air mata, menyambut kedatangan jenazah. Sejumlah anggota keluarga kemudian salat jenazah di sisi jasad almarhum, yang dibaringkan di ruang tamu.\n" +
                    "\n" +
                    "Di pelataran depan rumahnya, karangan bunga ucapan duka dari beberapa tokoh mulai berdatangan. Karangan bunga itu, yang ditempatkan berjejer tepat di kediaman, di antaranya Kepala Staf Kodam (Kasdam) IV/Diponegoro Brigjen TNI Budi Irawan, Badan Kebudayaan Nasional Pusat PDI Perjuangan, Deddy Mizwar, dan Forum Pemimpin Redaksi Indonesia.\n" +
                    "\n" +
                    "Sejak jasadnya tiba sampai pukul 23.00 WIB, pelayat mulai dari keluarga sampai kerabat dan sejawat terus berdatangan.\n"),
            Berita("Heru Budi: Siapa Pun Gubernur Selanjutnya, Jakarta Harus Unggul dari Kota-kota Lainnya di Dunia", "Gubernur Jakarta, Heru Budi Hartono, saat ditemui di Perpustakaan Nasional, Jakarta Pusat, Rabu (8/5/2024).", R.drawable.ber10, "JAKARTA, KOMPAS.com - Penjabat (Pj) Gubernur DKI Jakarta Heru Budi Hartono berharap, siapa pun yang kelak terpilih sebagai gubernur Jakarta dapat melanjutkan pembangunan dengan baik. Heru ingin Jakarta menjadi kota yang unggul di dunia.  \"Siapa pun yang memimpin Jakarta harus mendapatkan ranking yang terbaik dari kota-kota dunia lainnya,\" kata Heru usai acara Pencanangan Hari Ulang Tahun (HUT) ke-497 Jakarta di Bundaran HI, Jakarta Pusat, Minggu (19/5/2024). Heru menyebut, 2024 menjadi tahun terakhir bagi Jakarta menyandang status Ibu Kota Negara. Ini mengingat Undang-undang Daerah Khusus Jakarta (UU DKJ) telah disahkan. Kendati tidak lagi berstatus sebagai daerah istimewa, Heru berharap, masyarakat Jakarta tetap bisa hidup baik dengan fasilitas yang lengkap. \"Tujuan ke depan yang tadi saya sampaikan, nyaman buat masyarakat, nyaman bekerja, sarana prasarana cukup baik dan ekonomi tetap tumbuh,\" papar Heru. Ia juga ingin Jakarta banyak menyelenggarakan acara bertaraf internasional. Dengan demikian, kata Heru, pendapatan asli daerah (PAD) Jakarta bisa ditingkatkan. \"Bisa sport event (acara olahraga), bisa kuliner, bisa budaya, yang bisa menarik (investor). Kegiatannya kalau bisa setiap minggu, setiap bulan, sehingga ekonomi bisa berjalan,\" terang mantan Wali Kota Jakarta Utara itu. Adapun ketika berpidato di panggung Pencanangan HUT ke-497 Kota Jakarta, Heru sempat menyinggung soal perhelatan \"Jakarta International Marathon\". \"Di hari ulang tahun DKI, kami mengadakan 'Jakarta International Marathon' yang akan diselenggarakan tanggal 23 Juni 2024,\" ucap Heru. Heru mengizinkan atlet maraton dunia untuk turut serta meramaikan Jakarta International Marathon. Ia berharap, gelaran ini dapat memperkenalkan Jakarta ke kancah internasional. \"Tentunya atlet maraton internasional bisa ke sini. Maka dari itu saya minta partisipasi seluruh masyarakat untuk mengikuti Jakarta International Marathon,\" papar dia.\n" +
                    "\n"),
            // Tambahkan berita lainnya sesuai kebutuhan
        )

        val adapter = BeritaAdapter(beritaList, this) // Pass 'this' as the listener
        recyclerView.adapter = adapter

        return view
    }

    override fun onBeritaClick(berita: Berita) {
        val detailBeritaFragment = DetailBeritaFragment()
        val bundle = Bundle()
        bundle.putParcelable("berita", berita)
        detailBeritaFragment.arguments = bundle
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, detailBeritaFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}
