package grow.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class ThymeleafConfiguration {

    @Bean
    public LayoutDialect thymeleafDialect() {
        return new LayoutDialect();
    }

    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>(
                new HiddenHttpMethodFilter());
        filterRegistrationBean.setOrder(1); // Priorité haute pour que le filtre soit appliqué tôt
        return filterRegistrationBean;
    }
}
