package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;

import javax.jms.*;

public class UtilsCommon {

    private static Request request = null;
    private static Response response = null;
    private static RequestSpecification httpRequest = RestAssured.given();


    public static  void  serviceIsUp (String Domain){

        String baseURI = "https://gts-kong.sgcto-int.stratio.com/onetrade"+ Domain + "/swagger-ui.html#/";

        response = httpRequest.get(baseURI);

        // Get the status code from the Response.
        // We should get a status code of 200.
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals("Correct status code returned",  200 /*expected value*/, statusCode /*actual value*/);
    }

    @Test
    public void generateMT103() throws JMSException {

        String str108 = null;
        String str121_1 = null;
        String baseMT103 = null;
        int numMT103 = 1;

        for (int i = 0; i <numMT103;i++){

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


}