package org.ait.project.aitboilerplate.shared.openfeign;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.ait.project.aitboilerplate.shared.openfeign.request.PostRequest;
import org.ait.project.aitboilerplate.shared.openfeign.response.Post;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * unit test for {@link JsonPlaceholderClient}.
 *
 * @author AIT Java Collective
 *
 */
@ExtendWith(MockitoExtension.class)
public class JsonPlaceholderClientTest {

  // module mocks ======================
  @Mock
  private JsonPlaceholderClient jsonPlaceholderClient;
  
  // utilities =========================
  private EasyRandom easyRandom = new EasyRandom();
     
  @Test
  void testGetPosts_positive() {
  
	// control variables==============
    List<Post> expected = easyRandom.objects(Post.class, easyRandom.nextInt(10))
                                    .collect(Collectors.toList());
    // behavior to check =============
    when(jsonPlaceholderClient.getPosts()).thenReturn(expected);

    // execution =====================
    List<Post> actual = jsonPlaceholderClient.getPosts();
    
    // assertions ====================
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++) {
      Post expectedObject = expected.get(i);
      Post actualObject = actual.get(i);
      assertEquals(expectedObject.getId(), actualObject.getId());
      assertEquals(expectedObject.getTitle(), actualObject.getTitle());
      assertEquals(expectedObject.getBody(), actualObject.getBody());
      assertEquals(expectedObject.getUserId(), actualObject.getUserId());
    }
  }
     
  @Test
  void testGetPosts_negative_empty_list() {
    // control variables==============
    List<Post> expected = Collections.emptyList();
  
    // behavior to check =============
    when(jsonPlaceholderClient.getPosts()).thenReturn(Collections.emptyList());

    // execution =====================       
    List<Post> actual = jsonPlaceholderClient.getPosts();
    
    // assertions ====================
    assertEquals(expected.size(), actual.size());
    assertEquals(expected.isEmpty(), actual.isEmpty());
  }
     
  @Test
  void testGetPostById_positive() {
    // control variables =============
    Post expected = easyRandom.nextObject(Post.class);

    // behavior to check =============
    when(jsonPlaceholderClient.getPostById(expected.getId())).thenReturn(expected);
    
    // execution =====================
    Post actual = jsonPlaceholderClient.getPostById(expected.getId());
    
    // assertions ====================
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getTitle(), actual.getTitle());
    assertEquals(expected.getBody(), actual.getBody());
    assertEquals(expected.getUserId(), actual.getUserId());
  }
     
  @Test
  void testGetPostById_negative_post_not_found() {
	
    // behavior to check =============
    when(jsonPlaceholderClient.getPostById(anyLong())).thenReturn(null);
 	
    // execution =====================
    Post actual = jsonPlaceholderClient.getPostById(anyLong());
    
 	// assertions ====================
    assertNull(actual);
  }
     
  @Test
  void testGetPostById_requestbody_positive() {
	// control variables =============
	Post expected = easyRandom.nextObject(Post.class);
    PostRequest request = new PostRequest();
    request.setId(expected.getId());
           
 	// behavior to check =============
    when(jsonPlaceholderClient.getPostById(request)).thenReturn(expected);
           
 	// execution =====================
    Post actual = jsonPlaceholderClient.getPostById(request);
    
    // assertions ====================
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getTitle(), actual.getTitle());
    assertEquals(expected.getBody(), actual.getBody());
    assertEquals(expected.getUserId(), actual.getUserId());
  }
     
  @Test
  void testGetPostById_requestbody_negative_post_not_found() {
	// control variables =============
	PostRequest request = new PostRequest();
    request.setId(easyRandom.nextLong(1, Long.MAX_VALUE));
    
 	// behavior to check =============
    when(jsonPlaceholderClient.getPostById(request)).thenReturn(null);
    
    // execution =====================
    Post actual = jsonPlaceholderClient.getPostById(request);
    
    // assertions ====================
    assertNull(actual);
  }
     
     

}
