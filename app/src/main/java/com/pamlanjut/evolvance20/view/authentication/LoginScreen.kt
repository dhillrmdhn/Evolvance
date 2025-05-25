package com.pamlanjut.evolvance20.view.authentication

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pamlanjut.evolvance20.R

@Composable
fun LoginScreen(
    viewModel: AuthenticationViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainbackground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().alpha(0.7f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp, 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
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
            }

            Text(
                "Login",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.main_color)
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
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
                            value = email,
                            onValueChange = {
                                email = it
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
                            value = password,
                            onValueChange = {
                                password = it
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

                Spacer(
                    Modifier.height(8.dp)
                )

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            viewModel.login(
                                email, password
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.main_color),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            "Masuk"
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
                }

                when (loginState) {
                    is LoginState.Loading -> CircularProgressIndicator()
                    is LoginState.Success -> Text("Logged in! Token: ${(loginState as LoginState.Success).token}")
                    is LoginState.Error -> Text("Error: ${(loginState as LoginState.Error)}", color = Color.Red)
                    else -> {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
}