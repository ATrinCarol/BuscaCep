package one.digitalinnovation.gof.service.implementacao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.model.PessoaDoadora;
import one.digitalinnovation.gof.model.PessoaDoadoraRepository;
import one.digitalinnovation.gof.service.PessoaDoadoraService;
import one.digitalinnovation.gof.service.ViaCepService;

@Service
public class PessoaDoadoraImpl implements PessoaDoadoraService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private PessoaDoadoraRepository pessoaDoadoraRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos nas interfaces.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<PessoaDoadora> buscarTodos() {
		return pessoaDoadoraRepository.findAll();
	}

	@Override
	public PessoaDoadora buscarPorId(Long id) {
		Optional<PessoaDoadora> doadora = pessoaDoadoraRepository.findById(id);
		return doadora.get();
	}

	@Override
	public void inserir(PessoaDoadora pessoaDoadora) {
		salvarClienteComCep(pessoaDoadora);
	}

	@Override
	public void atualizar(Long id, PessoaDoadora pessoaDoadora) {
		Optional<PessoaDoadora> doadoraDb = pessoaDoadoraRepository.findById(id);
		if (doadoraDb.isPresent()) {
			salvarClienteComCep(pessoaDoadora);
		}
	}

	@Override
	public void deletar(Long id) {
		pessoaDoadoraRepository.deleteById(id);
	}

	private void salvarClienteComCep(PessoaDoadora pessoaDoadora) {
		String cep = pessoaDoadora.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		pessoaDoadora.setEndereco(endereco);
		pessoaDoadoraRepository.save(pessoaDoadora);
	}

}