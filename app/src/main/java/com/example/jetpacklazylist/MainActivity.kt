package com.example.jetpacklazylist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklazylist.ui.theme.JetpackLazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackLazyListTheme {
                val theTotalList = listOf(
                    Cat("1", "Siamese", "Whiskers"),
                    Cat("2", "Persian", "Fluffy"),
                    Cat("3", "Maine Coon", "Shadow"),
                    Cat("4", "Bengal", "Simba"),
                    Cat("5", "Sphynx", "Baldy"),
                    Cat("6", "Ragdoll", "Mittens"),
                    Cat("7", "British Shorthair", "Smokey"),
                    Cat("8", "Abyssinian", "Amber"),
                    Cat("9", "Scottish Fold", "Luna"),
                    Cat("10", "Russian Blue", "Silver"),
                    Cat("11", "Norwegian Forest", "Thor"),
                    Cat("12", "Birman", "Snowball"),
                    Cat("13", "American Shorthair", "Tiger"),
                    Cat("14", "Devon Rex", "Pixie"),
                    Cat("15", "Himalayan", "Cloud"),
                    Cat("16", "Balinese", "Willow"),
                    Cat("17", "Turkish Van", "Splash"),
                    Cat("18", "Oriental Shorthair", "Slender"),
                    Cat("19", "Cornish Rex", "Twist"),
                    Cat("20", "Savannah", "Hunter"),
                    Cat("21", "Egyptian Mau", "Cleopatra"),
                    Cat("22", "Tonkinese", "Coco"),
                    Cat("23", "Bombay", "Midnight"),
                    Cat("24", "Chartreux", "Ash"),
                    Cat("25", "Korat", "Zara"),
                    Cat("26", "Burmese", "Mocha"),
                    Cat("27", "Ocicat", "Spots"),
                    Cat("28", "Singapura", "Tiny"),
                    Cat("29", "Selkirk Rex", "Curly"),
                    Cat("30", "LaPerm", "Frizzy")
                )

                LazyColumn {
                    items(items = theTotalList) {oneCat ->
                        RowItem(cat = oneCat)
                    }
                }
            }
        }
    }
}

@Composable
fun RowItem(cat: Cat, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "This is Index ${cat.id}", Toast.LENGTH_LONG)
                    .show()
            }
    )
    {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Text(
                text = cat.id, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp)
            )
            Column {
                Text(text = cat.name)
                Text(text = cat.type)
            }
            Image(
                painter = painterResource(id = cat.pic),
                contentDescription = cat.name + "picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp)
            )
        }
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackLazyListTheme {
        Greeting("Android")
    }
}