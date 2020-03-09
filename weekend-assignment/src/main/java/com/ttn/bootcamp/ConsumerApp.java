package com.ttn.bootcamp;

import com.ttn.bootcamp.Services.BlogsCollector;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class ConsumerApp {

    @Reference
    BlogsCollector blogsCollector;
}
