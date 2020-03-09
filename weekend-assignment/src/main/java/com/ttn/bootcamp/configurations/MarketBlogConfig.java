package com.ttn.bootcamp.configurations;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Market Blog Configurations")
public @interface MarketBlogConfig {

    @AttributeDefinition(name = "Blog Category", type = AttributeType.STRING)
    String bundleCategory() default "Marketing";

    @AttributeDefinition(name = "Blog Rank", type = AttributeType.INTEGER)
    int rank() default 2;

}
