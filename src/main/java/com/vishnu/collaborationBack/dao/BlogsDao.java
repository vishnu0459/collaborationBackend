package com.vishnu.collaborationBack.dao;

import java.util.List;

import com.vishnu.collaborationBack.model.Blog;

public interface BlogsDao 
{
	
	boolean addBlog(Blog blog);
	List<Blog> getAllBlogs();
	boolean editBlog(Blog blog); //editBlog(int blogId);
	boolean deleteBlog(Blog blog);
	Blog getBlog(int blogId);
}
