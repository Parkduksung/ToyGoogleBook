package com.example.feature_googlebook_detail.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.core_model.GoogleBookItem
import com.example.core_navigation.NavigationDestination
import com.example.feature_googlebook_detail.GoogleBookDetailScreen
import com.google.gson.Gson


object GoogleBookDetailDestination : NavigationDestination {
    override val route = "googlebook_detail_route"
    override val destination = "googlebook_detail_destination"
    const val googleBookArg = "googlebookArg"
}

fun NavGraphBuilder.googleBookDetailGraph() {
    composable(
        route = "${GoogleBookDetailDestination.route}/{${GoogleBookDetailDestination.googleBookArg}}",
        arguments = listOf(
            navArgument(GoogleBookDetailDestination.googleBookArg) {
                type = AssetParamType()
            }
        )
    ) {
        GoogleBookDetailScreen()
    }
}


class AssetParamType : NavType<GoogleBookItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): GoogleBookItem? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): GoogleBookItem {
        return Gson().fromJson(value, GoogleBookItem::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: GoogleBookItem) {
        bundle.putParcelable(key, value)
    }
}
