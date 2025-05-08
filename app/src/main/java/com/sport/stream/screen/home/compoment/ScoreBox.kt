package com.sport.stream.screen.home.compoment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sport.stream.screen.home.compoment.ScoreCard

// Data model cho Score
 data class ScoreInfo(
    val homeTeam: String,
    val homeLogoRes: Int,
    val awayTeam: String,
    val awayLogoRes: Int,
    val score: String,
    val time: String,
    val homeScorers: List<String>,
    val awayScorers: List<String>
)

@Composable
fun ScoreBox(scores: List<ScoreInfo>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(scores.size) { index ->
            val score = scores[index]
            ScoreCard(
                homeTeam = score.homeTeam,
                homeLogoRes = score.homeLogoRes,
                awayTeam = score.awayTeam,
                awayLogoRes = score.awayLogoRes,
                score = score.score,
                time = score.time,
                homeScorers = score.homeScorers,
                awayScorers = score.awayScorers
            )
        }
    }
}
