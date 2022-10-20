package com.example.feature_googlebook_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun GoogleBookDetailScreen(
    viewModel: GoogleBookDetailViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.value

    Box(Modifier.fillMaxSize()) {

        when (val result = uiState.googleBookItemUiState) {

            is GoogleBookItemUiState.GetItem -> {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                ) {

                    CoilImage(
                        modifier = Modifier
                            .height(250.dp)
                            .width(250.dp)
                            .align(CenterHorizontally)
                            .padding(20.dp),
                        imageModel = result.item.imageLink,
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

                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = result.item.title,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = result.item.description,
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = 10,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            GoogleBookItemUiState.Error -> {
                Text(
                    modifier = Modifier.align(Center),
                    text = "데이터를 가져오는데 실패하였습니다.",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}