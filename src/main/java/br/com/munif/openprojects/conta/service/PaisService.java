/* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
/* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
/* Para não gerar o arquivo novamente coloque na primeira linha um comentário com  VICIGNORE , pode ser essa mesmo */
package br.com.munif.openprojects.conta.service;

import br.com.munif.framework.vicente.application.BaseService;
import br.com.munif.framework.vicente.application.VicRepository;
import br.com.munif.openprojects.conta.domain.localizacao.Pais;
import org.springframework.stereotype.Service;

/**
 *
 * @author GeradorVicente
 */
@Service
public class PaisService extends BaseService<Pais>{
    
    public PaisService(VicRepository<Pais> repository) {
        super(repository);
    }
    
}
