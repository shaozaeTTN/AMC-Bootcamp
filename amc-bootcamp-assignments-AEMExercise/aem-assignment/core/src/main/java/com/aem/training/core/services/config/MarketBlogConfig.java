package com.aem.training.core.services.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

// Configurations for Market Blog
@ObjectClassDefinition(name = "Market Blog Configurations")
public @interface MarketBlogConfig {

    @AttributeDefinition(name = "Blog Category", type = AttributeType.STRING)
    String blogCategory() default "Marketing";

    @AttributeDefinition(name = "Blog Rank", type = AttributeType.INTEGER)
    int rank() default 2;

}
