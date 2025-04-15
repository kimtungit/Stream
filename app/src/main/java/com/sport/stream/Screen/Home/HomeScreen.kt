package com.sport.stream

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sport.stream.ui.theme.TestAppTheme


@Composable
fun HomeScreen(navController: NavController){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        // Add a single item

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                HotMatchesScreen()
            }

        }

//        // Add 5 items
//        items(50) { index ->
//            Text(
//                text = "Item: $index",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable() {
//                        navController.navigate("detail/$index")
//                    }
//                    .padding(16.dp)
//            )
//        }
//
//        // Add another single item
//        item {
//            Text(text = "Last item")
//        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    TestAppTheme {
        HomeScreen(navController)
    }
}