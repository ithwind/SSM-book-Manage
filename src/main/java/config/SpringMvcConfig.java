package config;


import interceptor.ResourcesInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@PropertySource("classpath:ignoreUrl.properties")
@ComponentScan({"controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ResourcesInterceptor());
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp("/admin/",".jsp");
    }

}




