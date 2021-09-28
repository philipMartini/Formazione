package simpleFactory;

public class Client {

	public static void main(String[] args) {
		
		Post post1 = PostFactory.createPost("blog");
		System.out.println(post1);
		
		Post post2 = PostFactory.createPost("news");
		System.out.println(post2);
	}

}
