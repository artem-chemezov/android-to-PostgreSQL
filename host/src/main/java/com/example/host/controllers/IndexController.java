package com.example.host.controllers;

import com.example.host.Client;
import com.example.host.db.Queries;
import com.google.gson.Gson;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext("file:src/main/java/com/example/host/Config.xml");
    Queries qw = new Queries((JdbcTemplate) ctx.getBean("jdbcTemplate"));

    @RequestMapping("/")
    public String home() {
        return "Its home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"id"})
    public String js(@RequestParam(value = "id") int id) {
        return "[" + new Gson().toJson(new Client(4, "Ivan", "hello")) + "]";
    }


    @RequestMapping(value = "/app.json", method = RequestMethod.GET, params = {"id"})
    public String get(@RequestParam(value = "id") int id) {
        return "[" + new Gson().toJson(qw.getData(id)) + "]";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String put(@RequestBody Client cl) {
            qw.putData(cl);
            return "[" + new Gson().toJson(cl) + "]";
    }
}
