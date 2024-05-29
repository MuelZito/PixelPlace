package com.example.pixelplace.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pixelplace.R
import com.example.pixelplace.telas.AppDestinos
import com.example.pixelplace.telas.TelaBiblioteca
import com.example.pixelplace.telas.TelaCadastro
import com.example.pixelplace.telas.TelaInicial
import com.example.pixelplace.telas.TelaLogin
import com.example.pixelplace.ui.theme.TopBarColor
import com.example.pixelplace.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigationDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val pixelplace = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White)) {
            append("Pixel")
        }
        withStyle(style = SpanStyle(color = Color(0xFF2596BE))) {
            append("Place")
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.DarkGray
            ) {

                Text(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
                    text = pixelplace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    fontFamily = poppinsFontFamily,
                )

                HorizontalDivider(modifier = Modifier.padding(horizontal = 30.dp), thickness = 2.dp)

                NavigationDrawerItem(
                    modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Inicial",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                            navController.navigate(AppDestinos.Inicial.rota)

                        }

                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.inicial),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                NavigationDrawerItem(modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Biblioteca",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                            navController.navigate(AppDestinos.Biblioteca.rota)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.biblioteca),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                NavigationDrawerItem(modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Loja",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.loja),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                NavigationDrawerItem(modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Lista de Desejos",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lista_desejo),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

                HorizontalDivider(modifier = Modifier.padding(horizontal = 30.dp), thickness = 2.dp)

                NavigationDrawerItem(modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Comprar Contas",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.comprar_contas),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                NavigationDrawerItem(modifier = Modifier.padding(start = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = "Transações",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White

                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.transacoes),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = pixelplace,
                            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopBarColor,
                        titleContentColor = Color.White,

                        ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                tint = Color.White,
                                contentDescription = null
                            )
                        }
                    })
            }
        ) {paddingValues ->
            NavHost(navController = navController, startDestination = AppDestinos.Login.rota, modifier = Modifier.padding(paddingValues)) {
                composable(AppDestinos.Login.rota) { TelaLogin(navController) }
                composable(AppDestinos.Inicial.rota) { TelaInicial() }
                composable(AppDestinos.Biblioteca.rota) { TelaBiblioteca(navController) }
                composable(AppDestinos.Cadastro.rota) { TelaCadastro(navController) }
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview() {
    AppNavigationDrawer()
}