package com.aem.training.core.servlets;

import com.aem.training.core.pojo.Blog;
import com.aem.training.core.services.Impl.BlogsCollectorImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Servlet registration
@Component(service = Servlet.class, property = {
        "sling.servlet.resourceTypes=" + "services/blogs",
        "sling.servlet.method=" + HttpConstants.METHOD_GET,
        "sling.servlet.selectors=" + "data",
        "sling.servlet.extensions=" + "json"
})
@ServiceDescription("Handles incoming GET request to fetch blogs and responds in JSON format")
public class FetchBlogDetailsServlet extends SlingSafeMethodsServlet {

    List<Blog> blogList = new ArrayList<Blog>();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Reference
    BlogsCollectorImpl blogCollector;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        blogList = blogCollector.getBlogsByRank();

        String blogsAsJson = this.gson.toJson(blogList);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(blogsAsJson);
        out.flush();

    }
}
