package in.ttn.core;

import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Component(service= Servlet.class, immediate = true,
        property={
               "sling.servlet.resourceTypes=htl/components/htl",
                "sling.servlet.selectors=data",
                "sling.servlet.extensions=json",
                "sling.servlet.methods=GET"
        })
public class SimpleServlet extends SlingSafeMethodsServlet {
        @Override
        protected void doGet(final SlingHttpServletRequest request,
                            final SlingHttpServletResponse response) throws ServletException,
                IOException {
                response.setContentType("application/json; charset=UTF-8");
                String resourcePath = "/content/my-options";
                PrintWriter out=response.getWriter();
                ResourceResolver resourceResolver = request.getResourceResolver();
                Resource res = resourceResolver.getResource(resourcePath);
                Iterable<Resource> resourceChildren=resourceResolver.getChildren(res);
                List<ValueMap> resourceList=new ArrayList<ValueMap>();
                for (Resource resourceChild:resourceChildren) {
                        ValueMap valueMap=resourceChild.getValueMap();
                        resourceList.add(valueMap);
                }


                Gson gson = new Gson();
                 String json = gson.toJson(resourceList);
                 out.write(json);
}

}
