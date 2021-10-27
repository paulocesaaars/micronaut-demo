package com.deviot.exception

import java.time.LocalDateTime

data class MensagemErro(
    val mensagem: String?,
    val dataHora: String = LocalDateTime.now().toString()
) {
}