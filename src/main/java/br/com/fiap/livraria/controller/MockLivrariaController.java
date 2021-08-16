package br.com.fiap.livraria.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.livraria.DTO.LivroDTO;
import br.com.fiap.livraria.DTO.NovoLivroDTO;
import br.com.fiap.livraria.DTO.NovoPrecoDTO;

@RestController
@RequestMapping("livrosMock")
public class MockLivrariaController {
	
	
	private List<LivroDTO> livroDTOList;
	
/////MOCK FUNCIONAL	
	public MockLivrariaController() {
		
		LivroDTO livroDTO1 = new LivroDTO();
		livroDTO1.setIsbn("1");
		livroDTO1.setTitulo("Spring Boot API");
		livroDTO1.setPreco(BigDecimal.valueOf(55.80));
		livroDTO1.setAutor("João Neves");
		
		LivroDTO livroDTO2 = new LivroDTO();
		livroDTO2.setIsbn("2");
		livroDTO2.setTitulo("Spring Boot API");
		livroDTO2.setPreco(BigDecimal.valueOf(55.80));
		livroDTO2.setAutor("João Neves");
		
		livroDTOList = new ArrayList<>();
		livroDTOList.add(livroDTO1);
		livroDTOList.add(livroDTO2);
		
	}
/////MOCK FUNCIONAL	
	
	
	@GetMapping
	public List<LivroDTO> getLivros(){
		
//		LivroDTO livroDTO = new LivroDTO();
//		livroDTO.setIsbn("53434015343");
//		livroDTO.setTitulo("Spring Boot API");
//		livroDTO.setPreco(BigDecimal.valueOf(55.80));
//		livroDTO.setAutor("João Neves");
//		//Acrescentando em uma lista
//		List<LivroDTO> listaLivros  = new ArrayList<>();
//		listaLivros.add(livroDTO);
//		//Retornando a lista
		//return listaLivros;
		return livroDTOList;
	}
	
	@GetMapping("{isbm}")
	public LivroDTO getLivroById(
			@PathVariable(name = "isbm") String isbm
		) {
		return buscarLivroPorIsbm(isbm);
	}
	
	@PutMapping
	public LivroDTO updateLivro(
			@RequestBody NovoLivroDTO novoLivroDTO,
			@PathVariable String isbm
			) {
		LivroDTO livroEncontradoDTO = buscarLivroPorIsbm(isbm);
		livroEncontradoDTO.setTitulo(novoLivroDTO.getTitulo());
		livroEncontradoDTO.setAutor(novoLivroDTO.getAutor());
		livroEncontradoDTO.setPreco(novoLivroDTO.getPreco());
		return livroEncontradoDTO;
	}
	
	@PatchMapping("{isbm}")
	public LivroDTO updatePrecoDoLivro(
			@RequestBody NovoPrecoDTO novoPrecoDTO,
			@PathVariable String isbm
			) {
		LivroDTO livroEncontradoDTO = buscarLivroPorIsbm(isbm);
		livroEncontradoDTO.setPreco(novoPrecoDTO.getPreco());
		return livroEncontradoDTO;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO createLivro(
			@RequestBody LivroDTO newLivro
			) {
		livroDTOList.add(newLivro);
		return newLivro;
	}
	
	
	@DeleteMapping("{isbm}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLivro(
			@PathVariable String isbm
			) {
		LivroDTO livroEncontradoDTO = buscarLivroPorIsbm(isbm);
		livroDTOList.remove(livroEncontradoDTO);
	}
	
	
	
	private LivroDTO buscarLivroPorIsbm(@PathVariable String isbm) {
		return livroDTOList.stream()
				.filter(dto -> dto.getIsbn().equals(isbm))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
 