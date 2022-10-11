package com.example.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jpc.ui.theme.Shapes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }

    @Composable
    private fun SetBackground() {
        Surface(
            color = Color.Black,
            modifier = Modifier
                .fillMaxSize()
        ) {
            // do nothing
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun DefaultPreview() {
        SetBackground()
        CustomDialog()
    }

    @Composable
    private fun CustomDialog() {
        Dialog(
            onDismissRequest = { /*TODO*/ }
        ) {
            Card {
                CreateCustomGridView()
            }
        }
    }

    @Composable
    private fun CreateCustomGridView() {
        val items = arrayListOf(
            Item("LARGE 1", 1, ItemTypes.LARGE),
            Item("MEDIUM 2", 2, ItemTypes.MEDIUM),
            Item("MEDIUM 3", 3, ItemTypes.MEDIUM),
            Item("LONG 4", 4, ItemTypes.LONG),
            Item("MEDIUM 5", 5, ItemTypes.MEDIUM),
            Item("SMALL 6", 6, ItemTypes.SMALL, "SMALL 7"),
        )
        var nextPosition = 0
        Column(
            modifier = Modifier
                .wrapContentSize()
        ) {
            // row 1
            Row {
                LargeItem(items.getOrNull(0)?.value ?: "")
                Column {
                    nextPosition = if (items.getOrNull(1)?.itemType == ItemTypes.SMALL) {
                        SmallItem(
                            items.getOrNull(1)?.value ?: "",
                            items.getOrNull(1)?.value2 ?: ""
                        )
                        MediumItem(items.getOrNull(2)?.value ?: "")
                        4
                    } else if (items.getOrNull(2)?.itemType == ItemTypes.SMALL) {
                        MediumItem(items.getOrNull(1)?.value ?: "")
                        SmallItem(
                            items.getOrNull(2)?.value ?: "",
                            items.getOrNull(2)?.value2 ?: ""
                        )
                        4
                    } else {
                        MediumItem(items.getOrNull(1)?.value ?: "")
                        MediumItem(items.getOrNull(2)?.value ?: "")
                        3
                    }
                }
            }
            // row 2
            Row {
                when (items.getOrNull(nextPosition)?.itemType) {
                    ItemTypes.SMALL -> {
                        SmallItem(
                            items.getOrNull(nextPosition)?.value ?: "",
                            items.getOrNull(nextPosition)?.value2 ?: ""
                        )
                        MediumItem(items.getOrNull(nextPosition + 1)?.value ?: "")
                        nextPosition += 3
                    }

                    ItemTypes.LONG -> {
                        LongItem(items.getOrNull(nextPosition)?.value ?: "")
                        nextPosition++
                    }

                    null -> {}

                    else -> {
                        MediumItem(items.getOrNull(nextPosition)?.value ?: "")
                        SmallItem(
                            items.getOrNull(nextPosition + 1)?.value ?: "",
                            items.getOrNull(nextPosition + 1)?.value2 ?: ""
                        )
                        nextPosition += 3
                    }
                }
            }
            // row 3
            Row {
                when (items.getOrNull(nextPosition)?.itemType) {
                    ItemTypes.SMALL -> {
                        SmallItem(
                            items.getOrNull(nextPosition)?.value ?: "",
                            items.getOrNull(nextPosition)?.value2 ?: ""
                        )
                        MediumItem(items.getOrNull(nextPosition + 1)?.value ?: "")
                    }

                    ItemTypes.LONG -> {
                        LongItem(items.getOrNull(nextPosition)?.value ?: "")
                    }

                    null -> {}

                    else -> {
                        MediumItem(items.getOrNull(nextPosition)?.value ?: "")
                        SmallItem(
                            items.getOrNull(nextPosition + 1)?.value ?: "",
                            items.getOrNull(nextPosition + 1)?.value2 ?: ""
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun MediumItem(value: String) {
        Row {
            Text(
                text = value,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(165.dp)
                    .height(84.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, Shapes.small)
                    .padding(5.dp)
            )
        }
    }

    @Composable
    private fun SmallItem(value1: String, value2: String) {
        Row {
            Text(
                text = value1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(76.dp)
                    .height(84.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, Shapes.small)
                    .padding(5.dp)
            )
            Text(
                text = value2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(76.dp)
                    .height(84.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, Shapes.small)
                    .padding(5.dp)
            )
        }
    }

    @Composable
    private fun LargeItem(value: String) {
        Row {
            Text(
                text = value,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(165.dp)
                    .height(180.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, Shapes.small)
                    .padding(5.dp)
            )
        }
    }

    @Composable
    private fun LongItem(value: String) {
        Row {
            Text(
                text = value,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(343.dp)
                    .height(84.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Black, Shapes.small)
                    .padding(5.dp)
            )
        }
    }

    data class Item(
        val value: String,
        val position: Int,
        val itemType: ItemTypes,
        val value2: String? = ""
    )

    enum class ItemTypes {
        SMALL,
        MEDIUM,
        LONG,
        LARGE
    }
}