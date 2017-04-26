/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import DB_Entities.Log;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Conor
 */
@MessageDriven(mappedName = "jms/MessageQueue", activationConfig
        = {
            @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        })
public class LogHandler implements MessageListener {
    
    public LogHandler() {
    }
    
    @Resource
    private MessageDrivenContext mdc;
    
    @PersistenceContext(unitName = "Distributed_Systems_Project-ejbPU")
    private EntityManager em;
    
   @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
        System.out.println("Message received by logManager");

        try {
            /* Update received message to log*/
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                Log log = (Log) msg.getObject();
                try {
                    persist(log);
                } catch (ConstraintViolationException ex) {
                    Logger.getLogger(LogManager.class.getName())
                            .log(Level.SEVERE, null, ex);
                    System.out.println(ex.getConstraintViolations());
                }

            }
        } catch (JMSException e) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, e);
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, te);
        }
    }

    /**
     *
     * @param object
     */
    public void persist(Object object) {
        em.persist(object);
    }
}

