package com.sport.stream.screen.home.compoment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.stream.screen.home.model.MatchInfo
import com.sport.stream.R
@Composable
fun SeeAllScreen(
    matches: List<MatchInfo>,
    onBack: () -> Unit,
    onMatchClick: (MatchInfo) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF181A20))) {
        // AppBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), // icon back
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable() { onBack() }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Tất cả trận đấu", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
        // Danh sách MatchCard
        if (matches.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(matches.size) { idx ->
                    MatchCard(
                        homeTeam = matches[idx].homeTeam,
                        homeLogoRes = matches[idx].homeLogoRes,
                        date = matches[idx].date,
                        time = matches[idx].time,
                        awayTeam = matches[idx].awayTeam,
                        awayLogoRes = matches[idx].awayLogoRes,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onMatchClick(matches[idx]) }
                    )
                }
            }
        } else {
            // Thông báo nếu không có trận đấu
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Không có trận đấu nào", color = Color.White)
            }
        }
    }
}