package org.lsm.spring01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello(){
        log.info("hello...");
    }

    @GetMapping("/ex01")
    public void ex01(@RequestParam(name="name", defaultValue = "AAA") String name,
                     @RequestParam(name="age", defaultValue = "22") int age){
        log.info("ex01... GET");
        log.info("name: " + name);
        log.info("age: " + age);
    }
    @GetMapping("/ex02")
    public void ex02(LocalDate localDate){
        log.info("ex02... GET");
        log.info("dueDate: "+ localDate);
    }
    @GetMapping("/ex03")
    public void ex03(Model model){
        log.info("ex03 here...");
        model.addAttribute("message", "Hello World!");
    }
    @GetMapping("/ex04")
    public String ex04(RedirectAttributes attributes){
        attributes.addAttribute("name", "ABC");
        attributes.addFlashAttribute("result", "success");
        return "redirect:/ex05";
    }

    @GetMapping("/ex05")
    public void ex05(){}

    @GetMapping("/ex06")
    public void ex06(String p1, int p2){
        log.info("p1... " + p1);
        log.info("p2... " + p2);
    }
}
