package br.com.munif.openprojects.conta.test;

import br.com.munif.framework.vicente.api.errors.ExceptionTranslator;
import br.com.munif.openprojects.conta.ContaApplication;
import br.com.munif.openprojects.conta.api.ContaApi;
import br.com.munif.openprojects.conta.domain.localizacao.Conta;
import br.com.munif.openprojects.conta.service.ContaService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;

import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;

import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContaApplication.class)
public class ContaApplicationTests {

    @Autowired
    private ContaService contaService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restMockMvc;

    public void contextLoads() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ContaApi contaApi = new ContaApi(contaService);
        this.restMockMvc = MockMvcBuilders.standaloneSetup(contaApi)
                .setControllerAdvice(exceptionTranslator)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Test
    public void hello() throws Exception {
        assert (true);
    }

    @Test
    public void getAll() throws Exception {

        restMockMvc.perform(get("/api/conta?sort=id,desc"))
                .andExpect(status().isOk());

    }

    @Test
    public void tranfers() throws Exception {
        List<Conta> contas = contaService.findAll();
        Conta origem=contas.get(0);
        Conta destino=contas.get(1);
        System.out.println("---->" + contas);

        restMockMvc.perform(get("/api/conta/transfere/"+origem.getId()+"/"+destino.getId()+"/1"))
                .andExpect(status().isOk());

    }

}


//sudo docker run --name mysql -e MYSQL_ROOT_PASSWORD=senha -d -p 3306:3306 mysql:5.5
