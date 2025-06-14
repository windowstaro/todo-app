package com.example.message.controller;

import com.example.message.service.MessageService;
import com.example.message.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addMessage((name), text);
        }
        
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
    Message message = service.getMessageById(id);
    model.addAttribute("message", message);
    return "edit";
}
    @PostMapping("/edit")
    public String put(@RequestParam Integer id,
                   @RequestParam String name,
                   @RequestParam String text,
                   Model model) {
    service.editMessage(name, text, id);
    List<Message> messages = service.getAllMessages();
    model.addAttribute("messages", messages);
    return "index";
}
    
   @PostMapping("/delete")//削除機能
    public String delete(@RequestParam String name,
                        @RequestParam String text,
                        Model model) {
        service.deleteMessage(name, text);

        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }
}
