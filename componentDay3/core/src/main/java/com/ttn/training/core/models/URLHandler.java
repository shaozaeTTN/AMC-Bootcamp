package com.ttn.training.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Logic written with integration to 'important-links' component in components/custom

public class URLHandler extends WCMUsePojo {

    private List<HashMap<String, Object>> list;

    ResourceResolver resourceResolver;

    @Override
    public void activate() throws Exception {
        resourceResolver = getResourceResolver();
        list = new ArrayList<>();

        Resource childResource = getResource().getChild("links");
        Iterable<Resource> children = childResource.getChildren();

        for (Resource child : children) {
            ValueMap childProperties = child.getValueMap();
            HashMap<String, Object> propertyMap = new HashMap<>(childProperties);
            String link = childProperties.get("link", String.class);
            if(isLinkInternal(link))
                propertyMap.put("link", link + ".html");
            list.add(propertyMap);
        }

    }

    public boolean isLinkInternal(String link){
        return resourceResolver.getResource(link) != null;
    }

    public List<HashMap<String, Object>> getList() {
        return list;
    }
}
