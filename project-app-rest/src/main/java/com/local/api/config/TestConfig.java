package com.local.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.local.api.model.entities.Categoria;
import com.local.api.model.entities.Pedido;
import com.local.api.model.entities.Produto;
import com.local.api.model.entities.Usuario;
import com.local.api.model.entities.enums.PedidoStatus;
import com.local.api.model.repositories.CategoriaRepository;
import com.local.api.model.repositories.PedidoRepository;
import com.local.api.model.repositories.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Electronics");
		Categoria categoria2 = new Categoria(null, "Books");
		Categoria categoria3 = new Categoria(null, "Computers");
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		produtoRepository.saveAll((Arrays.asList(produto1, produto2, produto3, produto4, produto5)));
		
		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria1);
		produto2.getCategorias().add(categoria3);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria2);
		
		produtoRepository.saveAll((Arrays.asList(produto1, produto2, produto3, produto4, produto5)));
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "99999-9999", "123456");
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario1);
		
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
	}
}