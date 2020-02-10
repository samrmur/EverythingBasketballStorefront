package com.shopify.mobile.basketball.storefront.product

import androidx.lifecycle.*
import com.shopify.mobile.basketball.storefront.domain.cases.GetSingleProductUseCase
import com.shopify.mobile.basketball.storefront.ui.ScreenState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val arguments: ProductArguments,
    private val savedStateHandle: SavedStateHandle,
    private val getSingleProductUseCase: GetSingleProductUseCase
): ViewModel() {

    private val _screenState = MutableLiveData<ScreenState<ProductViewState, ProductToolbarState>>()
    val screenState: LiveData<ScreenState<ProductViewState, ProductToolbarState>>
        get() = _screenState

    init {
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch {
            getSingleProductUseCase.execute(arguments.id).collect {
            }
        }
    }
}