package com.aem.training.core.services.Impl;

import com.aem.training.core.services.BlogApi;
import com.aem.training.core.services.config.MarketBlogConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(name = "Market Blog", service = BlogApi.class, property = {"version=2.0"})
@Designate(ocd = MarketBlogConfig.class)
public class MarketBlogImpl implements BlogApi {
        Logger logger  = LoggerFactory.getLogger(this.getClass());

        private MarketBlogConfig marketBlogConfig;

        @Activate
        public void activate(MarketBlogConfig marketBlogConfig){
            logger.info("..........");
            logger.info("MarketBlog started");
            this.marketBlogConfig = marketBlogConfig;
        }

        public String getBlogCategory() {
            return marketBlogConfig.blogCategory();
        }

        public Integer getRank() {
            return marketBlogConfig.rank();
        }
    }
