package com.example.toygooglebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.feature_googlebook_detail.navigation.GoogleBookDetailDestination
import com.example.feature_googlebook_detail.navigation.googleBookDetailGraph
import com.example.feature_googlebook_list.navigation.GoogleBookListNavigation
import com.example.feature_googlebook_list.navigation.googleBookListGraph


@Composable
fun GoogleBookNavigation(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = GoogleBookListNavigation.route
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        googleBookListGraph(
            navigationToGoogleBookDetail = { navHostController.navigate(route = "${GoogleBookDetailDestination.route}/$it") }
        )

        googleBookDetailGraph()
    }
}