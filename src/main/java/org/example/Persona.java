package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Puri Franco
 * @version 1.0  de fecha 03.03.2025
 * Representa un contacto con un nombre y una lista de números de teléfono.
 */
class Persona {
    private final String name;
    private final List<String> phones;

    /**
     * Constructor para crear un contacto con un nombre y un número de teléfono.
     *
     * @param name  El nombre del contacto.
     * @param phone El número de teléfono de ese contacto
     */
    public Persona(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<>();
        this.getPhones().add(phone);
    }

    /**
     * Se obtiene el nombre del contacto.
     *
     * @return Nombre del contacto.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Devuelve la lista de números de teléfonos del contacto.
     *
     * @return Lista de números de teléfonos del contacto.
     */
    public List<String> getPhones() {
        return this.phones;
    }
}