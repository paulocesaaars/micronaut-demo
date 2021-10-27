package com.deviot.controller

import com.deviot.model.Usuario
import com.deviot.service.UsuarioService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/usuario")
class UserController(@Inject val usuarioService: UsuarioService) {

    @Get()
    fun getUsuarios(): List<Usuario> {
        return usuarioService.retornaUsuarios()
    }

    @Get("{id}")
    fun getUsuario(@PathVariable id: Long): Usuario {
        return usuarioService.retornaUsuarioPorId(id)
    }

    @Post()
    fun postUsuario(@Body usuario: Usuario) : HttpResponse<Usuario> {
        return  HttpResponse.created(usuarioService.inserirUsuario(usuario))
    }

    @Put("{id}")
    fun putUsuario(@PathVariable id: Long, @Body usuario: Usuario) : HttpResponse<Usuario> {
        return  HttpResponse.ok(usuarioService.atualizarUsuario(id, usuario))
    }

    @Delete("{id}")
    fun deleteUsuario(@PathVariable id: Long) : HttpResponse<Unit> {
        usuarioService.deleteUsuario(id)
        return HttpResponse.noContent()
    }
}