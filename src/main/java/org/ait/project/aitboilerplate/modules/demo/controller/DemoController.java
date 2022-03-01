package org.ait.project.aitboilerplate.modules.demo.controller;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.demo.service.DemoService;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.ait.project.aitboilerplate.shared.openfeign.response.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/posts")
    public ResponseEntity<ResponseTemplate<List<Post>>> getPosts() {
        return demoService.getPosts();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<ResponseTemplate<Post>> getPostById(@PathVariable Long postId) {
        return demoService.getPostById(postId);
    }
}
