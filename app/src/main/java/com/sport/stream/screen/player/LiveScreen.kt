package com.sport.stream

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import com.sport.stream.screen.player.HlsPlayer


@Composable
fun LiveScreen() {
    // Danh sách link server
    val serverLinks = listOf(
        "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8", // Server 2
        "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8", // Server 1
        "https://moiptvhls-i.akamaihd.net/hls/live/652398/secure/master.m3u8", // Server 3
        "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8" // Server 4
    )
    var selectedServer by remember { mutableStateOf(0) }
    val currentUrl = serverLinks[selectedServer]

    // Thông tin trận đấu
    val club1 = "Brighton"
    val score = "2-1"
    val club2 = "Arsenal"

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Player trên cùng, tỉ lệ 16:9
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            HlsPlayer(url = currentUrl, modifier = Modifier.fillMaxSize())
        }
        Spacer(Modifier.height(16.dp))

        // Danh sách chọn server
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in serverLinks.indices) {
                Button(
                    onClick = { selectedServer = i },
                    enabled = selectedServer != i
                ) {
                    Text("Server ${i + 1}")
                }
            }
        }
        Spacer(Modifier.height(20.dp))

        // Tên CLB - tỉ số - Tên CLB 2
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = club1)
            Spacer(Modifier.width(8.dp))
            Text(text = score)
            Spacer(Modifier.width(8.dp))
            Text(text = club2)
        }
    }
}