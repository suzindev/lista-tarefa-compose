package com.suzintech.listatarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.suzintech.listatarefas.components.Botao
import com.suzintech.listatarefas.components.CaixaTexto
import com.suzintech.listatarefas.ui.theme.PURPLE700
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_GREEN_DISABLE
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_RED_DISABLE
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_YELLOW_DISABLE
import com.suzintech.listatarefas.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.suzintech.listatarefas.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = PURPLE700,
                title = {
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        }
    ) {
        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        var semPrioridadeTarefa by remember {
            mutableStateOf(false);
        }

        var prioridadeBaixaTarefa by remember {
            mutableStateOf(false);
        }

        var prioridadeMediaTarefa by remember {
            mutableStateOf(false);
        }

        var prioridadeAltaTarefa by remember {
            mutableStateOf(false);
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            CaixaTexto(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Nível de prioridade")

                RadioButton(
                    selected = prioridadeBaixaTarefa,
                    onClick = {
                        prioridadeBaixaTarefa = !prioridadeBaixaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLE,
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED
                    )
                )

                RadioButton(
                    selected = prioridadeMediaTarefa,
                    onClick = {
                        prioridadeMediaTarefa = !prioridadeMediaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLE,
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                    )
                )

                RadioButton(
                    selected = prioridadeAltaTarefa,
                    onClick = {
                        prioridadeAltaTarefa = !prioridadeAltaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_RED_DISABLE,
                        selectedColor = RADIO_BUTTON_RED_SELECTED
                    )
                )
            }

            Botao(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "Salvar"
            )
        }
    }
}