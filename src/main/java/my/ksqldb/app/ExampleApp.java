package my.ksqldb.app;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.BasicConfigurator;

/**
 * Hello world!
 *
 */

import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.TopicInfo;

public class ExampleApp {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        BasicConfigurator.configure();
        ClientOptions options = ClientOptions.create()
                .setHost("https://pkc-l6wr6.europe-west2.gcp.confluent.cloud")
                .setPort(443)
                .setUseTls(true)
                .setUseAlpn(true)
                .setBasicAuthCredentials("AIJYXCYPJNPJXPQL", "HiVE17wVjM6vNrT7lqlAq+jwHAD+D0jcRYp4Ra2+wtEcKm0kKYBYBBGU/T989'cvcFNI");

        Client client = Client.create(options);
        //Send requests with the client by following the other examples
        List<TopicInfo> topicInfos = client.listTopics().get();
        topicInfos.forEach(System.out::println);
       
    }
}
