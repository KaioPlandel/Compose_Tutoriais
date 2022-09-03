package com.plandel.composetutoriais

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayAnnotatedString() {
    val context = LocalContext.current
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Text")
        }
        append(" Jetpack")

        withStyle(style = SpanStyle(color = Color.Red, fontFamily = FontFamily.Monospace)) {
            append(" Compose")
        }

    })
}


// input
@Composable
fun DisplayTextField() {
    var name by remember {
        mutableStateOf("")
    }

    TextField(value = name, onValueChange = {
        name = it
    }, label = { Text(text = "Username", style = TextStyle(fontSize = 18.sp)) })
}

@Composable
fun DisplayOutlinedTextField() {
    var name by remember {
        mutableStateOf("")
    }

    OutlinedTextField(value = name, onValueChange = {
        name = it
    }, label = { Text(text = "Username") },
        maxLines = 1, modifier = Modifier.padding(8.dp),
        textStyle = TextStyle(color = Color.Red, fontFamily = FontFamily.Monospace)
    )
}

@Composable
fun DisplayPassword() {
    var password by remember {
        mutableStateOf("Hello")
    }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = ("Enter password")) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) // altera o tipo de input
    )
}

@Composable
fun DisplayPrimaryButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Primary button clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = "Primary Button",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun DisplayOutlineButton() {
    val context = LocalContext.current
    OutlinedButton(
        onClick = {
            Toast.makeText(
                context,
                "Outlined Button clicked",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = "Outlined Button")
    }
}

@Composable
fun DisplayRadioButton() {
    val cities = listOf("Vitoria", "São Paulo", "Ipatinga")
    val (selected, onOptionSelected) = remember {
        mutableStateOf(cities[0])
    }
    Column(modifier = Modifier.padding(4.dp)) {
        cities.forEach { text ->
            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(4.dp)) {
                RadioButton(selected = selected == text, onClick = {
                    onOptionSelected(text)
                })
                Text(text = text, Modifier.clickable { onOptionSelected(text) })
            }
        }
    }
}

@Composable
fun DiplaySwitch() {
    val context = LocalContext.current
    var switchStatus by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(8.dp)) {
        Text(text = "Light on/off")
        Switch(checked = switchStatus, onCheckedChange = {
            switchStatus = it
            Toast.makeText(context,"Light ${if(it) "on" else "off"}", Toast.LENGTH_LONG).show()
        })
    }
}