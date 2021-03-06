package org.revo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("org.revo.repository")
public class RepositoryConfiguration extends Neo4jConfiguration {

    private final String storeDirectory = "/home/ashraf/prog/neo4j-community-2.1.8/data/graph.db";

    public RepositoryConfiguration() {
        setBasePackage("org.revo.domain");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase(storeDirectory);
    }

}
