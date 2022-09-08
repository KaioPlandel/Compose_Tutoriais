package com.plandel.composetutoriais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val constraintSet = ConstraintSet {
                val buttonLogin = createRefFor("buttonLogin")
                val inputName = createRefFor("inputName")
                val inputPassword = createRefFor("inputPassword")

                constrain(inputName){
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }

                constrain(inputPassword){
                    top.linkTo(inputName.bottom, 8.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }

                constrain(buttonLogin) {
                    top.linkTo(inputPassword.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.White,
                                Color.Black
                            ), startY = 300F
                        )
                    )
                    .padding(8.dp)
            ) {
                TitleOfApp(title = "Jetpack Compose")
                Text(text = "Chains Example", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                ConstrainWithChains()
                Spacer(modifier = Modifier.height(5.dp))
                ConstraintLayoutGuideLine()
                Text(text = "Barrier Example", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                BarrierExample()
                Constraint()
                ConstraintWithSet(constraintSet = constraintSet)

            }
        }
    }
}








