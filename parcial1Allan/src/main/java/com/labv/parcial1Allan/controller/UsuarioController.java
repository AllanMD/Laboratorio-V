package com.labv.parcial1Allan.controller;

import com.labv.parcial1Allan.domain.Usuario;
import com.labv.parcial1Allan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;



    @PostMapping("")
    public void createUsuario (@RequestBody Usuario usuario, @RequestHeader HttpHeaders header){
        usuario.setBrowser(header.get("user-agent").get(0)); // me toma List de string en vez de String
        usuarioRepository.save(usuario);
    }

    @GetMapping("")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("{id}")
    public Usuario getUsuario (@PathVariable int id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No se encontro el usuario con el ID:" + id));

    }

    @PutMapping("")
    public void updateUsuario (@RequestBody Usuario usuario){
        usuarioRepository.save(usuario); // en el JSON hay que enviar el id del que hay que modificar tambien, sino crea uno nuevo
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario (@PathVariable Integer id){
        usuarioRepository.deleteById(id);

    }




}
