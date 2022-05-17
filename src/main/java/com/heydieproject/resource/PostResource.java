package com.heydieproject.resource;

import com.heydieproject.entity.Post;
import com.heydieproject.service.PostService;
import org.springframework.http.ResponseEntity;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    PostService postService;

    @GET
    public Response get() {
        return postService.getAllPosts();
    }

    @POST
    public ResponseEntity<Post> create(Post post) {
        ResponseEntity<Post> response = postService.create(post);
        return ResponseEntity.ok(response.getBody());
    }

    @PUT
    @Path("/{id}")
    public ResponseEntity<Post> update(@PathParam("id") Long id, Post post) {
        ResponseEntity<Post> response = postService.update(id, post);
        return ResponseEntity.ok(response.getBody());
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id) {
        postService.delete(id);
        return "Deleted Succesfully";
    }
}
