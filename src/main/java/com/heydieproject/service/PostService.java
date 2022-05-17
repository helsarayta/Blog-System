package com.heydieproject.service;

import com.heydieproject.entity.Post;
import org.springframework.http.ResponseEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostService {

    @Transactional
    public Response getAllPosts() {
        List<Post> postList = Post.listAll();

        return Response.ok(postList).build();
    }

    @Transactional
    public ResponseEntity<Post> create(Post post) {
        Post post1 = new Post();
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setTags(post.getTags());
        post1.persist();

        return ResponseEntity.ok(post1);
    }

    @Transactional
    public ResponseEntity<Post> update(Long id, Post post) {
        Post postUpdate = Post.findById(id);
        postUpdate.setTitle(post.getTitle());
        postUpdate.setContent(post.getContent());
        postUpdate.setTags(post.getTags());
        postUpdate.persist();

        return ResponseEntity.ok(postUpdate);
    }

    @Transactional
    public void delete(Long id) {
        Post post = Post.findById(id);
        post.delete();
    }

}
