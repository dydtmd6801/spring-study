package config;

import model.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    private DBConfig dbConfig = new DBConfig();
    private DataSource dataSource = dbConfig.dataSource();

    public MemberDao memberDao() {
        return new MemberDao(dataSource);
    }
}
