package com.pamlanjut.evolvance20.view.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.PaymentDetail
import com.pamlanjut.evolvance20.view.checkout.components.DetailProductCard
import com.pamlanjut.evolvance20.view.checkout.components.PaymentCard
import com.pamlanjut.evolvance20.view.components.Button
import com.pamlanjut.evolvance20.view.components.layout.MainLayout

@Composable
fun CheckoutScreen(
    viewModel: CheckoutViewModel,
    id: Int,
    navController: NavController
) {
    LaunchedEffect(id) {
        viewModel.paymentData(id)
    }

    val selectedPayment by viewModel.paymentDetail.collectAsState()
    val paymentMethod: List<PaymentMethod> = listOf(
        PaymentMethod("Shopeepay", "+62 8776637647", R.drawable.icon_shopeepay),
        PaymentMethod("OVO", "+62 8776637647", R.drawable.icon_ovo),
        PaymentMethod("DANA", "+62 8776637647", R.drawable.icon_dana),
        PaymentMethod("Gopay", "+62 8776637647", R.drawable.icon_gopay),
        PaymentMethod("QRIS", "", R.drawable.icon_qris),
    )

    MainLayout(
        content = {
            ScreenLayout(
                selectedPayment, paymentMethod, viewModel, navController
            )
        },
        showBottomBar = false,
        navController
    )
}

@Composable
fun ScreenLayout(
    selectedPayment: PaymentDetail?,
    paymentMethod: List<PaymentMethod>,
    viewModel: CheckoutViewModel,
    navController: NavController
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(18.dp, 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                // Product Purchase
                Text(
                    "Produk yang Dibeli",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                DetailProductCard(
                    name = selectedPayment?.name,
                    price = selectedPayment?.price
                )

                // Payment Method
                Text(
                    "Metode Pembayaran",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    paymentMethod.forEach {
                            it -> PaymentCard(
                        paymentMethod = it,
                        onClick = {
                            viewModel.selectPaymentMethod(it.name)
                        },
                        isSelected = it.name == selectedPayment?.paymentMethod
                    )
                    }
                }
            }
        }

        item {
            Spacer(
                Modifier.height(15.dp)
            )
            Button(
                onClick = {
                    navController.navigate("checkout/detail")
                },
                text = "Berikutnya",
                modifier = Modifier.padding(0.dp, 24.dp)
            )
        }
    }
}

data class PaymentMethod(
    val name: String,
    val desc: String,
    val images: Int
)