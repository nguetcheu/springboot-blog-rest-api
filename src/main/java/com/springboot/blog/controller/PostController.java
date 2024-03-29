package com.springboot.blog.controller;

import com.springboot.blog.dtos.PostDto;
import com.springboot.blog.dtos.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public PostResponse getAllPosts(
            // paramétre de trie avec api obtention de post http://localhost:9000/api/posts?sortBy=title&pageSize=10&pageNo?=0&sortDir=asc
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable("id") Long postId){
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable("id") Long postId){
        PostDto postResponse = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId){

        postService.deletePostById(postId);

        return new ResponseEntity<>("Post entity deleted successfully",HttpStatus.OK);
    }

    // create the post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
