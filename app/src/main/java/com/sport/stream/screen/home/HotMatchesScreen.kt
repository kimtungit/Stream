package com.sport.stream

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.stream.datasource.MatchObject
import com.sport.stream.ui.theme.TestAppTheme

@Composable
fun HotMatchesScreen() {
    // Dữ liệu giả lập
    val matches = listOf(
        MatchObject("02:00", "Apr 16", "Borussia Dortmund", R.drawable.ic_football, "Barcelona", R.drawable.ic_football, "0 - 0"),
        MatchObject("02:00", "Apr 16", "Aston Villa", R.drawable.ic_football, "Paris Saint Germain", R.drawable.ic_football, "0 - 0"),
        MatchObject("02:00", "Apr 17", "Real Madrid", R.drawable.ic_football, "Arsenal", R.drawable.ic_football, "0 - 0"),
        MatchObject("02:00", "Apr 17", "Inter", R.drawable.ic_football, "Bayern Munich", R.drawable.ic_football, "0 - 0"),
        MatchObject("02:00", "Apr 18", "Chelsea", R.drawable.ic_football, "Legia Warszawa", R.drawable.ic_football, "0 - 0")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        // Tiêu đề "Hot Matches"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_play), // Biểu tượng lửa
                    contentDescription = "Fire Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "HOT MATCHES",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            TextButton(onClick = { /* Xử lý View All */ }) {
                Text("VIEW ALL", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Danh sách trận đấu
        matches.forEach { match ->
            MatchItemView(match)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HotMatchesPreview() {
    TestAppTheme {
        HotMatchesScreen()
    }
}