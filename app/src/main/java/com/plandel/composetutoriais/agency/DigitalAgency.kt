package com.plandel.composetutoriais.agency

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plandel.composetutoriais.R

@Composable
fun Menu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(18, 18, 23))
    ) {
        TopLayout(name = "Plandel Service")
        ListOfCards(
            listOf(
                Job("Android Developed", color = Color.Blue),
                Job("Android Developed", color = Color.White),
                Job("Android Developed", color = Color.LightGray),
                Job("Android Developed", color = Color.Magenta),
            )
        )
        Spacer(modifier = Modifier.padding(20.dp))
        BottomLayout()
    }
}

@Composable
fun TopLayout(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoundedImage(image = painterResource(id = R.drawable.philipp), modifier.size(80.dp))
            Spacer(modifier = modifier.padding(8.dp))
            Column {
                Text(
                    text = "Welcome back",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )
                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            tint = Color.White,
            modifier = modifier
                .padding(end = 6.dp)
                .size(35.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .padding(10.dp)
        )
    }
}


@Composable
fun RoundedImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ListOfCards(
    list: List<Job>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        ButtonNewJob(title = "Add New", modifier = modifier.align(Alignment.End))
        Spacer(modifier = modifier.height(15.dp))
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 30.dp)
        ) {
            items(list.size) {
                Box(
                    modifier
                        .size(127.dp, 160.dp)
                        .border(3.dp, color = Color.White, RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = list[it].color)

                ) {
                    Text(
                        text = list[it].title,
                        modifier
                            .align(Alignment.Center)
                            .padding(bottom = 18.dp, start = 6.dp)
                    )
                }
                Spacer(modifier = modifier.width(20.dp))
            }
        }
    }
}

@Composable
fun ButtonNewJob(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(15.dp, 6.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black)
        Spacer(modifier = modifier.width(4.dp))
        Text(text = title, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BottomLayout(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(3f)
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(modifier = modifier.padding(start = 10.dp, top = 6.dp)) {
                Text(text = "Your jobs", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Spacer(modifier = modifier.height(6.dp))
                Text(text = "(5/8) Completed", fontSize = 14.sp, color = Color.Gray)
            }
        
        }
    }
}