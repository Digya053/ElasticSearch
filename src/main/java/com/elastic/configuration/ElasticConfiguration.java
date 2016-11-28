package com.elastic.configuration;


import java.net.InetSocketAddress;
import javax.annotation.Resource;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * This is the configuration to be set for running elastic search in this application
 * @author digya
 *
 */

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "com.elastic.repositories")
public class ElasticConfiguration {
	
	@Resource
	private Environment environment;
	
	@Bean
	public Client client(){
		
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "mycluster").build();


		TransportClient client = new TransportClient(settings);
		
		String host = environment.getProperty("elasticsearch.host");
		String port = environment.getProperty("elasticsearch.port");
		
		System.out.println("==============================" + host + port);

		TransportAddress address = new InetSocketTransportAddress(
					new InetSocketAddress(host, Integer.parseInt(port))
				);

		//client = client.addTransportAddress(address);        
		client.addTransportAddress(new InetSocketTransportAddress(host, 
				Integer.parseInt(port)));
		return client;
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
     }
}
		
		
		 
		 

