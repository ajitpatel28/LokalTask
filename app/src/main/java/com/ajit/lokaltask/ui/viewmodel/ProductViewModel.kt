package com.ajit.lokaltask.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajit.lokaltask.data.model.Product
import com.ajit.lokaltask.data.repository.ProductRepository
import com.ajit.lokaltask.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    private val _productListState = mutableStateOf<UiState<List<Product>>>(UiState.Loading())
    val productListState: MutableState<UiState<List<Product>>> = _productListState

    private val _selectedProduct = mutableStateOf<Product?>(null)
    val selectedProduct: State<Product?> = _selectedProduct


    init {
        fetchProducts()
    }

    fun setSelectedProduct(product: Product?) {
        _selectedProduct.value = product
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = repository.getProducts()
                _productListState.value = UiState.Success(response)
            } catch (e: Exception) {
                _productListState.value = UiState.Error("Error fetching products", emptyList())
            }
        }
    }
}