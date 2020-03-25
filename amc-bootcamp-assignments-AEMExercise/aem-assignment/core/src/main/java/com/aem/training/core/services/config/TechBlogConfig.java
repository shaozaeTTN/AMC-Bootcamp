package com.aem.training.core.services.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

// Configurations for Tech Blog
@ObjectClassDefinition(name = "Tech Blog Configurations")
public @interface TechBlogConfig {

    @AttributeDefinition(name = "Blog Category", type = AttributeType.STRING)
    String blogCategory() default "Technology";

    @AttributeDefinition(name = "Blog Rank", type = AttributeType.INTEGER)
    int rank() default 1;
}
