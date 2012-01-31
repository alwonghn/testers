/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservices;

import com.avms.ejb.AVMSSession;
import com.avms.jb.incidentQueueList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author allan.lee
 */
@WebService()
@Stateless(mappedName = "AVMSWebServices", name = "AVMSWebServices")
public class AVMSWebServices {

    @EJB
    private AVMSSession AVMSejb;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public incidentQueueList operation() {
        //TODO write your implementation code here:
        return AVMSejb.getincidentQueue();
    }
}
