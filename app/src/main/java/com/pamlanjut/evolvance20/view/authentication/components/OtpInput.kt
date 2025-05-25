package com.pamlanjut.evolvance20.view.authentication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpInput(
    otp: List<Int?>,
    onOtpChange: (List<Int?>) -> Unit
) {
    val focusRequest = List(6) { FocusRequester() }

    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        otp.forEachIndexed{
            index, digit ->
                OutlinedTextField(
                value = digit?.toString() ?: "",
                onValueChange = {
                    newDigit ->
                    if (newDigit.length <= 1) {
                        val digitList = otp.toMutableList()
                        if (newDigit.isNotEmpty() && newDigit[0].isDigit()) {
                            digitList[index] = newDigit.toInt()
                            onOtpChange(digitList)

                            if (index < 5) {
                                focusRequest[index + 1].requestFocus()
                            }
                        } else if (newDigit.isEmpty()) {
                            digitList[index] = null
                            onOtpChange(digitList)

                            if (index > 0) {
                                focusRequest[index - 1].requestFocus()
                            }
                        }
                    }
                },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(48.dp)
                    .height(56.dp)
                    .focusRequester(focusRequest[index]),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
        }
    }

    LaunchedEffect(Unit) {
        focusRequest[0].requestFocus()
    }
}