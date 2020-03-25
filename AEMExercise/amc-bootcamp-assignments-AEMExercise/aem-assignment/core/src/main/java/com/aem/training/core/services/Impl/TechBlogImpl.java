package com.aem.training.core.services.Impl;

import com.aem.training.core.services.BlogApi;
import com.aem.training.core.services.config.TechBlogConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(name = "Tech Blog", service = BlogApi.class, property = {"version=1.0"})
@Designate(ocd = TechBlogConfig.class)
public class TechBlogImpl implements BlogApi {
    Logger logger  = LoggerFactory.getLogger(this.getClass());

    private TechBlogConfig techBlogConfig;

    @Activate
    public void activate(TechBlogConfig techBlogConfig){
        logger.info("TechBlog started");
        this.techBlogConfig = techBlogConfig;
    }

    public String getBlogCategory() {
        return techBlogConfig.blogCategory();
    }

    public Integer getRank() {
        return techBlogConfig.rank();
    }
}
