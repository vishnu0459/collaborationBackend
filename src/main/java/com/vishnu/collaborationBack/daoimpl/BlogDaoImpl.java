package com.vishnu.collaborationBack.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.collaborationBack.dao.BlogsDao;
import com.vishnu.collaborationBack.model.Blog;

@Component
public class BlogDaoImpl implements BlogsDao
{
	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public boolean addBlog(Blog blog) {
		Session session=sessionFactory.openSession();
		
		session.save(blog);
		Transaction transaction=session.beginTransaction();
			try
			{
			transaction.commit();	
			return true;
		}
		catch (Exception e) {
			return false;
		}
		finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> list=query.list();
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		return list;
	}

	@Override
	public boolean editBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
