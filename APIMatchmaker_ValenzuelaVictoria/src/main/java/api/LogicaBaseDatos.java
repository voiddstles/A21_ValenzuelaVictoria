/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author victoria
 */
public class LogicaBaseDatos {
    
    private static List<ProfileDTO> baseDeDatos = new ArrayList<>();

    public static void agregarPerfil(ProfileDTO perfil) {
        baseDeDatos.add(perfil);
    }

    public static ProfileDTO buscarPerfil(int edad, String pais, String genero) {
        List<ProfileDTO> candidatos = baseDeDatos.stream()
                .filter(p -> {
                    int coincidencias = 0;
                    if (edad > 0 && p.getEdad() == edad) coincidencias++;
                    if (pais != null && !pais.isEmpty() && pais.equalsIgnoreCase(p.getPais())) coincidencias++;
                    if (genero != null && !genero.isEmpty() && genero.equalsIgnoreCase(p.getGenero())) coincidencias++;
                    return coincidencias >= 1; 
                })
                .collect(Collectors.toList());

        if (candidatos.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        return candidatos.get(rand.nextInt(candidatos.size()));
    }
}