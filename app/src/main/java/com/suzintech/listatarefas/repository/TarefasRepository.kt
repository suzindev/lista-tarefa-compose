package com.suzintech.listatarefas.repository

import com.suzintech.listatarefas.datasource.DataSource
import com.suzintech.listatarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepository {

    private val dataSource = DataSource()

    fun salvar(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }

    fun findAll(): Flow<MutableList<Tarefa>> {
        return dataSource.buscarTarefas()
    }

    fun delete(tarefa: String) {
        dataSource.deletarTarefa(tarefa)
    }
}