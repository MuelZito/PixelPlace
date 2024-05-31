package com.example.pixelplace.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pixelplace.entities.Jogo
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun CardJogo(jogo: Jogo) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(290.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3E3E3E))
    ) {
        Column {
            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Imagem Card",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = jogo.nome,
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = jogo.desenvolvedora,
                    color = Color(0xFF979494),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )

//                Row(
//                    modifier = Modifier
//                        .padding(top = 0.dp),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    jogo.categoria.split(",").forEach { categoria ->
//                        Box(
//                            modifier = Modifier
//                                .padding(top = 6.dp)
//                                .background(
//                                    Color.White.copy(alpha = 0.3f),
//                                    RoundedCornerShape(3.dp)
//                                )
//                                .padding(
//                                    horizontal = 4.dp,
//                                    vertical = 2.dp
//                                )
//                        ) {
//                            Text(
//                                text = categoria.trim(),
//                                color = Color(0xFFFEFEFE),
//                                fontFamily = poppinsFontFamily,
//                                fontWeight = FontWeight.Medium,
//                                fontSize = 12.sp
//                            )
//                        }
//                    }
//                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .shadow(
                            elevation = 10.dp,
                            RoundedCornerShape(12.dp),
                            ambientColor = Color(0xFF2596BE),
                            spotColor = Color(0xFF2596BE),
                            clip = false
                        )
                        .size(width = 150.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2596BE)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "R$ ${jogo.preco}",  // Adicione formatação para o preço
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}


@Composable
fun CardJogoDestaque(jogo: Jogo) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }
    Card(
        modifier = Modifier
            .width(380.dp)
            .height(250.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3E3E3E))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Imagem Card",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(10.dp)), // ajustado para coincidir com a borda do Card
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                Text(
                    text = jogo.nome,
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    jogo.categoria.split(",").forEach { categoria ->
                        Box(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .background(
                                    Color.White.copy(alpha = 0.3f),
                                    RoundedCornerShape(3.dp)
                                )
                                .padding(
                                    horizontal = 4.dp,
                                    vertical = 2.dp
                                ) // padding interno ao Box
                        ) {
                            Text(
                                text = categoria.trim(),
                                color = Color(0xFFFEFEFE),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = "R$ ${jogo.preco}",
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

            }
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardJogoPreview() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        CardJogo("Minecraft", "Mojang", "", "R$56.90")
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun CardJogoDestaquePreview() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        CardJogoDestaque("Minecraft", "", "R$ 76.90")
//    }
//}

    fun decodeBase64ToBitmap(base64Str: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64Str, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            null
        }
    }




