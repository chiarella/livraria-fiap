Projeto Livraria -  API REST

JAVA 11
API REST
GRADLE
SWAGGER
SPRING FOX


Arquivo de Configuração application.yml

Methodos

@GetMapping	
	getLivros(titulos)
	getLivrosById(id)
	
@PostMapping
	createLivros(NovoLivroDTO)
	
@PutMapping
	updateLivro(NovoLivroDTO, id)

@PatchMapping
	updatePrecoDoLivro(NovoPrecoDTO, id)

@DeleteMapping
	deleteLivro(id)	
