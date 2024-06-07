package com.suzintech.listatarefas.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.suzintech.listatarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {

    private val db = FirebaseFirestore.getInstance()
    private val _todasTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todasTarefas: StateFlow<MutableList<Tarefa>> = _todasTarefas

    fun salvarTarefa(
        tarefa: String,
        descricao: String,
        prioridade: Int
    ) {
        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas")
            .document(tarefa)
            .set(tarefaMap)
            .addOnCompleteListener {

            }.addOnFailureListener {

            }
    }

    fun buscarTarefas(): Flow<MutableList<Tarefa>> {
        val listaTarefas: MutableList<Tarefa> = mutableListOf()

        db.collection("tarefas").get().addOnCompleteListener { query ->
            if (query.isSuccessful) {
                for (documento in query.result) {
                    val tarefa = documento.toObject(Tarefa::class.java)
                    listaTarefas.add(tarefa)

                    _todasTarefas.value = listaTarefas
                }
            }
        }
        return todasTarefas
    }

    fun deletarTarefa(tarefa: String) {
        db.collection("tarefas").document(tarefa).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}