package com.aem.training.core.services.Impl;

import com.aem.training.core.pojo.Blog;
import com.aem.training.core.services.BlogApi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component(name = "Blog Collector", service = BlogsCollectorImpl.class)
public class BlogsCollectorImpl {

    Logger logger  = LoggerFactory.getLogger(this.getClass());
    List<Blog> blogList = new ArrayList<Blog>();

    @Reference(target = "(version=1.0)")
    private BlogApi techBlog;

    @Reference(target = "(version=2.0)")
    private BlogApi marketBlog;

    @Activate
    public void activate(){
        logger.info("Inside Blog Collector");
        collectBlogs();
        getBlogsByRank();
    }

    public void collectBlogs(){
        logger.info("=== START : MARKET BLOG ===");
        blogList.add(new Blog(marketBlog.getRank(), marketBlog.getBlogCategory())); // Adding Market blog to blogList
        logger.info("Category: " + marketBlog.getBlogCategory());
        logger.info("Rank: " + marketBlog.getRank());
        logger.info("=== END : MARKET BLOG ===");

        logger.info("=== START : TECH BLOG ===");
        blogList.add(new Blog(techBlog.getRank(), techBlog.getBlogCategory())); // Adding Tech Blog to blogList
        logger.info("Category: " + techBlog.getBlogCategory());
        logger.info("Rank: " + techBlog.getRank());
        logger.info("=== END : TECH BLOG ===");
    }

    // Method for sorting blogs based on their rank and then returning the sorted list of blogs
    public List<Blog> getBlogsByRank(){
        Collections.sort(blogList, (b1, b2) -> {
                if(b1.getRank() > b2.getRank())
                    return 1;
                else if(b1.getRank() < b2.getRank())
                    return -1;
                else{
                    return b1.getBlogCategory().compareToIgnoreCase(b2.getBlogCategory());
                }
        });
        logger.info("Sorted list of blogs: ");
        for (Blog blog : blogList) {
            logger.info(blog.toString());
        }
        logger.info("..........");

        return blogList;

    }

}
