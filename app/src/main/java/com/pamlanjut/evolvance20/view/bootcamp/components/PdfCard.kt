package com.pamlanjut.evolvance20.view.bootcamp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R

@Composable
fun PdfCard(
    name: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) { 
        Image(
            painterResource(R.drawable.icon_doubleperson),
            contentDescription = "Icon",
            Modifier.weight(1f).size(30.dp)
        )
        Text(
            name,
            fontSize = 12.sp,
            color = colorResource(R.color.main_color),
            modifier = Modifier.weight(4f)
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Icon",
            tint = colorResource(R.color.main_color),
            modifier = Modifier.weight(1f)
        )
    }
}