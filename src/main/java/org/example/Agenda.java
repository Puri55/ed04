package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Puri Franco
 * @version 1.0 de fecha 03.03.2025
 * Esta clase es una Agenda que almacena una lista de contactos.
 * Hay varios métodos para agregar, modificar y eliminar contactos.
 */
public class Agenda implements IAgenda {
    /**
     * Lista de contactos almacenados en la agenda.
     */
    private final List<Persona> contacts; // Lista de Contacto

    /**
     * Contructor de la clase Agenda
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Agrega un contacto a la agenda, si ya existe agrega el nuevo número de telefono
     *
     * @param name  El nombre del contacto.
     * @param phone El número de teléfono de ese contacto
     */
    @Override
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact); // Añade un nuevo contacto a la lista
        }
    }

    /**
     * Elimina un contacto de la agenda por su nombre.
     *
     * @param name El nombre del contacto a eliminar.
     */
    @Override
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove(); //Elimina el contacto de la lista
            }
        }
    }

    /** Modifica un número de teléfono del contacto existente.
     * Si existe el número de teléfono antiguo, lo sustituye por el nuevo.
     * @param name Nombre del contacto.
     * @param oldPhone Número de teléfono antiguo.
     * @param newPhone Nuevo número de teléfono.
     */
    @Override
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Devuelve la lista de contactos almacenados en la agenda
     *
     * @return Lista de contactos a devolver.
     */
    @Override
    public List<Persona> getContacts() {
        return this.contacts;
    }
}