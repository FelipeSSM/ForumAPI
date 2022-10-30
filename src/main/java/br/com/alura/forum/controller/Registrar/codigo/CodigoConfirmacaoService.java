package br.com.alura.forum.controller.Registrar.codigo;

import br.com.alura.forum.repository.CodigoConfirmacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CodigoConfirmacaoService {

    @Autowired
    private CodigoConfirmacaoRepository codigoConfirmacaoRepository;

    public void salvarCodigoConfirmacao(CodigoConfirmacao codigoConfirmacao) {
        codigoConfirmacaoRepository.save(codigoConfirmacao);
    }

    public Optional<CodigoConfirmacao> getCodigo(String codigo) {
        return codigoConfirmacaoRepository.findByCodigo(codigo);
    }


    public int setConfirmedAt(String codigo) {
        return codigoConfirmacaoRepository.updateConfirmedAt(codigo, LocalDateTime.now());
    }
}
