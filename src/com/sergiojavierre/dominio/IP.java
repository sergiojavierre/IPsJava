package com.sergiojavierre.dominio;

import com.sergiojavierre.infraestructura.IPController;

public class IP {

    // int usa 32 bits como las IP pero como el primero emplea signo, no puedo usar int (no hay unsigned)
    // https://stackoverflow.com/questions/8677707/data-type-for-storing-ip-addresses
    private long direccion;
    private int mascara;

    //el primer octeto debe ser long ya que lo voy a desplazar 24 bits y se sale del rango
    public IP(long octeto1, int octeto2, int octeto3, int octeto4, int mascaraCIDR){
        this.direccion =
                        (octeto1 << IPController.desplazamientoPrimero) +
                        (octeto2 << IPController.desplazamientoSegundo) +
                        (octeto3 << IPController.desplazamientoTercero) +
                        octeto4; //desplazamiento de bits
        this.mascara = mascaraCIDR;
    }

    public long getDireccion(){
        return this.direccion;
    }

    public int getMascara() {
        return mascara;
    }
}
