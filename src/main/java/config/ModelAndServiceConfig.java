package config;

import model.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AuthService;
import service.LoginService;
import service.RegistService;

@Configuration
public class ModelAndServiceConfig {

    private DBConfig dbConfig = new DBConfig();
    private DataSource dataSource = dbConfig.dataSource();

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource);
    }

    @Bean
    public RegistService registService() {
        return new RegistService(memberDao());
    }

    @Bean
    public LoginService loginService() {
        return new LoginService(memberDao());
    }

    @Bean
    public AuthService authService() {
        return new AuthService(memberDao());
    }
}
