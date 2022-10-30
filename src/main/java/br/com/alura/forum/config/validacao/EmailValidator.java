package br.com.alura.forum.config.validacao;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {

        //TODO: CÓDIGO DE VALIDAÇÃO DE EMAILS!

        return true;
    }
}
