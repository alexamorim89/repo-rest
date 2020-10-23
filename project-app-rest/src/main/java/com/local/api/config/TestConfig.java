package com.local.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.local.api.model.entities.Categoria;
import com.local.api.model.entities.Pedido;
import com.local.api.model.entities.Usuario;
import com.local.api.model.entities.enums.PedidoStatus;
import com.local.api.model.repositories.CategoriaRepository;
import com.local.api.model.repositories.PedidoRepository;
import com.local.api.model.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Electronics");
		Categoria categoria2 = new Categoria(null, "Books");
		Categoria categoria3 = new Categoria(null, "Computers");
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "99999-9999", "123456");
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario1);
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
	}
}