package com.ttn.bootcamp.Services.Implementation;

import com.ttn.bootcamp.configurations.MarketBlogConfig;
import com.ttn.bootcamp.Services.BlogApi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = BlogApi.class, property = {"version=2.0"})
@Designate(ocd = MarketBlogConfig.class)
public class MarketBlog implements BlogApi {
    Logger logger  = LoggerFactory.getLogger(this.getClass());

    private MarketBlogConfig marketBlogConfig;

    @Activate
    public void activate(MarketBlogConfig marketBlogConfig){
        logger.info("MarketBlog started");
        this.marketBlogConfig = marketBlogConfig;
    }

    public String getBlogCategory() {
        return marketBlogConfig.bundleCategory();
    }

    public Integer getRank() {
        return marketBlogConfig.rank();
    }
}
