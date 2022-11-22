package com.mongo.workshopmongo.services;

import com.mongo.workshopmongo.domain.Post;
import com.mongo.workshopmongo.repositories.PostRepository;
import com.mongo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}