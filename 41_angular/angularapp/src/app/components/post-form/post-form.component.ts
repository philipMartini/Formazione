import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

import { Post } from '../../models/post';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {

 

  @Output() newPost: EventEmitter<Post> = new EventEmitter();

  @Output() updatedPost: EventEmitter<Post> = new EventEmitter();

  @Input() currentPost: Post;

  @Input() isEdit: boolean;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
  }

  addPost(title: string, body: string){
    if(!title || !body){
      alert('Please add post!');
    }else{
      this.postService.savePost({title, body} as Post).subscribe(
        post => { 
          
          this.newPost.emit(post);
        
        }
      );
    }
  }

  updatePost() {

    console.log("Updating Post");
    this.postService.updatePost(this.currentPost).subscribe(post => {
      console.log(post);
      this.isEdit = false;
      this.updatedPost.emit(post);
     });
  }

}
