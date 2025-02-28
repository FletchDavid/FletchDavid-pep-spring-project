package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Message postMessage(Message message){
        if(message.getMessageText().length() <= 255 && message.getMessageText() != ""){
            if(accountRepository.findById(message.getPostedBy()).isPresent()) 
                return messageRepository.save(message);
        }
        return null;
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public Message getMessageById(int id){
        return messageRepository.findById(id).orElse(null);
    }

    public Integer deleteMessageById(int id){
        Optional<Message> toDelete = messageRepository.findById(id);
        if(toDelete.isPresent()){ 
            messageRepository.deleteById(id);
            return 1;
        }
        else return null;
    }

    public int updateMessageById(int id, Message message){
        Optional<Message> updated = messageRepository.findById(id);
        if(updated.isPresent() && message.getMessageText() != "" && message.getMessageText().length() <= 255 ){
            updated.get().setMessageText(message.getMessageText());
            messageRepository.save(updated.get());
            return 1;
        }
        return 0;
    }

    public List<Message> getUserMessages(int id){
        return messageRepository.findByPostedBy(id);
    }
}
