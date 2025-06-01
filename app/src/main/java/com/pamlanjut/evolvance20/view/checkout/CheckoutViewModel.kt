package com.pamlanjut.evolvance20.view.checkout

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.domain.model.PaymentDetail
import com.pamlanjut.evolvance20.domain.usecase.bootcamp.GetBootcampDataDetailUseCase
import com.pamlanjut.evolvance20.domain.usecase.checkout.CreateOrderBootcampUseCase
import com.pamlanjut.evolvance20.utils.helper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val getBootcampDetail: GetBootcampDataDetailUseCase,
    private val createBootcampOrder: CreateOrderBootcampUseCase
) : ViewModel() {
    private val _paymentDetail = MutableStateFlow<PaymentDetail?>(null)
    val paymentDetail: StateFlow<PaymentDetail?> = _paymentDetail
    fun paymentData(id: Int) {
        viewModelScope.launch {
            getBootcampDetail(id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        val data = result.data
                        _paymentDetail.value = PaymentDetail(
                            id = data.id,
                            name = data.name,
                            price = data.price,
                            paymentMethod = null,
                            paymentDate = null,
                            paymentReference = null
                        )
                    }

                    is Resource.Error -> {
                        println("Error Fetching Data: Checkout ViewModel ${result.message}")
                    }

                    Resource.Idle -> {
                        println("Idle Fetching Data: Checkout ViewModel")
                    }

                    Resource.Loading -> {
                        println("Loading Fetching Data: Checkout ViewModel")
                    }
                }
            }
        }
    }

    fun selectPaymentMethod(method: String) {
        _paymentDetail.value = _paymentDetail.value?.copy(paymentMethod = method)
    }

    // Detail Checkout
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    @RequiresApi(Build.VERSION_CODES.O)
    fun updatePayment() {
        val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
        viewModelScope.launch {
            _isLoading.value = true
            delay(3000)
            updatePaymentStatus()
            _paymentDetail.value = _paymentDetail.value?.copy(
                paymentReference = (1000000000..9999999999).random(),
                paymentDate = date
            )
            _isLoading.value = false
        }
    }

    private fun updatePaymentStatus() {
        viewModelScope.launch {
            createBootcampOrder(
                id = _paymentDetail.value?.id ?: 0
            ).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        println("Success: Checkout Detail ViewModel")
                    }

                    is Resource.Error -> {
                        println("Error Fetching Data: Checkout Detail ViewModel ${result.message}")
                    }

                    Resource.Idle -> {
                        println("Idle Fetching Data: Checkout Detail ViewModel")
                    }

                    Resource.Loading -> {
                        println("Loading Fetching Data: Checkout Detail ViewModel")
                    }
                }
            }
        }
    }
}
