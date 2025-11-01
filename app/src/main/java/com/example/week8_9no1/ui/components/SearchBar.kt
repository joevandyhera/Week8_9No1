package com.example.week8_9no1.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    val containerOpacity = 0.3f
    val cornerShape = RoundedCornerShape(12.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = "Enter city name...",
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White.copy(0.8f),
                    contentDescription = null
                )
            },
            textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
            shape = cornerShape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White.copy(containerOpacity),
                unfocusedContainerColor = Color.White.copy(containerOpacity),
                disabledContainerColor = Color.White.copy(containerOpacity),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedPlaceholderColor = Color.White.copy(0.7f),
                unfocusedPlaceholderColor = Color.White.copy(0.7f),
                cursorColor = Color.White
            ),
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
        )

        Button(
            onClick = { onSearch(query) },
            enabled = query.isNotBlank(),
            shape = cornerShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(containerOpacity),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.4f),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.White.copy(0.8f)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Search",
                fontSize = 16.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    var previewQuery by remember { mutableStateOf("Jember") }

    Surface(color = Color(0xFF334466)) {
        SearchBar(
            query = previewQuery,
            onQueryChange = { previewQuery = it },
            onSearch = { println("Searching: $it") }
        )
    }
}