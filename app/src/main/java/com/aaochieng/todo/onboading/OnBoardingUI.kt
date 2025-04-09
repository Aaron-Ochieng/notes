package com.aaochieng.todo.onboading

import IndicatorUi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch



@Composable
fun OnBoardingUI(onFinished:() -> Unit){
    val pages = listOf<OnBoardingModel>(
        OnBoardingModel.FirstPage,
        OnBoardingModel.SecondPage,
        OnBoardingModel.ThirdPage)
    val pageState = rememberPagerState (initialPage = 0){ pages.size  }
    val scope = rememberCoroutineScope();
    val currentData = pages[pageState.currentPage]


    Scaffold(
        bottomBar = {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = 20.dp,
                        start=20.dp,
                        end=20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
            ){
                if (pageState.currentPage != pages.size -1 ){
                    Box(
                        modifier = Modifier.clickable(
                            onClick = {
                                scope.launch {
                                    if (pageState.currentPage != pages.size -1){
                                        pageState.animateScrollToPage(pages.size-1)
                                    }
                                }
                            }
                        ).padding(10.dp)
                    ){
                        Text(
                            text = "Skip",
                            style = TextStyle(
                                color = Color(0XFF6C63FF),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }else{
                    Box(modifier = Modifier.padding(10.dp).width(30.dp))
                }
                Box(
                    modifier = Modifier.padding(10.dp)
                ){

                    IndicatorUi(
                        pages.size,pageState.currentPage
                    )
                }

                Box(
                    modifier = Modifier.clickable(
                        onClick = {
                            scope.launch {
                                if (pageState.currentPage != pages.size){
                                    pageState.animateScrollToPage(pageState.currentPage+1)
                                }
                            }
                        }
                    ).padding(10.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = if (pageState.currentPage != pages.size -1) "Next" else "Get Started",
                        style = TextStyle(
                            color = Color(0XFF6C63FF),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )


                }


            }
        }
    ) { innerPadding ->
        HorizontalPager(pageState) { index ->
        Column (
            modifier = Modifier.fillMaxSize()
        ){
                Illustration(pages[index])
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun OnBoarding1() {
    OnBoardingUI(onFinished = {})
}

@Preview(showBackground = true)
@Composable
private fun OnBoarding2() {
    OnBoardingUI(onFinished = {})
}

@Preview(showBackground = true)
@Composable
private fun OnBoarding3() {
    OnBoardingUI(onFinished = {})
}