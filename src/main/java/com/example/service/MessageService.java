package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message postMessage(Message message){
        //TODO: implement Service methods
        return null;
    }

    public List<Message> getAllMessages(){
        //TODO: implement Service methods
        return null;
    }

    public int deleteMessageById(int id){
        //TODO: implement Service methods
        return 0;
    }

    public int updateMessageById(int id){
        //TODO: implement Service methods
        return 0;
    }

    public List<Message> getUserMessages(int id){
        //TODO: implement Service methods
        return null;
    }
}
