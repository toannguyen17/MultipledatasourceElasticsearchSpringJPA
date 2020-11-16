package com.example.config.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
	basePackages = "com.example.repositories.elasticsearch2",
	elasticsearchTemplateRef = "secondElasticsearchTemplate"
)
public class SecondRestClientConfig {

	@Bean
	public RestHighLevelClient secondElasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
			.connectedTo("localhost:9200")
			.build();
		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations secondElasticsearchTemplate(@Qualifier("secondElasticsearchClient") RestHighLevelClient elasticsearchClient) {
		return new ElasticsearchRestTemplate(elasticsearchClient);
	}
}

