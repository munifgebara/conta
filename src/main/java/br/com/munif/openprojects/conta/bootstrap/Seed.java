package br.com.munif.openprojects.conta.bootstrap;

import br.com.munif.framework.vicente.core.RightsHelper;
import br.com.munif.framework.vicente.core.VicThreadScope;
import br.com.munif.framework.vicente.domain.BaseEntity;
import br.com.munif.framework.vicente.security.seed.SeedSecurity;
import br.com.munif.openprojects.conta.domain.localizacao.Conta;
import br.com.munif.openprojects.conta.domain.localizacao.Pais;
import br.com.munif.openprojects.conta.repository.ContaRepository;
import br.com.munif.openprojects.conta.repository.PaisRepository;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Seed implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = Logger.getLogger(Seed.class);

    @Autowired
    private SeedSecurity seedSecurity;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        VicThreadScope.gi.set("SEED");
        VicThreadScope.ui.set("SEED");
        VicThreadScope.oi.set("SEED.");
        VicThreadScope.ip.set("127.0.0.1");
        VicThreadScope.defaultRights.set(RightsHelper.OWNER_ALL + RightsHelper.GROUP_READ_UPDATE + RightsHelper.OTHER_READ);
        log.info("Start");
        if (paisRepository.count() > 0) {
            return;
        }
        seedSecurity.seedSecurity();
        seedLocalizacao();
    }

    public void seedLocalizacao() {
      
        if (paisRepository.count() > 0) {
            return;
        }
        log.info("Inserting data");

        String[] paises = DadosEstaticos.paises;
        for (String p : paises) {
            paisRepository.saveAndFlush(new Pais(p.trim()));
        }

        for (int i = 100; i < 200; i++) {
            contaRepository.saveAndFlush(new Conta("conta " + i));
        }

    }

}
