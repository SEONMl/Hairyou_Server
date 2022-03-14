package com.example.Hairyou_spring.api;

import com.example.Hairyou_spring.dto.Post;
import lombok.Getter;
import org.aspectj.weaver.ast.Literal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        List<Post> posts= new ArrayList<>();

        for(int i= 0; i <5 ; i++){
            posts.add(new Post(1,i,"타이틀","바디"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(posts);

    }
}
