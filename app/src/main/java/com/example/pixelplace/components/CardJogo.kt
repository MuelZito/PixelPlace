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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pixelplace.entities.Jogo
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun CardJogo(jogo: Jogo, addCarrinho: (Jogo) -> Unit) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }
    var isSelected by remember { mutableStateOf(false) }

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


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "R$ ${jogo.preco}",
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    IconButton(
                        onClick = { addCarrinho(jogo) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier.size(18.dp)
                        )

                    }
                    IconButton(onClick = { isSelected = !isSelected }) {
                        Icon(
                            imageVector = if (isSelected) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = null,
                            tint = if (isSelected) Color.Red else Color.LightGray,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }


            }
        }
    }
}


@Composable
fun CardJogoDestaque(jogo: Jogo, addCarrinho: (Jogo) -> Unit) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }
    var isSelected by remember { mutableStateOf(false) }

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
                        .clip(shape = RoundedCornerShape(10.dp)),
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

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = "R$ ${jogo.preco}",
                        color = Color(0xFFFEFEFE),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    IconButton(
                        onClick = { addCarrinho(jogo) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )

                    }
                    IconButton(onClick = { isSelected = !isSelected }) {
                        Icon(
                            imageVector = if (isSelected) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = null,
                            tint = if (isSelected) Color.Red else Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                }
            }
        }

    }
}

@Composable
fun CardJogoCarrinho(jogo: Jogo, removerCarrinho: (Jogo) -> Unit) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }

    Card(
        modifier = Modifier
            .padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Imagem do jogo",
                        modifier = Modifier
                            .size(90.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(
                        text = jogo.nome,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )

                    Text(
                        text = "R$ ${jogo.preco}",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
            IconButton(
                onClick = { removerCarrinho(jogo) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Outlined.DeleteForever,
                    contentDescription = "Excluir jogo",
                    tint = Color.Red
                )
            }
        }
    }
}

@Composable
fun CardBiblioteca(jogo: Jogo) {
    val bitmap = remember { decodeBase64ToBitmap(jogo.imagem) }
    Card(
        modifier = Modifier
            .padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Imagem do jogo",
                        modifier = Modifier
                            .size(90.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(
                        text = jogo.nome,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = jogo.desenvolvedora,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun CardJogoCarrinhoPreview() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
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




