package com.isatimur.pobot;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * Created by developer on 8/4/16.
 */
@ClientEndpoint
public class WSClient {
    private static Object waitLock = new Object();

    @OnOpen
    public void onOpen(){

    }

    @OnMessage
    public void onMessage(String message) {
//the new USD rate arrives from the websocket server side.
        System.out.println("Received msg: " + message);
    }

    private static void wait4TerminateSignal() {
        synchronized (waitLock) {
            try {
                waitLock.wait();
            }
            catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        WebSocketContainer container = null;//
        Session session = null;
        try {
            //Tyrus is plugged via ServiceLoader API. See notes above
            container = ContainerProvider.getWebSocketContainer();
//WS1 is the context-root of my web.app
//ratesrv is the  path given in the ServerEndPoint annotation on server implementation
            session = container.connectToServer(WSClient.class, URI.create("ws://localhost:8080/location"));
            session.getAsyncRemote().sendText("40.767981, -73.981915");
            wait4TerminateSignal();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                try {
                    session.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
