package com.shopify.mobile.basketball.storefront.navigation.subscreens.orders

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

class OrdersFragment : Fragment() {
    private val viewModel: OrdersViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
         * Scope Tree
         * Root Scope (App Scope) -> Activity Scope -> View Model Scope -> View Scope
         *
         * We would need the view model and view scope to be separate to ensure that closing one
         * scope in onDestroy does not kill the view model as well while still being able to define
         * dependencies at the view scope that can be destroyed.
         */
        KTP.openRootScope()
            .openSubScope(requireActivity())
            .openSubScope(OrdersViewModel::class.java) { scope ->
                scope.installArguments(OrdersArguments(id = "TestId"))
                scope.installViewModelBinding<OrdersViewModel>(
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