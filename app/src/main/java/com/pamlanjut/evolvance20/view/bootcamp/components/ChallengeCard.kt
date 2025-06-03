package com.pamlanjut.evolvance20.view.bootcamp.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.data.remote.api.FileUpload
import com.pamlanjut.evolvance20.domain.model.Week
import com.pamlanjut.evolvance20.utils.helper.getFileNameFromUri
import com.pamlanjut.evolvance20.utils.helper.toCapitalizedWords
import com.pamlanjut.evolvance20.view.bootcamp.BootcampViewModel
import com.pamlanjut.evolvance20.view.components.VideoPlayer

@Composable
fun ChallengeCard(
    week: Week,
    index: Int,
    viewModel: BootcampViewModel
) {
    var visible by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val fileUploadStates by viewModel.fileUploadStates.collectAsStateWithLifecycle()
    val currentFileState = fileUploadStates[week.id] ?: FileUpload()

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val fileName = getFileNameFromUri(context, it)
            viewModel.onFileSelected(week.id, it, fileName)
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (week.status == "belum tersedia") Color.Gray else Color.White
            )
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
            .clickable {
                visible = !visible
            }
            .padding(20.dp, 16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    "Minggu #${(index + 1).toString()}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = if (week.status == "belum tersedia") Color.White else colorResource(R.color.main_color)
                )
                Text(
                    text = week.status.toCapitalizedWords(),
                    fontWeight = FontWeight.Bold,
                    color = if (week.status == "belum tersedia") Color.Red
                    else if (week.status == "Dalam Pengerjaan") Color(0xFFDFB400)
                    else Color.Green
                )
            }
            Icon(
                imageVector = if (visible) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = if (week.status == "belum tersedia") Color.Gray else colorResource(R.color.main_color))
                    .padding(3.dp)
            )
        }

        AnimatedVisibility(
            visible = if (week.status == "belum tersedia") false else visible,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut(),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Video
                Text("Video Materi", fontWeight = FontWeight.Bold)
                VideoPlayer(
                    videoUrl = "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/720/Big_Buck_Bunny_720_10s_10MB.mp4",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                // Description
                Text("Penugasan", fontWeight = FontWeight.Bold)
                Text(week.assignment?.description ?: "")

                // Pengumpulan
                Text("Pengumpulan", fontWeight = FontWeight.Bold)
                when {
                    currentFileState.selectedFileName != null -> {
                        PdfCard(
                            name = "${currentFileState.selectedFileName}"
                        )
                    }
                    currentFileState.errorMessage != null -> {
                        Text(
                            text = "Error: ${currentFileState.errorMessage}",
                            color = MaterialTheme.colorScheme.error,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    else -> {
                        Text("Pilih file untuk dikumpulkan")
                    }
                }
                if (currentFileState.uploadSuccess) {
                    Text(
                        text = "File berhasil dikumpulkan!",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(Modifier.height(5.dp))

                // Button
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            if (currentFileState.selectedFileUri == null) {
                                filePickerLauncher.launch("*/*")
                            } else {
                                viewModel.uploadAssignmentFile(week.id, 1)
                            }
                        },
                        enabled = !currentFileState.isUploading,
                        modifier = Modifier.height(34.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.main_color),
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 30.dp)
                    ) {
                        if (currentFileState.isUploading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = if (currentFileState.selectedFileUri == null) "Tambah" else "Simpan",
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}