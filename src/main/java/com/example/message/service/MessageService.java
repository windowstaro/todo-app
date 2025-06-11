package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;
import org.springframework.stereotype.Service;

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




































  public void deleteMessage(String name, String text){
        List<Message> messages = repository.findAll(); //findAll() で全件取得
        for (Message message : messages) {
            if (message.getName().equals(name) && message.getText().equals(text)) {
                repository.delete(message); //条件一致した Message を1件だけ削除
                break; // 最初に一致した1件だけ削除
            }
        }
    }  
}