package com.sport.stream.screen.home.model

import androidx.lifecycle.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AuthModel : ViewModel() {
    // Biến trạng thái đăng nhập, mặc định là false
    var isLoggedIn by mutableStateOf(false)

}