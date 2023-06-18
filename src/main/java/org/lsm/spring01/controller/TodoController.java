package org.lsm.spring01.controller;

import lombok.extern.log4j.Log4j2;
import org.lsm.spring01.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list(){
        log.info("list here");
    }
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/regist")
    public void getRegister(){
        log.info("register here... GET");
    }
    @PostMapping("/regist")
    public void postRegister(TodoDTO dto){
        log.info("register here... POST");
        log.info(dto);
    }
}
