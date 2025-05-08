package com.sport.stream.screen.home.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreCard(
    homeTeam: String,
    homeLogoRes: Int,
    awayTeam: String,
    awayLogoRes: Int,
    score: String,
    time: String,
    homeScorers: List<String>,
    awayScorers: List<String>
) {
    Box(
        modifier = Modifier
            .width(220.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF6B6FFF), Color(0xFF8F6FFF)),
                    start = Offset(0f, 0f),
                    end = Offset(220f, 120f)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(time, color = Color.White, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = homeLogoRes),
                        contentDescription = "Logo $homeTeam",
                        modifier = Modifier.size(36.dp)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(score, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = awayLogoRes),
                        contentDescription = "Logo $awayTeam",
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    homeScorers.forEach {
                        Text(it, color = Color.White, fontSize = 10.sp)
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    awayScorers.forEach {
                        Text(it, color = Color.White, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}