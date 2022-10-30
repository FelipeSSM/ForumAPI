package br.com.alura.forum.config.security;

import java.util.Optional;
import java.util.UUID;

import br.com.alura.forum.controller.Registrar.codigo.CodigoConfirmacao;
import br.com.alura.forum.controller.Registrar.codigo.CodigoConfirmacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CodigoConfirmacaoService codigoConfirmacaoService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

	public String cadastrarUsuario(Usuario usuario) {
		boolean emailExiste = repository.findByEmail(usuario.getEmail()).isPresent();
		if(emailExiste) {
			throw new IllegalStateException("Email já cadastrado!");
		}

		String senhaEncodada = bCryptPasswordEncoder.encode(usuario.getPassword());

		usuario.setSenha(senhaEncodada);


		repository.save(usuario);

		//TODO: ENVIAR EMAIL DE CONFIRMAÇÃO DE EMAIL
		String codigo = UUID.randomUUID().toString();
		CodigoConfirmacao codigoConfirmacao = new CodigoConfirmacao(codigo, usuario);
		codigoConfirmacaoService.salvarCodigoConfirmacao(codigoConfirmacao);

		//TODO: ENVIAR EMAIL

		return codigo;
	}

	public int ativaUsuario(String email) {
		return repository.ativarUsuario(email);
	}

}
