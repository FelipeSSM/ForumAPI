package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Perfil;

public class UsuarioForm {

    private String nome;
    private String email;
    private String senha;
    private Perfil perfil;

    public UsuarioForm(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioForm() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
