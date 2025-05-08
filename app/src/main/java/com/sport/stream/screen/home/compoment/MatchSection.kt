package com.sport.stream.screen.home.compoment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontWeight
import com.sport.stream.screen.home.model.MatchInfo


@Composable
fun MatchSection(
    title: String,
    matches: List<MatchInfo>,
    maxItem : Int,
    modifier: Modifier = Modifier,
    onMatchClick: (MatchInfo) -> Unit = {},
    onSeeAllClick: () -> Unit = {}

) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            // nếu như item nhỏ hơn hoặc bằng max thì không cho hiện seeall nữa
            if (matches.size > maxItem) {
                Text("See All", color = Color(0xFF9C7FFF), fontSize = 14.sp,
                    modifier = Modifier.clickable(
                        onClick = onSeeAllClick
                    ))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            // giới hạn độ dài mảng
            matches.take(maxItem).forEachIndexed { idx, match ->
                MatchCard(
                    homeTeam = match.homeTeam,
                    homeLogoRes = match.homeLogoRes,
                    date = match.date,
                    time = match.time,
                    awayTeam = match.awayTeam,
                    awayLogoRes = match.awayLogoRes,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable() {
                            onMatchClick(match)
                        }
                )
                if (idx != matches.lastIndex) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
