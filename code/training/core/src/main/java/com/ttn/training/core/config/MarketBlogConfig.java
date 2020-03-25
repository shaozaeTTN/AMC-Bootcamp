
package com.ttn.training.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "MarketBlog Configuration",description = "Contains description about Market blog")
public @interface MarketBlogConfig
{

    @AttributeDefinition(name = "Market Blog Category",type = AttributeType.STRING)
    String Blog_Category() default "";
    @AttributeDefinition(name = " Market Rank",type = AttributeType.INTEGER)
    int Rank() default  0;
}