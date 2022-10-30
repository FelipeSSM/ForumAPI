package br.com.alura.forum.config.email;

public interface EmailSender {
    void send(String to, String email);
}
