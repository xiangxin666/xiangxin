import com.ace.trade.common.exception.AceMQException;
import com.ace.trade.common.rocketmq.AceMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/***
 * xiangx
 * 20180812
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/spring-rocketmq-producer.xml")
public class ProducerTest {
    @Autowired
    private AceMQProducer aceMQProducer;
    @Test
    public void testProducer() throws AceMQException {
       SendResult sendResult= this.aceMQProducer.sendMessage("TestTopic0812","order","12345678","this is an order message");
         System.out.print(sendResult);
    }


}
