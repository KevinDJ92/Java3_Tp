package com.managedBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

public class ProducerMsg {
      @Resource(mappedName = "jms/messagequeue")
	private Queue messageQueue;
    
        @Resource(mappedName = "jms/messagePoolFactory")
        private ConnectionFactory messagePoolFactory;
    
    private Message createJMSMessageForjmsMessageQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToMessageQueue(Object messageData) throws JMSException, NamingException {
        Connection conn = null;
        Session s = null;
        try {
            conn = messagePoolFactory.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            MessageProducer mp = s.createProducer(messageQueue);
            mp.send(createJMSMessageForjmsMessageQueue(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }   
}
