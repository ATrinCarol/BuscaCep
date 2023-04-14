package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.PessoaDoadora;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * By @author falvojr
 */

public interface PessoaDoadoraService {
	
	Iterable<PessoaDoadora> buscarTodas();
	
	PessoaDoadora buscarPorId(Long id);
	
	void inserir(PessoaDoadora pessoaDoadora);
	
	void atualizar(Long id, PessoaDoadora pessoaDoadora);
	
	void deletar(Long id);

}
