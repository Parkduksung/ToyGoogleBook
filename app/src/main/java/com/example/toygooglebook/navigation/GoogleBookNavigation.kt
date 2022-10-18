package com.example.toygooglebook.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun GoogleBookNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = ""
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier,
    ) {

    }
}