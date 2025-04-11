package com.sport.stream

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sport.stream.ui.theme.TestAppTheme


@Composable
fun HomeScreen(){
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Scro
        LazyColumn {
            // Add a single item
            item {
                Text(text = "First item")
            }

            // Add 5 items
            items(50) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                Text(text = "Last item")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TestAppTheme {
        HomeScreen()
    }
}