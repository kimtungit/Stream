package com.sport.stream

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.stream.screen.player.HlsPlayer
import com.sport.stream.ui.theme.TestAppTheme

@Composable
fun LiveScreen() {
    // Danh sách link server
    val serverLinks = listOf(
        "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8",
        "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8",
        "https://moiptvhls-i.akamaihd.net/hls/live/652398/secure/master.m3u8",
    )
    var selectedServer by remember { mutableStateOf(0) }
    val currentUrl = serverLinks[selectedServer]

    // Thông tin trận đấu
    val club1 = "Brighton"
    val score = "2-1"
    val club2 = "Arsenal"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg_2), // Thay bằng ảnh nền của bạn
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.5f)
        )
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {

//            // 1. HlsPlayer ở trên cùng
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            ) {
                HlsPlayer(url = currentUrl, modifier = Modifier.fillMaxSize())
            }
            Spacer(Modifier.height(8.dp))

//            //            // 2. Danh sách chọn server
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in serverLinks.indices) {
                    Button(onClick = { selectedServer = i }, enabled = selectedServer != i) {
                        Text("Server ${i + 1}")
                    }
                }
            }
            Spacer(Modifier.height(8.dp))

            // 3. Final Score & Match Info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.manchester_united
                            ), contentDescription = "Watch", modifier = Modifier.size(100.dp)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "2",
                            color = androidx.compose.ui.graphics.Color.White,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Text("-", color = androidx.compose.ui.graphics.Color.White)
                        Text(
                            "2",
                            color = androidx.compose.ui.graphics.Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Thay thế bằng Image nếu có logo đội
                        Image(
                            painter = painterResource(
                                id = R.drawable.chelsea_fc
                            ), // Biểu tượng play
                            contentDescription = "Watch", modifier = Modifier.size(100.dp)
                        )
                    }
                }
                Spacer(Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "De Jong 66'\nDepay 79'",
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 12.sp
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "Alvarez 21'\nPalmer 70'",
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
            Spacer(Modifier.height(16.dp))

            // 4. Statistic Match
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Statistic Match", color = androidx.compose.ui.graphics.Color.White)
                Spacer(Modifier.height(8.dp))
                val statsLeft = listOf("11", "7", "48%", "500", "89%", "7", "0", "0", "1", "3")
                val statsCenter = listOf(
                    "Shoot",
                    "Shoot on Target",
                    "Ball Possession",
                    "Pass",
                    "Pass Accuracy",
                    "Foul",
                    "Yellow Card",
                    "Red Card",
                    "Offside",
                    "Corner Kick"
                )
                val statsRight = listOf("16", "8", "52%", "532", "90%", "13", "1", "0", "5", "2")
                for (i in statsLeft.indices) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            statsLeft[i],
                            color = androidx.compose.ui.graphics.Color.White,
                            modifier = Modifier.weight(1f),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Text(
                            statsCenter[i],
                            color = androidx.compose.ui.graphics.Color.Gray,
                            modifier = Modifier.weight(2f),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Text(
                            statsRight[i],
                            color = androidx.compose.ui.graphics.Color.White,
                            modifier = Modifier.weight(1f),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                    Spacer(Modifier.height(2.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LivePreview() {
    TestAppTheme { LiveScreen() }
}
