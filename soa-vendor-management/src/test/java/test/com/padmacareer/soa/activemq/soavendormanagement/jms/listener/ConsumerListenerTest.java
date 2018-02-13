package test.com.padmacareer.soa.activemq.soavendormanagement.jms.listener;

import static org.junit.Assert.assertNull;

import javax.jms.TextMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.padmacareer.soa.activemq.soavendormanagement.jms.listener.ConsumerListener;

public class ConsumerListenerTest {
	private TextMessage message;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOnMessage() {
		ConsumerListener listener = new ConsumerListener();
		listener.onMessage(message);
		assertNull(message);
	}

}
