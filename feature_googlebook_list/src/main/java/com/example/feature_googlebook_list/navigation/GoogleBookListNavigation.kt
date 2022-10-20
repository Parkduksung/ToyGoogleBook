package com.example.feature_googlebook_list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.NavigationDestination
import com.example.feature_googlebook_list.GoogleBookListScreen

object GoogleBookListNavigation : NavigationDestination {
    override val route: String = "googlebook_list_route"
    override val destination: String = "googlebook_list_destination"
}


fun NavGraphBuilder.googleBookListGraph(
    navigationToGoogleBookDetail: (String) -> Unit
) {

    composable(route = GoogleBookListNavigation.route) {
        GoogleBookListScreen(
            navigationToGoogleBookDetail = navigationToGoogleBookDetail
        )
    }
}