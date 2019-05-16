/* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
 /* Arquivo gerado utilizando VICGERADOR por munif as 13/03/2018 08:23:28 */
 /* Para não gerar o arquivo novamente coloque na primeira linha um comentário com  VICIGNORE , pode ser essa mesmo */
package br.com.munif.openprojects.conta.service;

import br.com.munif.framework.vicente.application.BaseService;
import br.com.munif.framework.vicente.application.VicRepository;
import br.com.munif.openprojects.conta.domain.localizacao.Conta;
import br.com.munif.openprojects.conta.domain.localizacao.Movimento;
import br.com.munif.openprojects.conta.domain.localizacao.Pais;
import br.com.munif.openprojects.conta.repository.MovimentoRepository;
import java.math.BigDecimal;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GeradorVicente
 */
@Service
public class ContaService extends BaseService<Conta> {

    @Autowired
    public MovimentoRepository movimentoRepository;

    public ContaService(VicRepository<Conta> repository) {
        super(repository);
    }

    @Transactional
    public boolean transfere(String o, String d, BigDecimal valor) {
        Conta origem=repository.getOne(o);
        Conta destino=repository.getOne(d);

        if (origem.getSaldo().compareTo(valor) > 0) {
            Date agora = new Date();
            origem.setSaldo(origem.getSaldo().subtract(valor));
            origem.setMomentoSaldo(agora);
            destino.setSaldo(destino.getSaldo().add(valor));
            destino.setMomentoSaldo(agora);
            Movimento movimento = new Movimento(origem, destino, valor);
            movimento.setMomentoMovimento(agora);
            movimentoRepository.save(movimento);
            return true;
        }

        return false;
    }

}
