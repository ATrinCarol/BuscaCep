package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.PessoaDoadora;
import one.digitalinnovation.gof.service.PessoaDoadoraService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * By @author falvojr
 */


@RestController
@RequestMapping("/doadores")
public class PessoaDoadoraController {

	@Autowired
	private PessoaDoadoraService pessoaDoadoraService;

	@GetMapping
	public ResponseEntity<Iterable<PessoaDoadora>> buscarTodos() {
		return ResponseEntity.ok(pessoaDoadoraService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDoadora> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaDoadoraService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<PessoaDoadora> inserir(@RequestBody PessoaDoadora pessoaDoadora) {
		pessoaDoadoraService.inserir(pessoaDoadora);
		return ResponseEntity.ok(pessoaDoadora);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDoadora> atualizar(@PathVariable Long id, @RequestBody PessoaDoadora pessoaDoadora) {
		pessoaDoadoraService.atualizar(id, pessoaDoadora);
		return ResponseEntity.ok(pessoaDoadora);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		pessoaDoadoraService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
