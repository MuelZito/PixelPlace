package com.example.pixelplace

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraDePesquisa(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholder: String = "",
    onQueryChange: (String) -> Unit
) {
        val CustomSearchBarColors = TextFieldDefaults.colors(

        )
    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = {
            onQueryChange(it)
        },
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = {
            Text(
                text = "",
                color = Color.White,


            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },

        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                modifier = Modifier.clickable { onQueryChange("") },
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(8.dp),
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFF171B1F),

            inputFieldColors = TextFieldDefaults.colors(Color.White)

            )



    ) {}
}



@Preview(showBackground = true)
@Composable
fun BarraDePesquisaPreview() {
    var query by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BarraDePesquisa(
            query = query,
            onQueryChange = { query = it },
            placeholder = "Pesquisar Jogo"
        )
    }
}