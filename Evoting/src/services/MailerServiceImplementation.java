/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Exceptions.NoAvailableMailerServiceException;
import data.DigitalSignature;
import data.MailAddress;

/**
 *
 * @author Albert Planes
 */
public class MailerServiceImplementation implements MailerService{
    
    public boolean sent = false;
    
    @Override
    public void send(MailAddress address, DigitalSignature signature) throws NoAvailableMailerServiceException {
        sent = true;
    }

}
