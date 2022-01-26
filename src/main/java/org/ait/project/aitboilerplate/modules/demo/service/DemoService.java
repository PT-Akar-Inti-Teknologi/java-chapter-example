package org.ait.project.aitboilerplate.modules.demo.service;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.ait.project.aitboilerplate.shared.openfeign.JsonPlaceholderClient;
import org.ait.project.aitboilerplate.shared.openfeign.response.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public ResponseEntity<ResponseTemplate<List<Post>>> getPosts() {
        return ResponseEntity.ok(new ResponseTemplate<>("000","success",jsonPlaceholderClient.getPosts()));
    }

    public ResponseEntity<ResponseTemplate<Post>> getPostById(Long postId) {
        return ResponseEntity.ok(new ResponseTemplate<>("000","success",jsonPlaceholderClient.getPostById(postId)));
    }
}
