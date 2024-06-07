package com.suzintech.listatarefas.repository

import com.suzintech.listatarefas.datasource.DataSource

class TarefasRepository {

    private val dataSource = DataSource()

    fun salvar(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }
}