package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public List<Message> getAllMessages(){
        return repository.findAll();
    }

    public void addMessage(String name, String text){
        repository.save(new Message(name,text));
    }

    public void editMessage(String name, String text, Integer id) {
        Message message = repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        message.setName(name);
        message.setText(text);
        repository.save(message);
    }

    public void deleteMessage(String name, String text){
        List<Message> messages = repository.findAll();
        for (Message message : messages){
            if (message.getName().equals(name) && message.getText().equals(text)){
                repository.delete(message);
                break;
       } 
    }

    
    
}

    public void deleteMessage(Integer id) {
        repository.deleteById(id);
    }

public Message getMessageById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
}


}