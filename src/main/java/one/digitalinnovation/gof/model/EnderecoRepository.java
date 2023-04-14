package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Em razão da implementação de CrudRepository não seria necessário a annotation @Repository, mas pra melhor leitura do código é ok inserir.

@Repository 
public interface EnderecoRepository extends CrudRepository<Endereco, Long>  {

}
