import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorUi(
    pageSize: Int,
    currentPage:Int,
    selectedColor: Color = Color(0XFF6C63FF),
    unSelectedColor : Color = Color.Gray,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        repeat(pageSize) {
            Spacer(modifier = Modifier.size(4.dp))
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .width(if (it == currentPage)20.dp else 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = if (it == currentPage)selectedColor else unSelectedColor
                    )

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun IndicatorPreview1() {
    IndicatorUi(3,0)
}

@Preview(showBackground = true)
@Composable
private fun IndicatorPreview2() {
    IndicatorUi(3,1)
}


@Preview(showBackground = true)
@Composable
private fun IndicatorPreview3() {
    IndicatorUi(3,2)
}