package com.example.toygooglebook.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.core_ui.theme.ToyGoogleBookTheme

@Composable
fun GoogleBookApp() {

    ToyGoogleBookTheme {

        val navController = rememberNavController()


        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {



        }


    }
}