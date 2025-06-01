package com.pamlanjut.evolvance20.view.checkout

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.PaymentDetail
import com.pamlanjut.evolvance20.view.components.Button
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import com.pamlanjut.evolvance20.view.components.layout.MainLayout
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckoutStatus(
    viewModel: CheckoutViewModel,
    navController: NavController
) {
    val paymentDetail by viewModel.paymentDetail.collectAsState()

    MainLayout(
        content = {
            ScreenLayout(
                paymentDetail,
                viewModel,
                navController
            )
        },
        showBottomBar = false
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenLayout(
    paymentDetail: PaymentDetail?,
    viewModel: CheckoutViewModel,
    navController: NavController
) {
    var isPaymentSuccess by remember { mutableStateOf(false) }
    LaunchedEffect(isPaymentSuccess) {
        if (isPaymentSuccess) {
            viewModel.updatePayment()
        }
    }

    if (viewModel.isLoading.collectAsState().value) LoadingScreen() else {
        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp, 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Text(
                    "Status Pembayaran",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Column(
                    Modifier.fillMaxWidth().padding(0.dp, 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = if (isPaymentSuccess) R.drawable.baseline_check_24 else R.drawable.baseline_access_time_filled_24
                        ),
                        contentDescription = "Status Pembayaran",
                        Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(
                                if (isPaymentSuccess) colorResource(R.color.main_color) else Color(0xFFDFB400)
                            )
                            .padding(20.dp)
                    )
                    Text(
                        if (isPaymentSuccess) "Pembayaran Berhasil" else "Menunggu Pembayaran",
                        color = if (isPaymentSuccess) Color(0xFF1FC16B) else Color(0xFFDFB400),
                        fontSize = 16.sp
                    )
                }

                if (isPaymentSuccess) {
                    Text(
                        "Rincian Pembayaran",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Column(
                        Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Nomor Transaksi")
                            Text(paymentDetail?.paymentReference.toString() ?: "")
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Tanggal Pembayaran")
                            Text(paymentDetail?.paymentDate ?: "")
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Metode Pembayaran")
                            Text(paymentDetail?.paymentMethod ?: "")
                        }
                    }
                }
            }

            if (isPaymentSuccess) {
                Button(
                    onClick = {
                        navController.navigate("bootcamp/index") {
                            popUpTo("bootcamp/index") {
                                inclusive = true
                            }
                        }
                    },
                    text = "Kembali"
                )
            } else {
                Button(
                    onClick = {
                        isPaymentSuccess = true
                    },
                    text = "Konfirmasi Pembayaran"
                )
            }
        }
    }
}