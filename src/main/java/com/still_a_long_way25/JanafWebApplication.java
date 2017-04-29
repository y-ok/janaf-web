package com.still_a_long_way25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class JanafWebApplication {

	/**
	 * エントリーポイント
	 * @param args なし
	 */
	public static void main(String[] args) {
		SpringApplication.run(JanafWebApplication.class, args);
	}
}
