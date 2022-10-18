package com.example.toygooglebook.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.feature_googlebook_list.navigation.GoogleBookListNavigation
import com.example.feature_googlebook_list.navigation.googleBookListGraph


@Composable
fun GoogleBookNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = GoogleBookListNavigation.route
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        googleBookListGraph()
    }
}