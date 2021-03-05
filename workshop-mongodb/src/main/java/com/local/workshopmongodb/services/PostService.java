package com.local.workshopmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.workshopmongodb.domain.Post;
import com.local.workshopmongodb.repository.PostRepository;
import com.local.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id){
		Optional<Post> post = postRepository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}		
		return post.get();
	}
	
}