package com.sport.stream

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.stream.Datasource.MatchObject
import com.sport.stream.ui.theme.TestAppTheme

@Composable
fun MatchItemView(match: MatchObject) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2A2A2A))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thời gian và ngày
        Column {
            Text(
                text = match.time,
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(
                text = match.date,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Logo và tên đội 1
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = match.team1Logo),
                contentDescription = "${match.team1Name} Logo",
                modifier = Modifier.size(40.dp),
            )
            Text(
                text = match.team1Name,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.width(80.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        // Tỷ số
        Text(
            text = match.score,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Logo và tên đội 2
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = match.team2Logo),
                contentDescription = "${match.team2Name} Logo",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = match.team2Name,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.width(80.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Nút Watch
        Button(
            onClick = { /* Xử lý nút Watch */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B1E3F)),
            modifier = Modifier.size(48.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_play), // Biểu tượng play
                contentDescription = "Watch",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchItemPreview() {
    val objet = MatchObject("02:00", "Apr 16", "Borussia Dortmund", R.drawable.ic_football, "Barcelona", R.drawable.ic_football, "0 - 0")
    TestAppTheme {
        MatchItemView(objet)
    }
}