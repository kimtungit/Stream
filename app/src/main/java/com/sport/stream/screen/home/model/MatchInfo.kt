package com.sport.stream.screen.home.model

// Data model for a match
data class MatchInfo(
    val homeTeam: String,
    val homeLogoRes: Int,
    val date: String,
    val time: String,
    val awayTeam: String,
    val awayLogoRes: Int
)