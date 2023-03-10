package org.crud.view;

import org.crud.controller.SpecialtyController;
import org.crud.model.Specialty;
import org.crud.model.Status;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class SpecialtyView {
    Scanner scanner;
    private SpecialtyController specialtyController = new SpecialtyController();
    SpecialtyView(){
        scanner = new Scanner(new InputStreamReader(System.in));
    }
    public void writeNewSpecialty(){
        Specialty specialtyToSave = new Specialty();
        System.out.println("Введите название Specialty");
        String nameSpecialty = scanner.nextLine();
        specialtyToSave.setSpecName(nameSpecialty);
        specialtyToSave.setStatus(Status.ACTIVE);

        specialtyController.create(specialtyToSave);

    }

    public void updateSpecialty(){
        System.out.println("Введите id Specialty для обновления ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите новое название Specialty");
        String nameSpecialty = scanner.nextLine();
        Specialty specialtyToSave = new Specialty(id, nameSpecialty);

        specialtyController.update(specialtyToSave);
    }

    public void deleteSpecialty(){
        System.out.println("Введите id Specialty для удаления");
        Integer id = scanner.nextInt();

        specialtyController.delete(id);
    }

    public void getAllSpeciality(){
        List<Specialty> specialties = specialtyController.readAll();
        for (Specialty spec: specialties) {
            System.out.println(spec);

        }
    }

    public void findSpecialtyById() {
        System.out.println("Введите id Specialty для поиска");
        Integer id = scanner.nextInt();

        Specialty specialty = specialtyController.read(id);
        System.out.println(specialty);
    }
}
