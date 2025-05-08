package com.sport.stream

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sport.stream.screen.auth.AuthScreen
import com.sport.stream.screen.home.model.AuthModel
import com.sport.stream.ui.theme.TestAppTheme



@Composable
fun ProfileScreen(
    userName: String = "Nguyen Van A",
    email: String = "nguyenvana@email.com",
    memberStatus: String = "Trial", // hoặc "Premium"
    appVersion: String = "1.0.0",
    onPurchaseHistory: () -> Unit = {},
    onChangePassword: () -> Unit = {},
    onNotificationSettings: () -> Unit = {},
    model : AuthModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(48.dp))
                    .background(Color(0xFF23242B)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile), // Thay bằng avatar thật nếu có
                    contentDescription = "Avatar",
                    modifier = Modifier.size(72.dp),
                    tint = Color(0xFF9C7FFF)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Tên hoặc email
            Text(
                text = userName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = email,
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Member status
            Box(
                modifier = Modifier
                    .background(
                        color = if (memberStatus == "Premium") Color(0xFF9C7FFF) else Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = if (memberStatus == "Premium") "Premium Member" else "Trial Member",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Các mục chức năng
            ProfileMenuItem(
                icon = R.drawable.ic_history,
                title = "Purchase History",
                onClick = onPurchaseHistory
            )
            ProfileMenuItem(
                icon = R.drawable.ic_password,
                title = "Change password",
                onClick = onChangePassword
            )
            ProfileMenuItem(
                icon = R.drawable.ic_notify,
                title = "Notification settings",
                onClick = onNotificationSettings
            )
            ProfileMenuItem(
                icon = R.drawable.ic_support,
                title = "Contact",
                onClick = onNotificationSettings
            )

            Spacer(modifier = Modifier.height(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF4568DC), Color(0xFFF65A1E))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Button(
                    onClick = { model.isLoggedIn = false
                    },
                    modifier = Modifier
                        .fillMaxSize(), // chiếm toàn bộ Box
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues() // tránh padding thừa để gradient đẹp
                ) {
                    Text("Logout", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: Int,
    title: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (enabled) Color(0xFF23242B) else Color.Transparent)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF9C7FFF),
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(18.dp))
        Text(
            text = title,
            color = if (enabled) Color.White else Color.LightGray,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        if (enabled) {
            Icon(
                painter = painterResource(id = R.drawable.ic_right),
                contentDescription = null,
                tint = Color(0xFF9C7FFF),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
//    val navController = rememberNavController()
    val authModel: AuthModel = viewModel()
    TestAppTheme {
        ProfileScreen(model = authModel)
    }
}
