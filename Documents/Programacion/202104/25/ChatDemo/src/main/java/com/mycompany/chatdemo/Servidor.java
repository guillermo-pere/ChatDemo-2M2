/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GABO
 */
public class Servidor extends Observable implements Runnable{
    
    private int puerto;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    
    public void run(){
        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
        
        while(true){
            socket = servidor.accept();
            
            System.out.println("Cliente Conectado");
            in = new DataInputStream (socket.getInputStream());

            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            this.setChanged();
            this.notifyObservers(mensaje);
            this.clearChanged();
            
            socket.close();
            System.out.println("Cliente Desconectado");
        }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
        
        
      
        
 


    
    
    
}
