package br.com.fiap.livraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.livraria.DTO.LivroDTO;
import br.com.fiap.livraria.DTO.NovoLivroDTO;
import br.com.fiap.livraria.DTO.NovoPrecoDTO;

@Service
public class LivrariaServiceImp implements LivrariaService{

	@Override
	public List<LivroDTO> listarLivros(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO buscarLivroPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO criar(NovoLivroDTO novoLivroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO atualizar(Long id, NovoLivroDTO novoLivroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDTO atualizarPreco(Long id, NovoPrecoDTO novoPrecoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarLivro(Long id) {
		// TODO Auto-generated method stub
		
	}

}
