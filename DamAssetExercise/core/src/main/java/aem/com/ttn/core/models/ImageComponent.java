package aem.com.ttn.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;


import java.util.List;

public class ImageComponent extends WCMUsePojo {

    private String name;


    @Override
    public void activate() throws Exception
    {
        Resource currentResource=getResource();
        ResourceResolver resourceResolver=getResourceResolver();
        ValueMap valueMap=currentResource.getValueMap();
       String assetPath=valueMap.get("path",String.class);
       String assetRendition=valueMap.get("rendition",String.class);
        Resource resource= resourceResolver.getResource(assetPath);
        if(resource!=null)
        {
            Asset asset=resource.adaptTo(Asset.class);
            if(asset!=null)
            {
                name = asset.getOriginal().getPath();
                List<Rendition> renditionList=asset.getRenditions();
                for(Rendition rendition : renditionList) {
                    if (rendition.getName().endsWith((assetRendition).concat(".png")))
                    {
                         name=rendition.getPath();
                    }

                }
            }
        }


    }

    public String getName() {
        return name;
    }
}
