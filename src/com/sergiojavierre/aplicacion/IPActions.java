package com.sergiojavierre.aplicacion;

import com.sergiojavierre.dominio.IP;

import java.util.List;

public interface IPActions {
    public List<IP> getIPsFromFile();
    public String getDireccionRed(IP ip);
    public String getMascaraRed(IP ip);
}
