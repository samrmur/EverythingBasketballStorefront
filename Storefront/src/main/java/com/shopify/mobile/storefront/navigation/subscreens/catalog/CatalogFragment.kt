package com.shopify.mobile.storefront.navigation.subscreens.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import com.shopify.mobile.storefront.R
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
import toothpick.smoothie.viewmodel.closeOnViewModelCleared
import toothpick.smoothie.viewmodel.installViewModelBinding

class CatalogFragment : Fragment() {
    private val catalogViewModel: CatalogViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KTP.openRootScope()
            .openSubScope(CatalogViewModel::class.java) { scope ->
                scope.installViewModelBinding<CatalogViewModel>(fragment = this, factory = SavedStateViewModelFactory(requireActivity().application, this))
                    .closeOnViewModelCleared(fragment = this)
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