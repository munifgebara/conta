/* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
/* Para não gerar o arquivo novamente coloque na primeira linha um comentário com  VICIGNORE , pode ser essa mesmo */
package br.com.munif.openprojects.conta.api;

import br.com.munif.framework.vicente.api.BaseAPI;
import br.com.munif.framework.vicente.application.BaseService;
import br.com.munif.openprojects.conta.domain.localizacao.Pais;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

/**
 *
 * @author GeradorVicente
 */
@RestController
@RequestMapping("/api/pais")
public class PaisApi extends BaseAPI<Pais> {

    private final Logger log = Logger.getLogger(PaisApi.class);

    private static final String ENTITY_NAME = "pais";

    public PaisApi(BaseService<Pais> service) {
        super(service);
    }
    

}
