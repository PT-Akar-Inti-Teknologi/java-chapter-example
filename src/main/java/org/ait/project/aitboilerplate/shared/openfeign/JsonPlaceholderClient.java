package org.ait.project.aitboilerplate.shared.openfeign;


import org.ait.project.aitboilerplate.shared.openfeign.response.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "jplaceholder",url = "${openfeign.url.jplaceholder}")
public interface JsonPlaceholderClient {

    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping(value = "/posts/{postId}")
    Post getPostById(@PathVariable("postId") Long postId);
}
