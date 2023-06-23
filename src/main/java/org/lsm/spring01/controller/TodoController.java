package org.lsm.spring01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.service.TodoService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public void list(Model model){
        log.info("list here");
        model.addAttribute("dtoList", service.getAll());
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

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model){
        TodoDTO dto = service.getOne(tno);
        log.info(dto);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("----remove----");
        log.info("tno : " + tno);

        service.remove(tno);

        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO dto, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("bindingResult Error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", dto.getTno());
            return "redirect:/todo/modify";
        }
        log.info(dto);
        service.modify(dto);
        return "redirect:/todo/list";
    }
}
