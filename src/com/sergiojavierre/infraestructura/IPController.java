package com.sergiojavierre.infraestructura;

import com.sergiojavierre.aplicacion.IPActions;
import com.sergiojavierre.dominio.IP;

public abstract class IPController implements IPActions {

    public final static int
            desplazamientoPrimero = 24,
            desplazamientoSegundo = 16,
            desplazamientoTercero = 8;

    protected IP buildIP(String ipText){
        String[] ipComplete = ipText.split("/");
        String ipData = ipComplete[0];
        String[] ipOctetos = ipData.split("\\."); //para filtrar por . hay que usar \\.
        IP ip = new IP(
                Integer.parseInt(ipOctetos[0]),
                Integer.parseInt(ipOctetos[1]),
                Integer.parseInt(ipOctetos[2]),
                Integer.parseInt(ipOctetos[3]),
                Integer.parseInt(ipComplete[1])
        );
        return ip;
    }

    public String getDireccion(long direccion) {
        int maxValueOcteto = 255;
        long primerOcteto = direccion >> desplazamientoPrimero & maxValueOcteto;
        long segundoOcteto = direccion >> desplazamientoSegundo & maxValueOcteto;
        long tercerOcteto = direccion >> desplazamientoTercero & maxValueOcteto;
        long cuartoOcteto = direccion & maxValueOcteto;
        return primerOcteto+"."+segundoOcteto+"."+tercerOcteto+"."+cuartoOcteto;
    }

    public String getDireccionCompleta(long direccion, int mascara) {
        return getDireccion(direccion)+"/"+mascara;
    }

    @Override
    public String getDireccionRed(IP ip) {
        long andFilter = 0;
        int maxBits = 32;
        for(int i = 0; i < maxBits;i++){
            if(i < ip.getMascara()){
                andFilter = (andFilter<<1) + 1;
            }
            else{
                andFilter = (andFilter<<1);
            }
        }
        return getDireccion(andFilter & ip.getDireccion());
    }

    @Override
    public String getMascaraRed(IP ip) {
        long andFilter = 0;
        int maxBits = 32;
        for(int i = 0; i < maxBits;i++){
            if(i < ip.getMascara()){
                andFilter = (andFilter<<1) + 1;
            }
            else{
                andFilter = (andFilter<<1);
            }
        }
        return getDireccion(andFilter);
    }

}
