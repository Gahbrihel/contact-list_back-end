package br.gov.sp.fatec.itu.contact.controllers;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todos os endpoints ("/**")
            .allowedOrigins("https://main.d6o0k6zsfzjj2.amplifyapp.com:4200") // Permite requisições da sua aplicação Angular
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Libera os métodos HTTP necessários
            .allowedHeaders("*") // Libera todos os cabeçalhos
            .allowCredentials(true);
    }
}
