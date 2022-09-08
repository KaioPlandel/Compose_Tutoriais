package com.plandel.composetutoriais

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun Constraint() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val (textTopStart, textTopCenter, textTopEnd, textCenterStart, textCenter, textCenterEnd, textBottomStart, textBottomCenter, textBottomEnd) = createRefs()
        Text(text = "Text Top Start", Modifier.constrainAs(textTopStart) {
            start.linkTo(parent.start, 8.dp)
            top.linkTo(parent.top, 8.dp)
        })
        Text(text = "Text Top Center", Modifier.constrainAs(textTopCenter) {
            start.linkTo(parent.start, 8.dp)
            top.linkTo(parent.top, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
        Text(text = "Text Top End", modifier = Modifier.constrainAs(textTopEnd) {
            top.linkTo(parent.top, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
        Text(text = "Text Center Start", modifier = Modifier.constrainAs(textCenterStart) {
            top.linkTo(textTopStart.bottom, 12.dp)
            start.linkTo(parent.start, 8.dp)
        })
        Text(text = "Text Center", modifier = Modifier.constrainAs(textCenter) {
            top.linkTo(textTopCenter.bottom, 12.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
        Text(text = "Text Center End", modifier = Modifier.constrainAs(textCenterEnd) {
            top.linkTo(textTopEnd.bottom, 12.dp)
            end.linkTo(parent.end, 8.dp)
        })
        Text(text = "Text Bottom Start", modifier = Modifier.constrainAs(textBottomStart) {
            top.linkTo(textCenterStart.bottom, 12.dp)
            start.linkTo(parent.start, 8.dp)
        })
        Text(text = "Text Bottom Center", modifier = Modifier.constrainAs(textBottomCenter) {
            top.linkTo(textCenter.bottom, 12.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
        Text(text = "Text Bottom End", modifier = Modifier.constrainAs(textBottomEnd) {
            top.linkTo(textCenterEnd.bottom, 12.dp)
            end.linkTo(parent.end, 8.dp)
        })
    }
}

@Composable
fun ConstraintWithSet(constraintSet: ConstraintSet) {
    ConstraintLayout(
        constraintSet,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        val context = LocalContext.current
        var userName by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(value = userName, onValueChange = {
            userName = it
        }, label = { Text(text = "Username") }, modifier = Modifier.layoutId("inputName"))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password", color = Color.Red) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.layoutId("inputPassword")
        )

        Button(onClick = {
            Toast.makeText(
                context,
                "Username $userName , Password: $password ",
                Toast.LENGTH_SHORT
            ).show()
        }, modifier = Modifier.layoutId("buttonLogin")) {
            Text(text = "Login", fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

@Composable
fun TitleOfApp(title: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            ) {
                append(text = title)
            }
        }, modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ConstraintLayoutGuideLine() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray)
            .padding(12.dp)
    ) {
        val (input) = createRefs()
        val guideLineFromTop = createGuidelineFromTop(0.2f) // aqui tem 20% de distancia no top
        val guideLineFromStart = createGuidelineFromStart(50.dp)
        Text(text = "GuildLine From Top and Start", modifier = Modifier.constrainAs(input) {
            top.linkTo(guideLineFromTop, 8.dp)
            start.linkTo(guideLineFromStart, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
    }
}

@Composable
fun BarrierExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Green)
            .padding(12.dp)
    ) {
        val (input1, input2, input3) = createRefs()
        val barrier = createEndBarrier(input1, input2)
        Text(text = "Input 1 Large", modifier = Modifier.constrainAs(input1) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
        })
        Text(text = "Input 2", modifier = Modifier.constrainAs(input2) {
            top.linkTo(input1.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
        })
        Text(text = "Input 3", Modifier.constrainAs(input3) {
            top.linkTo(input1.bottom, 8.dp)
            start.linkTo(barrier, 8.dp)
        })

    }
}

@Composable
fun ConstrainWithChains() {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Cyan)
        .padding(12.dp)) {
        val (button1, button2, button3) = createRefs()
        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.SpreadInside)
        Button(onClick = { }, modifier = Modifier.constrainAs(button1){
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 1")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        }) {
            Text(text = "Button 2")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(button3){
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 3")
        }
    }
}