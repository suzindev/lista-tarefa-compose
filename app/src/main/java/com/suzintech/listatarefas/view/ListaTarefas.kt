package com.suzintech.listatarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.suzintech.listatarefas.R
import com.suzintech.listatarefas.itemLista.TarefaItem
import com.suzintech.listatarefas.model.Tarefa
import com.suzintech.listatarefas.ui.theme.BLACK
import com.suzintech.listatarefas.ui.theme.PURPLE700
import com.suzintech.listatarefas.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = PURPLE700,
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        },
        backgroundColor = BLACK,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarTarefa")
                },
                backgroundColor = PURPLE700
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Adicionar"
                )
            }
        }
    ) {
        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                tarefa = "Teste",
                descricao = "Testando",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "Teste1",
                descricao = "Testando1",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "Teste2",
                descricao = "Testando2",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "Teste3",
                descricao = "Testando3",
                prioridade = 3
            )
        )

        LazyColumn {
            itemsIndexed(listaTarefas) { position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }
    }
}