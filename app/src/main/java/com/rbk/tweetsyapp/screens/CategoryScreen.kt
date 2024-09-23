package com.rbk.tweetsyapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rbk.tweetsyapp.viewmodels.CategoryViewModel
import com.rbk.tweetsyappdi.R



@Composable
fun CategoryScreen(onClick:(category:String)->Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(20.dp),
    ) {
        items(categories.value) {
            CategoryItem(category = it,onClick)
        }
    }
}

@Composable
fun CategoryItem(category: String,onClick:(category:String)->Unit) {
    Box(
      /*  modifier = Modifier
            .padding(4.dp)
            .clickable { onClick(category) }
            .size(160.dp)
            .background(
                color = colorResource(id = R.color.purple_200),
                shape = RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .paint(painter = painterResource(id = R.drawable.wave_haikei), contentScale = ContentScale.Crop)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter*/

        modifier = Modifier
            .padding(8.dp)  // Outer padding from the grid item (applied to whole box)
            .clickable { onClick(category) }
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = colorResource(id = R.color.purple_200),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            )
            .paint(
                painter = painterResource(id = R.drawable.wave_haikei),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }

}


@Composable
fun CategoryItemDemo() {
    Box(
        modifier = Modifier
            .padding(8.dp)  // Outer padding from the grid item (applied to whole box)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = colorResource(id = R.color.purple_200),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            )
            .paint(
                painter = painterResource(id = R.drawable.wave_haikei),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Text content aligned at the bottom center
        Text(
            text = "category",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp),  // Padding for the text only
            style = MaterialTheme.typography.bodyMedium
        )
    }


}