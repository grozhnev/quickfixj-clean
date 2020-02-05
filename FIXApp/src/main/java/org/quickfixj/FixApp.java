package org.quickfixj;

/**
 * todo: реализовать Приложение для подключения и обмену данными в формате FIX
 *
 */
import quickfix.Acceptor;
import quickfix.Application;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.UnsupportedMessageType;

import java.io.FileInputStream;


public class FixApp implements Application {

    /**
     * implementation from example
     * @link https://www.quickfixj.org/usermanual/2.1.0/usage/application.html
     * */
    public static void main( String[] args ) throws Exception {
        System.out.println( "Приложение для обмена финансовыми данными в формате FIX протокла");

        if (args.length != 1) return;
        String fileName = args[0];

        Application myFixApplication = new FixApp();

        SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor(myFixApplication, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
        while(condition == true) {
            /**
             * todo: trading logic
             *    HERE >> >> >> >> >> >> >>
             * */
        }
        acceptor.stop();
    }

    /**
     * Called when quickfix creates new session.
     * Session lasts all life of application.
     * When session is created - we can send messages.
     * Messages will be sent when the connection will be established.
     * */
    @Override
    public void onCreate(SessionID sessionId) {

    }
    /**
     * Notifies when valid logon connection with counter party
     * has been established.
     * */
    @Override
    public void onLogon(SessionID sessionId) {

    }

    /**
     * Notifies when FIX connection is no longer online.
     * */
    @Override
    public void onLogout(SessionID sessionId) {

    }


    /* Client >> Server */

    /**
     * A callback to application messages that are sent to
     * counter party.
     * */
    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {

    }

    /**
     * Shows administrative messages, sent from fix app to counter party.
     * (Normally not useful !)
     * */
    @Override
    public void toAdmin(Message message, SessionID sessionId) {

    }

    /* Server >> Client */

    /**
     * Receives application level requests.
     * If app is Sell-side - it gets new order requests.
     * If app is Buy-side - it gets execution reports.
     * */
    @Override
    public void fromApp(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }

    /**
     * Notifies when administrative message is sent from counter party to
     * our FIX engine.
     * */
    @Override
    public void fromAdmin(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }
}
