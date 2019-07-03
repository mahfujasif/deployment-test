package com.practise.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

@Configuration
public class TableInitializar {
  @Bean
  @Primary
  public Object tableInitializer() throws SQLException {
    TableInitializar.sqlExecutor();
    return null;

  }

  /**
   * Generates authentication tables when project builds
   *
   * @throws SQLException
   */
  private static void sqlExecutor() throws SQLException {

    Connection connection = null;

    try {

      connection = DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1/deploytest?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8",
          "root",
          "root");

      ScriptUtils.executeSqlScript(connection,
          new ClassPathResource("scripts/initial_database_creation.sql"));

    } finally {
      connection.close();
    }
  }


}
