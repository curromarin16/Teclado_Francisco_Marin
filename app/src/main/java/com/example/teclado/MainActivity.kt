package com.example.teclado

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TecladoMusicalApp()
        }
    }
}

@Composable
fun TecladoMusicalApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8B4513))
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.piano),
            contentDescription = "Piano desde arriba",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

       
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            PianoKey("Do", R.raw.d, White)
            PianoKey("Re", R.raw.re, White)
            PianoKey("Mi", R.raw.mi, White)
            PianoKey("Fa", R.raw.fa, White)
            PianoKey("Sol", R.raw.sol, White)
            PianoKey("La", R.raw.la, White)
            PianoKey("Si", R.raw.si, White)
        }
    }
}
@Composable
fun PianoKey(nota: String, resourceId: Int, keyColor: Color) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .size(60.dp, 200.dp)
            .background(keyColor, shape = RoundedCornerShape(4.dp))
            .clickable {

                val mediaPlayer = MediaPlayer.create(context, resourceId)
                mediaPlayer?.apply {
                    setOnCompletionListener { it.release() }
                    start()
                }
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(text = nota, color = Black)
    }
}




