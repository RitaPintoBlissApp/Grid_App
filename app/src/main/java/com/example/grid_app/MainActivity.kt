package com.example.grid_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grid_app.data.DataSource
import com.example.grid_app.model.Topic
import com.example.grid_app.ui.theme.Grid_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Grid_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGridApp()
                }
            }
        }
    }
}

@Composable
fun TopicGridApp() {
    TopicGrid(tipsList = DataSource.topics, modifier = Modifier)
}
@Composable
fun TopicGrid( tipsList: List<Topic>, modifier: Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier){
        items(tipsList){topic ->
            Griditem(
                topic = topic,
                modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun Griditem(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier.height(68.dp) ) {
       Row {
           Image(
               painter = painterResource(topic.imageResourceId) ,
               contentDescription = stringResource(topic.stringResourceId),
               modifier = Modifier
                   .size(width = 68.dp, height = 68.dp)
                   .aspectRatio(1f),
               contentScale = ContentScale.Crop
           )
           Column(modifier.padding(
               start = 0.dp,
               bottom = 0.dp,
               top = 16.dp,
               end = 16.dp,
           )) {
               Text(
                   text = LocalContext.current.getString(topic.stringResourceId),
                   fontSize = 11.sp,
                   modifier = Modifier
                       .padding(
                           start = 16.dp,
                           bottom = 8.dp,
                       ),

                   style = MaterialTheme.typography.headlineSmall,


               )
               Row() {
                   Image(
                       painter = painterResource(R.drawable.ic_grain) ,
                       contentDescription = stringResource(topic.stringResourceId),
                       modifier = Modifier
                           .padding(start = 16.dp)
                           .heightIn(20.dp),
                       contentScale = ContentScale.Fit,

                   )
                   Text(
                       text = topic.numberResourceId.toString(),
                       fontSize = 10.sp,
                       modifier = Modifier.padding(
                           top = 2.dp,
                           start = 8.dp),
                       style = MaterialTheme.typography.headlineSmall
                   )
               }

           }

       }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Grid_AppTheme {
       TopicGridApp()
 }
}