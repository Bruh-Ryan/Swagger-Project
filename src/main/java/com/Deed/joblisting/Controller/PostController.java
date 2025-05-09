package com.Deed.joblisting.Controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Deed.joblisting.Model.Schema;
import com.Deed.joblisting.PostRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController

public class PostController{
    @Autowired
    PostRepository repo;

     @GetMapping("/")
    public void redirectToSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/allPosts")
    
    public List<Schema> getAllPosts()
    {
        return repo.findAll();//returns all repo mongo
    }
    
    @PostMapping("/post")
    public Schema addPost(@RequestBody Schema Post)
    {
        return repo.save(Post); // sends body
    }

    @PostMapping("/post/{search_title}")
    public List<Schema> post_title(@PathVariable String search_title){
        return repo.findAll();
    }
    

    @GetMapping("/search_title")
    public List<Schema> searchPosts(@RequestParam String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }


    @GetMapping("/search_desc")
    public List<Schema> search_By_Desc(@RequestParam String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/delete")
    public List<Schema> deletePosts(@RequestParam String title) {
        List<Schema> postsToDelete = repo.findByTitleContainingIgnoreCase(title);
        for (Schema post : postsToDelete) {
          
            repo.delete(post);
        }
        return postsToDelete;
    }
    

}
