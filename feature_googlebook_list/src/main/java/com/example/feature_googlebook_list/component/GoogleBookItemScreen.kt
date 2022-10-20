package com.example.feature_googlebook_list.component

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.core_model.GoogleBookItem
import com.google.gson.Gson
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun GoogleBookItemScreen(
    item: GoogleBookItem,
    onItemClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp)
            .clickable {
                val toJson = Uri.encode(Gson().toJson(item))
                onItemClick(toJson)
            },
        horizontalArrangement = Arrangement.Start
    ) {
        CoilImage(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f),
            imageModel = item.imageLink,
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = Color.Black,
                durationMillis = 1000,
                dropOff = 0.65f,
                tilt = 20f
            ),
            contentScale = ContentScale.Crop,
            failure = {
                Text(text = "image request failed.")
            })
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .weight(6.5f)
                .padding(start = 12.dp, end = 4.dp)
        ) {
            Text(
                modifier = Modifier,
                text = item.title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = Bold
            )
        }
    }

}