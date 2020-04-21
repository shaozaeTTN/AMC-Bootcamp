package com.ttn;



import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Component(service= Servlet.class, immediate = true,
        property={
                "sling.servlet.resourceTypes=my/blogs",
                "sling.servlet.selectors=data",
                "sling.servlet.extensions=json",
                "sling.servlet.methods=GET"
        })
public class SlingServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(final SlingHttpServletRequest request,
                         final SlingHttpServletResponse response) throws ServletException,
            IOException {
        String resourcePath = "/content/my-blogs";
        PrintWriter out=response.getWriter();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource=resourceResolver.getResource(resourcePath);

        String title = " ";
        String date = "";

       Iterable<Resource> iterable=resource.getChildren();
        List<Blogs> blogsList= new ArrayList<Blogs>();
        for (Resource children : iterable)
       {

           Node node=children.adaptTo(Node.class);
           try {
               title = node.getProperty("title").getValue().toString();
               date = node.getProperty("date").getValue().toString();
           } catch (RepositoryException e) {
               e.printStackTrace();
           }
           blogsList.add(new Blogs(title,date));

       }
        out.println("Ascending.....");
        Collections.sort(blogsList, new Comparator<Blogs>(){
            public int compare(Blogs o1, Blogs o2) {
                return  o1.getDate().compareTo(o2.getDate());
            }
        });
        out.println(blogsList);


        Collections.sort(blogsList, new Comparator<Blogs>(){
            public int compare(Blogs o1, Blogs o2) {
                return  -o1.getDate().compareTo(o2.getDate());
            }
        });

        out.println("\nDescending..");
        out.println(blogsList);







    }
}
