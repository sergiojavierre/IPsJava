package com.sergiojavierre.infraestructura;

import com.sergiojavierre.dominio.IP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPControllerFile extends IPController{

    private final static String file = "direcciones.txt";

    @Override
    public List<IP> getIPsFromFile() {
        File text = new File(file);
        List<IP> ips = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(text);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                IP ip = this.buildIP(line);
                ips.add(ip);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ips;
    }

}
