package com.example.granery_app_one.ui.theme.pages.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.granery_app_one.data.AuthRepository
import com.example.granery_app_one.navigation.ROUTE_HOME
import com.example.granery_app_one.navigation.ROUTE_SIGNUP
import com.example.granery_app_one.ui.theme.Granery_App_OneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Login Here",
            color = Color.Green,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold


        )

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email!") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password= it},
            label = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )



        Spacer(modifier = Modifier.height(50.dp))


        Button(onClick = {
            // ---WRITE LOGIN LOGIC HERE----//
            var authRepository = AuthRepository(navController, context)
            authRepository.login(email.text.trim(), password.text)


        }) {
            Text(text = "Login")

        }
        Spacer(modifier = Modifier.height(25.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = {navController.navigate(ROUTE_HOME)},
            Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(Color.White)) {
            Text(text = "BACK HOME", color = Color.Red, fontSize = 17.sp, modifier = Modifier.padding(vertical = 10.dp))
        }


        Spacer(modifier = Modifier.height(25.dp))

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    Granery_App_OneTheme{
        LoginScreen(rememberNavController())
    }

}

