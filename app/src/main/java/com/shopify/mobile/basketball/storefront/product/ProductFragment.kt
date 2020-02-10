package com.shopify.mobile.basketball.storefront.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import com.shopify.mobile.basketball.storefront.R
import com.shopify.mobile.basketball.storefront.util.installArguments
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
import toothpick.smoothie.viewmodel.closeOnViewModelCleared
import toothpick.smoothie.viewmodel.installViewModelBinding

class ProductFragment : Fragment() {
    private val viewModel: ProductViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KTP.openRootScope()
            .openSubScope(ProductViewModel::class.java) { scope ->
                scope.installArguments(ProductArguments(id = ""))
                scope.installViewModelBinding<ProductViewModel>(
                    fragment = this,
                    factory = SavedStateViewModelFactory(requireActivity().application, this)
                ).closeOnViewModelCleared(fragment = this)
            }
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content, container, false) as ViewGroup
    }
}