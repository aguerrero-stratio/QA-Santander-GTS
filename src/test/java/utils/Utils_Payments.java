package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSerializer;
import com.ibm.msg.client.jms.internal.JmsProducerImpl;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.junit.Test;
import schemas.Accounts;
import schemas.AccountsList;
import schemas.Payments;
import schemas.PaymentsList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import javax.jms.*;
import static junit.framework.TestCase.fail;


public class Utils_Payments {

    private static List<AccountsList> itemLists;
    private static List<AccountsList> itemListsFile;

    public static void compareUserAccount(String pathInput, Response jsonOutput) throws FileNotFoundException {

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Accounts json = gson.fromJson(bufferedReader, Accounts.class);

        Accounts accounts = jsonOutput.as(Accounts.class, ObjectMapperType.GSON);

        itemLists = accounts.getAccountsList();
        itemListsFile = json.getAccountsList();


        for(int i = 0; i< itemLists.size(); i++){

            AccountsList item = itemLists.get(i);
            AccountsList itemFile = itemListsFile.get(i);

            if(item.equals(itemFile)){

                System.out.println("Cuenta Nº " + i + " es correcta");

            }else{
                System.out.println("Cuenta Nº " + i + " es incorrecta");

            }

        }
    }

    public static void comparePayments(String pathInput, Response jsonOutput) throws FileNotFoundException {

        List<PaymentsList> paymentsLists;
        List<PaymentsList> paymentsListsFile;

        String path = "src/test/resources/json/" + pathInput;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Payments json = gson.fromJson(bufferedReader, Payments.class);

        Payments payments = jsonOutput.as(Payments.class, ObjectMapperType.GSON);

        paymentsLists = payments.getPaymentsList();
        paymentsListsFile = json.getPaymentsList();


        for(int i = 0; i< paymentsLists.size(); i++){

            PaymentsList item = paymentsLists.get(i);
            PaymentsList itemFile = paymentsListsFile.get(i);

            if(item.equals(itemFile)){
                System.out.println("Payment Nº " + i + " es correcta");
            }else{
                fail("Payment Nº " + i + " es incorrecta");
            }

        }
    }

    @Test
    public void generateMT103() throws JMSException {

        String str108 = null;
        String str121_1 = null;
        String baseMT103 = null;
        int numMT103 = 2;

        for (int i = 0; i <=numMT103;i++){

            str108 = RandomString.getAlphaNumericString(15);
            str121_1 = RandomString.getAlphaNumericString(8);
            baseMT103 = "{1:F21BSCHESM0AXXX4744772372}{4:{177:1910041138}{451:1}{405:H51}{108:E" + str108 + "}}{1:F01BSCHESM0AXXX4744772372}{2:I103BBVAESMMXXXXN}{3:{103:EBA}{113:NNNN}{108:E" + str108 +"}{111:001}{121:" + str121_1 + "-ac3c-462a-bd47-8a7ec5194b62}}{4:\n" +
                    ":20:0075185601006235\n" +
                    ":23B:CRED\n" +
                    ":32A:191004EUR555,\n" +
                    ":33B:EUR555,\n" +
                    ":50K:/ES470075862235569000054\n" +
                    "MERCADONA ES\n" +
                    "ES S   B98308174\n" +
                    ":57A:BBVAESMMXXX\n" +
                    ":59:/01821234815678901234\n" +
                    "CITICB\n" +
                    "Madrid\n" +
                    "Madrid,ES\n" +
                    ":70:0061C17JSB041019\n" +
                    ":71A:SHA\n" +
                    ":72:/REC/\n" +
                    "-}{5:{CHK:0296343B8E59}{TNG:}}";

            System.out.println(baseMT103);

            producerMQ(baseMT103);

        }


    }

    public static class RandomString {

        // function to generate a random string of length n
        static String getAlphaNumericString(int n)
        {

            // chose a Character random from this String
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index
                        = (int)(AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }

            return sb.toString();
        }
    }

    public void producerMQ(String strMT103) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("stratio","stratio","tcp://40.74.50.40:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("foo.bar");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        String text = strMT103;
        TextMessage message = session.createTextMessage(text);
        producer.send(message);
        session.close();
        connection.close();
    }
    public static void main(String[] args) throws JsonProcessingException,
            InterruptedException {
        Properties props=new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class.getName());

        KafkaProducer<String, JsonNode> producer=new KafkaProducer<String, JsonNode>(props);
        String json = "{ \"f1\" : \"v1\" } ";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);
        ProducerRecord<String,JsonNode> record =new ProducerRecord<String,
                JsonNode>("test topic", jsonNode);
        record.headers().add(new RecordHeader("key","value1".getBytes()));
        producer.send(record);
        Thread.sleep(10000);
    }





}
