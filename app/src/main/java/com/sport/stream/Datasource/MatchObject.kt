package com.sport.stream.Datasource

data class MatchObject(
    val time: String,
    val date: String,
    val team1Name: String,
    val team1Logo: Int, // Resource ID cho logo
    val team2Name: String,
    val team2Logo: Int,
    val score: String
)