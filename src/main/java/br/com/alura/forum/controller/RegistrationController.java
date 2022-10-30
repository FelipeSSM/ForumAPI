package br.com.alura.forum.controller;

import br.com.alura.forum.controller.Registrar.RegistrarService;
import br.com.alura.forum.controller.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registrar")
public class RegistrationController {

    @Autowired
    private RegistrarService registrarService;

    @PostMapping
    public String registrar(@RequestBody UsuarioForm usuarioForm) {
        return registrarService.registrar(usuarioForm);
    }

    @GetMapping(path = "/confirmar")
    public String confirmar(@RequestParam("codigo") String codigo) {
        return registrarService.confirmarCodigo(codigo);
    }

}
