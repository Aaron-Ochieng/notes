package com.aaochieng.todo.onboading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Illustration(onBoardingModel: OnBoardingModel){
    Column {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = onBoardingModel.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().padding(50.dp,0.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = onBoardingModel.title,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = onBoardingModel.description,
            modifier = Modifier.fillMaxWidth().padding(25.dp,0.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W500,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview1() {
Illustration(OnBoardingModel.FirstPage)
}


@Preview(showBackground = true)
@Composable
private fun Preview2() {
    Illustration(OnBoardingModel.SecondPage)
}


@Preview(showBackground = true)
@Composable
private fun Preview3() {
    Illustration(OnBoardingModel.ThirdPage)
}