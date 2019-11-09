package com.sdanilin.conf;

import com.sdanilin.resourse.BaseServlet;
import org.apache.log4j.Logger;
import org.jboss.resteasy.cdi.ResteasyCdiExtension;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/app")
public class AppConfig extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    @Inject
    private ResteasyCdiExtension extension;

    @Inject
    private Logger logger;

    @SuppressWarnings("unchecked")
    public Set<Class<?>> getClasses() {
        logger.info("App start working");
        final Set<Class<?>> result = new HashSet<>();
        result.add(BaseServlet.class);
        result.addAll((Collection<? extends Class<?>>) (Object)extension.getResources());

        return result;
    }
}