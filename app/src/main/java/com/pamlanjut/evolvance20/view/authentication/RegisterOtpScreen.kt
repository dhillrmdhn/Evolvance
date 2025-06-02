package com.pamlanjut.evolvance20.view.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.pamlanjut.evolvance20.data.remote.api.VerifyOtpRequest
import com.pamlanjut.evolvance20.view.authentication.components.OtpInput
import com.pamlanjut.evolvance20.view.authentication.components.SuccessModal
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun RegisterOtpScreen(
    viewModel: AuthenticationViewModel,
    navController: NavController
) {
    // Otp
    val otpDigits = remember { mutableStateListOf<Int?>(null, null, null, null, null, null) }
    val user by viewModel.registerRequestState.collectAsState()
    val otpDigitsString = otpDigits.joinToString("")

    // Local State
    val authUiState by viewModel.authUiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    // Timeleft
    var timeleft by remember { mutableIntStateOf(600) }
    var disableButton by remember { mutableStateOf(false) }

    LaunchedEffect(
        key1 = timeleft
    ) {
        while (timeleft > 0) {
            delay(1000L)
            timeleft--
        }
        disableButton = true
    }

    val minute = timeleft / 60
    val second = timeleft % 60
    val timeleftString = String.format("%02d:%02d", minute, second)

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_auth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(25.dp, 90.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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

                Column(
                    Modifier
                        .padding(0.dp, 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Text(
                        "Verifikasi",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.main_color)
                        )
                    )

                    Column (
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            "Masukkan kode 6 digit yang sudah kami kirimkan melalui email ${user.email}.",
                            style = TextStyle(
                                textAlign = TextAlign.Justify,
                                lineHeight = 20.sp
                            )
                        )
                        Text(
                            "Masa berlaku kode akan berakhir dalam $timeleftString"
                        )
                    }

                    OtpInput(
                        otp = otpDigits,
                        onOtpChange = {
                            otpDigits.clear()
                            otpDigits.addAll(it)
                        },
                        isError = isError
                    )

                    if (isError) {
                        Text(
                            "Kode OTP salah, Silahkan coba lagi",
                            color = Color.Red
                        )
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(
                            0.5.dp,
                            colorResource(R.color.main_color),
                            RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                        contentColor = colorResource(R.color.main_color),
                    )
                ) {
                    Text(
                        "Kembali"
                    )
                }
                Button(
                    onClick = {
                        viewModel.verifyOtp(
                            VerifyOtpRequest(
                                user.email,
                                otpDigitsString
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.main_color),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.main_color).copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.5f)
                    ),
                    enabled = !disableButton
                ) {
                    Text(
                        "Berikutnya"
                    )
                }
            }

            if (showDialog) {
                SuccessModal(
                    show = showDialog,
                    onDismiss = {
                        showDialog = false
                    },
                    navController
                )
            }

            LaunchedEffect(authUiState) {
                when (authUiState) {
                    is AuthUiState.Success -> {
                        showDialog = true
                        delay(100)
                        viewModel.resetState()
                    }
                    is AuthUiState.Error -> {
                        isError = true
                        viewModel.resetState()
                    }
                    else -> {}
                }
            }

        }
    }
}