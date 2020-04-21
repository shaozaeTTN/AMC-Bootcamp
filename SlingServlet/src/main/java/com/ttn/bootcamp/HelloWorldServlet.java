package com.ttn.bootcamp;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@Component(service = Servlet.class,
        property = {
                "sling.servlet.extensions=html",
                "sling.servlet.selectors=foo",
                "sling.servlet.paths=/bin/foo",
                "sling.servlet.methods=get",
                "sling.servlet.resourceTypes=nt:file",
                "sling.servlet.resourceTypes=project/components/component"
        }
)

public class HelloWorldServlet extends SlingSafeMethodsServlet {
    private final Logger log = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws ServletException,
            IOException {
        PrintWriter out=response.getWriter();
        out.write("Hello World!");

        log.info("Hello World");
    }
}
