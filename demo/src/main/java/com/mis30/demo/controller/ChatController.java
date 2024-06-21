package com.mis30.demo.controller;

import com.mis30.demo.domain.Chat;
import com.mis30.demo.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping
    public List<Chat> getchats() {
        Pageable pageable = PageRequest.of(0, 50, Sort.by(Sort.Direction.DESC, "id"));
        return chatRepository.findAll(pageable).getContent();
    }

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable Long id, @RequestBody Chat chatDetails) {
        Chat chat = chatRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat not found"));
        chat.setMsg(chatDetails.getMsg());
        return chatRepository.save(chat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Long id) {
        chatRepository.deleteById(id);
    }
}