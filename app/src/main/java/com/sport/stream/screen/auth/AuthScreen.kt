package com.sport.stream.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun AuthScreen(
    onSignIn: () -> Unit = {},
    onRegister: () -> Unit = {},
    onForgotPassword: () -> Unit = {},
    onFacebookLogin: () -> Unit = {},
    onGoogleLogin: () -> Unit = {}
) {
    // State
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A20))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.menu_frame), // Thay bằng ảnh nền của bạn
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .align(Alignment.TopCenter)
                .alpha(0.5f)
        )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Welcome to\nLiveScore.",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Enter your email address and password to use the application",
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Username
            Text(text = "Username", color = Color.LightGray, fontSize = 13.sp)
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Charlie Westervelt", color = Color.Gray) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColor(
                    containerColor = Color(0xFF23243A),
                    focusedBorderColor = Color(0xFF9C7FFF),
                    unfocusedBorderColor = Color(0xFF23243A),
                    textColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Password
            Text(text = "Password", color = Color.LightGray, fontSize = 13.sp)
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("**********", color = Color.Gray) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton (onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                if (passwordVisible) R.drawable.ic_menu_search
                                else R.drawable.ic_lock_power_off
                            ),
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFF23243A),
                    focusedBorderColor = Color(0xFF9C7FFF),
                    unfocusedBorderColor = Color(0xFF23243A),
                    textColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Remember Me & Forgot Password
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF9C7FFF),
                            uncheckedColor = Color.Gray
                        )
                    )
                    Text("Remember Me", color = Color.LightGray, fontSize = 13.sp)
                }
                Text(
                    text = "Forget Password?",
                    color = Color(0xFF9C7FFF),
                    fontSize = 13.sp,
                    modifier = Modifier.clickable(onClick = onForgotPassword)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sign In Button
            Button (
                onClick = onSignIn,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Đặt màu nền trong suốt để dùng Box bọc gradient
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("SIGN IN", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Or Login With",
                color = Color.LightGray,
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Social login buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onFacebookLogin,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.btn_plus),
                        contentDescription = "Facebook",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Facebook", color = Color.White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = onGoogleLogin,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF23243A)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "Google",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Google", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Don't have an account? ", color = Color.LightGray, fontSize = 13.sp)
                Text(
                    text = "Register Now",
                    color = Color(0xFF9C7FFF),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable(onClick = onRegister)
                )
            }
        }
    }
}