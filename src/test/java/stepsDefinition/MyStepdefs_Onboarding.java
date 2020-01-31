package stepsDefinition;

import cucumber.api.java.en.Given;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyStepdefs_Onboarding {


    @Given("^La banca local envia el archivo \"([^\"]*)\" a la ruta NFS \"([^\"]*)\" y lo recogemos con el workflow \"([^\"]*)\"$")
    public void laBancaLocalEnviaElArchivoALaRutaNFSYLoRecogemosConElWorkflow(String arg0, String arg1, String arg2) throws Throwable {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));

        producer.close();



    }





}
