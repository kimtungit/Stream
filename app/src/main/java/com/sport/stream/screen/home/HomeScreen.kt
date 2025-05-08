package com.sport.stream

import android.R
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sport.stream.screen.home.compoment.MatchSection
import com.sport.stream.screen.home.compoment.ScoreBox
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sport.stream.screen.home.model.HomeViewModel
import com.sport.stream.ui.theme.TestAppTheme
import com.sport.stream.screen.home.model.MatchInfo

@Composable
fun HomeScreen(
    navController: NavController,
    model : HomeViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_sort_by_size),
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
                painter = painterResource(id = R.drawable.ic_menu_search),
                contentDescription = "Search",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Score Box - Horizontal scrollable cards
        ScoreBox(scores = model.scores)
        Spacer(modifier = Modifier.height(24.dp))

        // Hotmatches
        MatchSection(
            title = "Hot Matches",
            matches = model.hotMatches,
            maxItem = 3,
            onMatchClick = { match ->
                println("Clicked match: ${match.homeTeam} vs ${match.awayTeam}")
                // TODO: Xử lý event ở đây, ví dụ chuyển màn, show dialog, ...
                navController.navigate(Screen.Live.rout)
            },
            onSeeAllClick = {
                println("See all Hot Matches clicked")
                // TODO: Xử lý sự kiện khi nhấn "See All"
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // All Matches
        MatchSection(
            title = "All Matches",
            matches = model.allMatches,
            maxItem = 5,
            onMatchClick = { match ->
                println("Clicked match: ${match.homeTeam} vs ${match.awayTeam}")
                navController.navigate(Screen.Live.rout)
            },
            onSeeAllClick = {
                println("See all All Matches clicked")
                // TODO: Xử lý sự kiện khi nhấn "See All"
            }
        )

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
                .background(Color(0xFF23243A), shape = RoundedCornerShape(12.dp))
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
                painter = painterResource(id = R.drawable.btn_star_big_off),
                contentDescription = "Bookmark",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    val homeModel: HomeViewModel = viewModel()
    TestAppTheme {
        HomeScreen(navController, model = homeModel)
    }
}

