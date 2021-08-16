package br.com.fiap.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.livraria.DTO.LivroDTO;
import br.com.fiap.livraria.DTO.NovoLivroDTO;
import br.com.fiap.livraria.DTO.NovoPrecoDTO;
import br.com.fiap.livraria.service.LivrariaService;

@RestController
@RequestMapping("livros")
public class LivrariaController {

	private LivrariaService livrariaService;
	

	//Injetando através do construtor
	//Recebemos como parametro uma instancia de LivrariaService
	public LivrariaController(LivrariaService livrariaService) {
		this.livrariaService = this.livrariaService;
	}

	@GetMapping
	public List<LivroDTO> getLivros(@RequestParam String titulo) {
		return livrariaService.listarLivros(titulo);
	}

	@GetMapping("{id}")
	public LivroDTO getLivroById(@PathVariable(name = "id") Long id) {
		return livrariaService.buscarLivroPorId(id);
	}
	
	//OK
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroDTO createLivro(@RequestBody NovoLivroDTO novoLivroDTO) {
		return livrariaService.criar(novoLivroDTO);
	}

	@PutMapping
	public LivroDTO updateLivro(@RequestBody NovoLivroDTO novoLivroDTO, @PathVariable Long id) {
		return livrariaService.atualizar(id, novoLivroDTO);
	}

	@PatchMapping("{id}")
	public LivroDTO updatePrecoDoLivro(@RequestBody NovoPrecoDTO novoPrecoDTO, 
			@PathVariable Long id) {
		return livrariaService.atualizarPreco(id, novoPrecoDTO);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLivro(@PathVariable Long id) {
		livrariaService.deletarLivro(id);
	}


}
