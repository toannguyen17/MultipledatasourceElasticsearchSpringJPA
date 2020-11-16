package com.example.config.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
	basePackages = "com.example.repositories.elasticsearch1",
	elasticsearchTemplateRef = "firstElasticsearchTemplate"
)
public class FirstRestClientConfig {
	@Bean
	@Primary
	public RestHighLevelClient firstElasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
			.connectedTo("localhost:9200")
			.build();
		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	@Primary
	public ElasticsearchOperations firstElasticsearchTemplate(@Qualifier("firstElasticsearchClient") RestHighLevelClient elasticsearchClient) {
		return new ElasticsearchRestTemplate(elasticsearchClient);
	}
}

