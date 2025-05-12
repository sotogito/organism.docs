```java
@Configuration
@MapperScan("com.example.mapper")
public class MyBatisConfig {

  @Bean
  public DataSource dataSource() {
    HikariDataSource ds = new HikariDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setJdbcUrl("jdbc:mysql://localhost:3306/menudb");
    ds.setUsername("sotogito");
    ds.setPassword("sotogito");
    return ds;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
    factoryBean.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
    return factoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}

```