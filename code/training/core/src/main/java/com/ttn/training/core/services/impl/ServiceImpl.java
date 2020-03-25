package com.ttn.training.core.services.impl;

import com.ttn.training.core.config.MarketBlogConfig;
import com.ttn.training.core.services.Service;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = Service.class)
@Designate(ocd = MarketBlogConfig.class)
public class ServiceImpl implements Service {

    @Activate
    private MarketBlogConfig marketBlogConfig;
}
