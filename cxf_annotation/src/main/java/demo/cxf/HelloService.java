package demo.cxf;

import javax.jws.WebService;
import org.apache.cxf.annotations.Logging;
//import org.apache.cxf.feature.Features;
//import org.apache.cxf.feature.LoggingFeature;
//import org.apache.cxf.interceptor.InInterceptors;
//import org.apache.cxf.interceptor.LoggingInInterceptor;
//import org.apache.cxf.interceptor.LoggingOutInterceptor;
//import org.apache.cxf.interceptor.OutInterceptors;

@WebService
//@InInterceptors(interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor"})
//@OutInterceptors(interceptors = {"org.apache.cxf.interceptor.LoggingOutInterceptor"})
//@InInterceptors(classes = {LoggingInInterceptor.class})
//@OutInterceptors(classes = {LoggingOutInterceptor.class})
//@Features(classes = {LoggingFeature.class})
@Logging
public interface HelloService {

    String say(String name);
}
