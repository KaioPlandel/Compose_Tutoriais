package com.plandel.composetutoriais

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CombineModifier() {
    Text(
        text = "JetPack compose", modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Red)
            .padding(10.dp)
    )
}

//Modifiers will be executed in the order of what we provided
@Composable
fun DisplayMessage() {
    Text(
        text = "Hello world", modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.LightGray)
            .padding(10.dp)
            .background(Color.Blue)
    )
}

@Composable
fun SizeModifier() {
    Column(
        modifier =
        Modifier
            .size(200.dp)
            //.width(200.dp)
            //.height(200.dp)
            .background(Color.Blue)
    ) {
        Text(
            text = "Hello", modifier = Modifier
                // .size(100.dp, 100.dp)
                // .fillMaxSize() //vai usar todo o tamanho disponivel
                // .fillMaxSize(0.5f)   //os valores fracionais são de 0.5f a 1.0f -> significa a porcentagem do tamanho disponivel para utilizar
                // .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.Yellow)
        )
    }
}

@Composable
fun PaddingAllSide() {
    Text(text = "Jetpack Padding",
        Modifier
            .background(Color.DarkGray)
            .padding(30.dp, 10.dp, 30.dp, 10.dp))
}

@Composable
fun PaddingVerticalAndHorizontal() {
    Text(text = "Jetpack Padding", modifier = Modifier
        .background(Color.LightGray)
        .padding(30.dp, 10.dp))
}

@Composable
fun PaddingAll() {
    Text(text = "Jetpack Padding", modifier = Modifier
        .background(Color.Red)
        .padding(30.dp))
}

@Composable
fun AspectRadio() {
    Text(text = "JetPack Padding",
        Modifier
            .background(Color.Cyan)
            .aspectRatio(2f))
}

@Composable
fun ScaleAll() {
    Box(modifier = Modifier.size(200.dp)) {
        Text(text = "Compose Scale", Modifier
            .background(Color.DarkGray)
            .scale(2f)
        )
    }
}

@Composable
fun ScaleAxis() {
    Box(modifier = Modifier
        .size(200.dp)
        .background(Color.DarkGray)) {
        Text(text = "Compose Scale", Modifier
            .background(Color.Green)
            .scale(1f, 2f) // o texto sai da caixa e vc defini o tamanho vertical ou horizontal
        )
    }
}

@Composable
fun BackgroundWithShapeModifier() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Red,Color.Blue),
        startX = 65.0f,
        endX = 500.0f
    )
    Text(text = "Hello Jetpack Compose", Modifier
        .padding(20.dp)
        .background(gradientBrush, CutCornerShape(8.dp),1.0f)
        .padding(20.dp)
    )
}