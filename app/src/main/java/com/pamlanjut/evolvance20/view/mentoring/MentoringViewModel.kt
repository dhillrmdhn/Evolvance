package com.pamlanjut.evolvance20.view.mentoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.domain.model.MentoringModel
import com.pamlanjut.evolvance20.domain.usecase.mentoring.CreateMentoringOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MentoringViewModel @Inject constructor(
    private val createMentoringOrderUseCase: CreateMentoringOrderUseCase
): ViewModel() {
    private val _mentoringData = MutableStateFlow<MentoringModel?>(
        MentoringModel(
            tanggal = "",
            jam = "",
            durasi = "40 Menit",
            bidangPekerjaan = "",
            status = "",
            linkKonsultasi = "",
            linkDokuman = ""
        )
    )
    val mentoringData: StateFlow<MentoringModel?> = _mentoringData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun updateBidangPekerjaan(
        bidangPekerjaan: String
    ) {
        _mentoringData.value = mentoringData.value?.copy(
            bidangPekerjaan = bidangPekerjaan
        )
    }

    fun updateTanggal(
        tanggal: String
    ) {
        _mentoringData.update {
            it?.copy(tanggal = tanggal)
        }
    }

    fun updateWaktu(
        waktu: String
    ) {
        _mentoringData.update {
            it?.copy(
                jam = waktu,
                durasi = "40 Menit"
            )
        }
    }

    fun createMentoringOrder() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)

            val model = _mentoringData.value?.copy(
                status = "Pembayaran Berhasil",
                linkKonsultasi = "https://meet.google.com/cwm-kkj-jusy"
            )

            model?.let {
                _mentoringData.value = it

                try {
                    val result = createMentoringOrderUseCase(it)
                    _mentoringData.value = result
                } catch (e: Exception) {
                    throw Exception(e.message)
                }
            }

            _isLoading.value = false
        }
    }

    fun setMentoringData(
        mentoringData: MentoringModel
    ) {
        _mentoringData.value = mentoringData
    }
}