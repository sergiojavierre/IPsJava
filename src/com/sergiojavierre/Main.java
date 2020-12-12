package com.sergiojavierre;

import com.sergiojavierre.dominio.IP;
import com.sergiojavierre.infraestructura.IPControllerFile;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IPControllerFile ipControllerFile = new IPControllerFile();
        List<IP> ips = ipControllerFile.getIPsFromFile();
        for(IP ip: ips){
            System.out.println("IP CIDR: "+ipControllerFile.getDireccionCompleta(ip.getDireccion(),ip.getMascara()));
            System.out.println("Dir red: "+ipControllerFile.getDireccionRed(ip));
            System.out.println("Mas red: "+ipControllerFile.getMascaraRed(ip));
            System.out.println("--");
        }
    }
}