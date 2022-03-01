package org.ait.project.aitboilerplate.shared.openfeign;


import org.ait.project.aitboilerplate.shared.openfeign.request.PostRequest;
import org.ait.project.aitboilerplate.shared.openfeign.response.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.util.List;

@FeignClient(value = "jplaceholder",url = "${openfeign.url.jplaceholder}")
public interface JsonPlaceholderClient {

    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping("/posts/{postId}")
    Post getPostById(@PathVariable("postId") Long postId);

    @PostMapping("/posts")
    Post getPostById(@RequestBody PostRequest postRequest);
}
