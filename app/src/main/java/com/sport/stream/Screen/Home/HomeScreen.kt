package com.sport.stream

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sport.stream.ui.theme.TestAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
            .padding(16.dp)
    ) {
        // Header
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_sort_by_size),
                contentDescription = "Menu",
                tint = Color.White
            )
            Text(
                text = "Beesport",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_search),
                contentDescription = "Search",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Score Box - Horizontal scrollable cards
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(3) { index ->
                ScoreCard(
                    homeTeam = "Barcelona",
                    homeLogoRes = R.drawable.everton_fc,
                    awayTeam = "Man City",
                    awayLogoRes = R.drawable.manchester_city,
                    score = "2 - 2",
                    time = "60 : 22",
                    homeScorers = listOf("De Jong 66'", "Depay 79'"),
                    awayScorers = listOf("Alvarez 21'", "Palmer 70'")
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Match Schedule
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Match Schedule", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("See All", color = Color(0xFF9C7FFF), fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            MatchCard(
                homeTeam = "Chelsea",
                homeLogoRes = R.drawable.chelsea_fc,
                date = "27 Aug 2022",
                time = "01.40",
                awayTeam = "Leicester",
                awayLogoRes = R.drawable.leicester_city
            )
            Spacer(modifier = Modifier.height(8.dp))
            MatchCard(
                homeTeam = "Chelsea",
                homeLogoRes = R.drawable.chelsea_fc,
                date = "27 Aug 2022",
                time = "01.40",
                awayTeam = "Leicester",
                awayLogoRes = R.drawable.leicester_city
            )
            Spacer(modifier = Modifier.height(8.dp))
            MatchCard(
                homeTeam = "Chelsea",
                homeLogoRes = R.drawable.chelsea_fc,
                date = "27 Aug 2022",
                time = "01.40",
                awayTeam = "Leicester",
                awayLogoRes = R.drawable.leicester_city
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Football News
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Football News", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("See All", color = Color(0xFF9C7FFF), fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF23243A), shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for news image
            Box(
                modifier = Modifier.size(48.dp).background(Color.Gray, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Champions League 2022–23 draw: group stage analysis and predictions",
                    color = Color.White,
                    fontSize = 13.sp,
                    maxLines = 2
                )
            }
            Icon(
                painter = painterResource(id = android.R.drawable.btn_star_big_off),
                contentDescription = "Bookmark",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MatchCard(
    homeTeam: String,
    homeLogoRes: Int,
    date: String,
    time: String,
    awayTeam: String,
    awayLogoRes: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF23243A), shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Home team (tên + logo)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(homeTeam, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = homeLogoRes),
                contentDescription = "Logo $homeTeam",
                modifier = Modifier.size(42.dp)
            )
        }

        // Thời gian ở giữa
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(date, color = Color.LightGray, fontSize = 11.sp)
            Text(time, color = Color.LightGray, fontSize = 11.sp)
        }

        // Away team (tên + logo)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(awayTeam, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = awayLogoRes),
                contentDescription = "Logo $awayTeam",
                modifier = Modifier.size(42.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    TestAppTheme {
        HomeScreen(navController)
    }
}

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