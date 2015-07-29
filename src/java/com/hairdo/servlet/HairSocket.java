/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.servlet;

import com.google.gson.Gson;
import com.hairdo.dto.RequestDTO;
import com.hairdo.dto.ResponseDTO;
import com.hairdo.util.DataUtil;
import com.hairdo.util.Traffic;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author admin
 */
@ServerEndpoint("/socket")
@Stateful
public class HairSocket {

    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    Gson gson = new Gson();
    private static final Logger log = Logger.getLogger("HairSocket");
    long start = System.currentTimeMillis();
    RequestDTO dto;

    @EJB
    DataUtil util;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        //Handle new connection here
        ResponseDTO resp = new ResponseDTO();
        resp.setSessionID(session.getId());
        resp.setStatusCode(0);
        resp.setMessage("Handshake successful");
        log.log(Level.INFO, "New Session Created: {0}", gson.toJson(resp));
        peers.add(session);
        session.getBasicRemote().sendText(gson.toJson(resp));
    }

    @OnMessage
    public String onMessage(String message) {
        //Handle client received message here
        log.log(Level.INFO, "New Message received: " + message);
        ResponseDTO resp = new ResponseDTO();
        try {
            dto = gson.fromJson(message, RequestDTO.class);
            log.log(Level.INFO, "REQUEST: {0}", gson.toJson(dto));
            log.log(Level.INFO, "###### ---> Starting Hair Socket: requestType = {0}", dto.getRequestType());
            resp = Traffic.processRequest(dto, util);
            log.log(Level.INFO, "RESPONSE: {0}", gson.toJson(resp));
        } catch (Exception e) {
            resp.setStatusCode(ResponseDTO.SERVER_ERROR);
            resp.setMessage("Server Error");
            log.log(Level.SEVERE, "ERROR receiving request", e);
        } finally {
            log.log(Level.OFF, resp.toString());
            //sendData(resp);
            long end = System.currentTimeMillis();
            log.log(Level.OFF, "---> AftaRobot Original Socket completed, elapsed seconds: {0}",
                    getElapsed(start, end));
        }
        return gson.toJson(resp);
    }

    @OnClose
    public void onClose(Session session,
            CloseReason reason) {
        //Handle closing connection here
        peers.remove(session);
    }

    @OnError
    public void onError(Session session,
            Throwable throwable) {
        //Handle error during transport here
    }

    private double getElapsed(long start, long end) {
        BigDecimal d = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return d.doubleValue();
    }

}
