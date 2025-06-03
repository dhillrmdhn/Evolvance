package com.pamlanjut.evolvance20.view.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R

@Composable
fun RegisterTnCScreen(
    viewModel: AuthenticationViewModel,
    navController: NavController
) {

    Box(
        Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background_auth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().alpha(0.7f)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(25.dp, 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
//            Heading
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logotext),
                    contentDescription = "Logo Text Evolvance",
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = 2.5f
                            scaleY = 2.5f
                        }
                        .align(Alignment.Center)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(35.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Text(
                "Syarat dan Ketentuan",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.main_color)
                )
            )

            // Content
            Column(
                Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Text(
                    "Selamat datang di Pathia! Dengan menggunakan aplikasi ini, Anda menyetujui Syarat dan Ketentuan yang berlaku berikut ini. Harap dibaca dengan saksama.\n" +
                            "1. Tentang Aplikasi\n" +
                            "Pathia adalah aplikasi pengembangan softskill yang dirancang khusus untuk membantu Gen Z mempersiapkan diri menghadapi dunia kerja melalui modul pembelajaran, tantangan, dan fitur lainnya.\n" +
                            "2. Akun Pengguna\n" +
                            "Anda wajib membuat akun untuk dapat mengakses fitur penuh aplikasi.\n" +
                            "Anda bertanggung jawab atas keamanan akun Anda, termasuk penggunaan kata sandi.\n" +
                            "Anda tidak diperbolehkan memberikan informasi yang palsu saat mendaftar.\n" +
                            "3. Penggunaan Aplikasi\n" +
                            "Aplikasi hanya boleh digunakan untuk tujuan pribadi dan non-komersial.\n" +
                            "Anda dilarang menggunakan aplikasi untuk aktivitas yang melanggar hukum, menyesatkan, atau merugikan pihak lain.\n" +
                            "4. Hak Kekayaan Intelektual\n" +
                            "Semua materi di dalam aplikasi (teks, desain, logo, modul, video) adalah milik Pathia atau mitra kami, dan dilindungi oleh hukum.\n" +
                            "Anda tidak diperkenankan menyalin, mengubah, atau mendistribusikan konten tanpa izin tertulis.\n" +
                            "5. Privasi Pengguna\n" +
                            "Data pribadi Anda akan kami jaga sesuai dengan Kebijakan Privasi kami.\n" +
                            "Kami tidak akan membagikan data Anda ke pihak ketiga tanpa izin Anda, kecuali diwajibkan oleh hukum.\n" +
                            "6. Pembayaran dan Layanan Premium\n" +
                            "Beberapa fitur mungkin bersifat berbayar (premium).\n" +
                            "Pembayaran dilakukan melalui mitra pembayaran resmi kami, dan semua transaksi tidak dapat dibatalkan atau dikembalikan, kecuali ada kesalahan sistem.\n" +
                            "7. Penghentian Akses\n" +
                            "Kami berhak menghentikan atau menangguhkan akun Anda jika ditemukan pelanggaran terhadap Syarat dan Ketentuan ini.\n" +
                            "Anda juga dapat menutup akun Anda kapan saja melalui pengaturan.\n" +
                            "8. Perubahan Syarat dan Ketentuan\n" +
                            "Kami dapat memperbarui Syarat dan Ketentuan ini dari waktu ke waktu. Perubahan akan diberitahukan melalui aplikasi atau email.\n" +
                            "9. Kontak Kami\n" +
                            "Jika Anda memiliki pertanyaan terkait Syarat dan Ketentuan ini, silakan hubungi kami di:\u2028 \uD83D\uDCE7 support@pathia.app",

                    style = TextStyle(
                        textAlign = TextAlign.Justify,
                        lineHeight = 20.sp
                    )
                )
                Button(
                    onClick = {
                        viewModel.updateCheck(true)
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.main_color),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Saya Setuju"
                    )
                }
            }
        }
    }
}