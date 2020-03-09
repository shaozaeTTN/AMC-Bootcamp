package com.ttn.bootcamp.Services.Implementation;

import com.ttn.bootcamp.Services.BlogApi;
import com.ttn.bootcamp.Services.BlogsCollector;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = BlogsCollector.class)
public class BlogsCollectorImpl implements BlogsCollector {

    Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Reference(target = "(version=2.0)")
    BlogApi techBlog;

    @Reference(target = "(version=1.0)")
    BlogApi marketBlog;

    @Activate
    public void activate(){
        String cat = techBlog.getBlogCategory();
        int rank = techBlog.getRank();
        logger.info("BlogsCollector");
        logger.info("Category: " + techBlog.getBlogCategory() + " Rank: " + techBlog.getRank());
        logger.info("Category: " + marketBlog.getBlogCategory() + " Rank: " + marketBlog.getRank());
    }
}
