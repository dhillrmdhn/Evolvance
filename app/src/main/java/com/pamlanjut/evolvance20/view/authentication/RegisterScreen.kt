package com.pamlanjut.evolvance20.view.authentication

import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.data.remote.api.RegisterRequest

@Composable
fun RegisterScreen(
    viewModel: AuthenticationViewModel,
    tncNavigate: () -> Unit
) {
    val registerRequest by viewModel.registerRequestState.collectAsState()
    val isChecked by viewModel.isChecked.collectAsState()

    val registerState by viewModel.registerState.collectAsState()
    var isVisible by remember { mutableStateOf(false) }

    Box(
        Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.mainbackground),
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
                        modifier = Modifier.fillMaxSize(),
                        tint = Color.White
                    )
                }
            }

            Text(
                "Register",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.main_color)
                )
            )

//          Form
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Nama Lengkap",
                        fontWeight = FontWeight.Bold,
                    )
                    Box(
                        modifier = Modifier
                            .height(52.dp)
                            .fillMaxWidth()
                            .border(0.5.dp, Color.Black, RoundedCornerShape(16.dp))
                            .background(Color.Transparent, RoundedCornerShape(16.dp))
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        BasicTextField(
                            value = registerRequest.name,
                            onValueChange = {
                                viewModel.updateRegisterRequest(
                                    registerRequest.copy(
                                        name = it
                                    )
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Black
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Alamat Email",
                        fontWeight = FontWeight.Bold,
                    )
                    Box(
                        modifier = Modifier
                            .height(52.dp)
                            .fillMaxWidth()
                            .border(0.5.dp, Color.Black, RoundedCornerShape(16.dp))
                            .background(Color.Transparent, RoundedCornerShape(16.dp))
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        BasicTextField(
                            value = registerRequest.email,
                            onValueChange = {
                                viewModel.updateRegisterRequest(
                                    registerRequest.copy(
                                        email = it
                                    )
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Black
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Kata Sandi",
                        fontWeight = FontWeight.Bold,
                    )
                    Row(
                        modifier = Modifier
                            .height(52.dp)
                            .fillMaxWidth()
                            .border(0.5.dp, Color.Black, RoundedCornerShape(16.dp))
                            .background(Color.Transparent, RoundedCornerShape(16.dp))
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BasicTextField(
                            value = registerRequest.password,
                            onValueChange = {
                                viewModel.updateRegisterRequest(
                                    registerRequest.copy(
                                        password = it
                                    )
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Black
                            ),
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
                        )
                        IconButton(
                            onClick = {
                                isVisible = !isVisible
                            }
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (isVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                                ),
                                contentDescription = "Visible Button"
                            )
                        }
                    }
                }
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Konfirmasi Kata Sandi",
                        fontWeight = FontWeight.Bold,
                    )
                    Row(
                        modifier = Modifier
                            .height(52.dp)
                            .fillMaxWidth()
                            .border(0.5.dp, Color.Black, RoundedCornerShape(16.dp))
                            .background(Color.Transparent, RoundedCornerShape(16.dp))
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BasicTextField(
                            value = registerRequest.password_confirmation,
                            onValueChange = {
                                viewModel.updateRegisterRequest(
                                    registerRequest.copy(
                                        password_confirmation = it
                                    )
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Black
                            ),
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
                        )
                        IconButton(
                            onClick = {
                                isVisible = !isVisible
                            }
                        ) {
                            Image(
                                painter = painterResource(
                                    id = if (isVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                                ),
                                contentDescription = "Visible Button"
                            )
                        }
                    }
                }

//              Checkbox
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(0.dp)
                            .size(20.dp)
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = {
                                if (!isChecked) {
                                    tncNavigate()
                                } else {
                                    viewModel.updateCheck(false)
                                }
                            },
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(0.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        text = "Dengan ini saya membaca, memahami, dan menyetujui hal-hal yang tercantum pada Syarat dan Ketentuan yang berlaku.",
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .weight(1f),
                        style = TextStyle(
                            fontSize = 12.sp,
                            textAlign = TextAlign.Justify
                        )
                    )
                }

//              Button
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = {
                            viewModel.register(registerRequest)
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
                        enabled = isChecked
                    ) {
                        Text(
                            "Daftar"
                        )
                    }
                    Text(
                        "Atau Gunakan",
                        fontSize = 12.sp,
                    )
                    val context = LocalContext.current
                    Button(
                        onClick = {
                            Toast.makeText(context, "Fitur Sementara Tidak Tersedia", Toast.LENGTH_SHORT).show()
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
                        enabled = isChecked
                    ) {
                        Text(
                            "Google"
                        )
                    }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            "Sudah memiliki akun?",
                            style = TextStyle(
                                fontSize = 12.sp
                            )
                        )
                        Text(
                            "Masuk",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(R.color.main_color)
                            ),
                            modifier = Modifier.clickable {  }
                        )
                    }

                    Spacer(Modifier.height(10.dp))

                    when(registerState) {
                        is RegisterState.Loading -> CircularProgressIndicator()
                        is RegisterState.Error -> Text((registerState as RegisterState.Error).message, color = Color.Red, textAlign = TextAlign.Center)
                        else -> {}
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordView() {
}