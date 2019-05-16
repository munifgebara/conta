/* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
/* Para não gerar o arquivo novamente coloque na primeira linha um comentário com  VICIGNORE , pode ser essa mesmo */
package br.com.munif.openprojects.conta.api;

import br.com.munif.framework.vicente.api.BaseAPI;
import br.com.munif.framework.vicente.application.BaseService;
import br.com.munif.openprojects.conta.domain.localizacao.Conta;
import br.com.munif.openprojects.conta.domain.localizacao.Pais;
import br.com.munif.openprojects.conta.service.ContaService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GeradorVicente
 */
@RestController
@RequestMapping("/api/conta")
public class ContaApi extends BaseAPI<Conta> {

    private final Logger log = Logger.getLogger(ContaApi.class);

    private static final String ENTITY_NAME = "conta";
    
    private ContaService contaService;

    public ContaApi(BaseService<Conta> service) {
        super(service);
        this.contaService=(ContaService) service;
    }
     @Transactional
    @RequestMapping(value = {"/transfere/{ido}/{idd}/{val}"}, method = {RequestMethod.GET})
    public Boolean transfere(@PathVariable String ido, @PathVariable String idd, @PathVariable BigDecimal val) {
         System.out.println(ido+" "+idd+" "+val);
         return contaService.transfere(ido, idd, val);

    }

}
