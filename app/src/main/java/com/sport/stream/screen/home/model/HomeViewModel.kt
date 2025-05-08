package com.sport.stream.screen.home.model

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.sport.stream.R
import com.sport.stream.screen.home.compoment.ScoreInfo

class HomeViewModel : ViewModel() {
    // Quản lý danh sách tỉ số (scores)
    val scores: SnapshotStateList<ScoreInfo> = mutableStateListOf(
        ScoreInfo(
            homeTeam = "Barcelona",
            homeLogoRes = R.drawable.everton_fc,
            awayTeam = "Man City",
            awayLogoRes = R.drawable.manchester_city,
            score = "2 - 2",
            time = "60 : 22",
            homeScorers = listOf("De Jong 66'", "Depay 79'"),
            awayScorers = listOf("Alvarez 21'", "Palmer 70'")
        ),
        ScoreInfo(
            homeTeam = "Barcelona",
            homeLogoRes = R.drawable.everton_fc,
            awayTeam = "Man City",
            awayLogoRes = R.drawable.manchester_city,
            score = "2 - 2",
            time = "60 : 22",
            homeScorers = listOf("De Jong 66'", "Depay 79'"),
            awayScorers = listOf("Alvarez 21'", "Palmer 70'")
        ),
        ScoreInfo(
            homeTeam = "Barcelona",
            homeLogoRes = R.drawable.everton_fc,
            awayTeam = "Man City",
            awayLogoRes = R.drawable.manchester_city,
            score = "2 - 2",
            time = "60 : 22",
            homeScorers = listOf("De Jong 66'", "Depay 79'"),
            awayScorers = listOf("Alvarez 21'", "Palmer 70'")
        )
    )
    // Quản lý danh sách trận đấu (matches)
    val hotMatches: SnapshotStateList<MatchInfo> = mutableStateListOf<MatchInfo>().apply {
        repeat(10) { index ->
            add(
                MatchInfo(
                    homeTeam = "Chelsea $index",
                    homeLogoRes = R.drawable.chelsea_fc,
                    date = "27 Aug 2022",
                    time = "01:40",
                    awayTeam = "Leicester $index",
                    awayLogoRes = R.drawable.leicester_city
                )
            )
        }
    }

    val allMatches: SnapshotStateList<MatchInfo> = mutableStateListOf<MatchInfo>().apply {
        repeat(50) { index ->
            add(
                MatchInfo(
                    homeTeam = "Chelsea $index",
                    homeLogoRes = R.drawable.chelsea_fc,
                    date = "27 Aug 2022",
                    time = "01:40",
                    awayTeam = "Leicester $index",
                    awayLogoRes = R.drawable.leicester_city
                )
            )
        }
    }
}
