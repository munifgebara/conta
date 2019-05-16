package br.com.munif.openprojects.conta.controllers;

import br.com.munif.framework.vicente.core.RightsHelper;
import br.com.munif.framework.vicente.core.UIDHelper;
import br.com.munif.framework.vicente.core.VicThreadScope;
import br.com.munif.framework.vicente.domain.util.EntitiesToSVG;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Map hello() {
        Map<String, Object> info = new HashMap<>();
        info.put("id", UIDHelper.getUID());
        info.put("gi", RightsHelper.getMainGi());
        info.put("ui", VicThreadScope.ui.get());
        info.put("oi", VicThreadScope.oi.get());

        return info;
    }

    @ResponseBody
    @RequestMapping(value = "/svg", produces = "image/svg+xml")
    public String svg() {
        return EntitiesToSVG.gera();

    }

}
