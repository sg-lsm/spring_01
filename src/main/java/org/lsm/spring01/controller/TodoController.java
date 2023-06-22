package org.lsm.spring01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

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
    public String postRegister(@Valid TodoDTO dto, RedirectAttributes redirectAttributes, BindingResult result){
        log.info("register here... POST");
        log.info(dto);
        if(result.hasErrors()){
            log.info("has errors...");
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "/todo/regist";
        }

        log.info(dto);

        service.register(dto);

        return "redirect:/todo/list";
    }

}
