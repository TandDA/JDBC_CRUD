package org.crud.view;

import org.crud.controller.DeveloperController;
import org.crud.controller.SkillController;
import org.crud.controller.SpecialtyController;
import org.crud.model.Developer;
import org.crud.model.Skill;
import org.crud.model.Specialty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    Scanner scanner;
    private DeveloperController developerController = new DeveloperController();
    private SkillController skillController = new SkillController();
    private SpecialtyController specialtyController = new SpecialtyController();
    DeveloperView(){
        scanner = new Scanner(System.in);
    }
    public void writeNewDeveloper(){

        Developer developerToSave = new Developer();

        System.out.println("Введите firstName для Developer");
        String firstNameDeveloper = scanner.nextLine();
        developerToSave.setFirstName(firstNameDeveloper);

        System.out.println("Введите lastName для Developer");
        String lastNameDeveloper = scanner.nextLine();
        developerToSave.setLastName(lastNameDeveloper);

        System.out.println("Введите Id Specialty для Developer");
        int specialtyId = Integer.parseInt(scanner.nextLine());
        Specialty specialty = specialtyController.read(specialtyId);
        developerToSave.setSpecialty(specialty);

        System.out.println("Сколько skill'ов у разроботчика?");
        int skillCount = Integer.parseInt(scanner.nextLine());
        List<Skill> skillList = new ArrayList<>();
        for (int i = 0;i < skillCount;i++){
            System.out.println("Введите id " + i + " skill:");
            int skillId = Integer.parseInt(scanner.nextLine());
            skillList.add(skillController.read(skillId));
        }
        developerToSave.setSkills(skillList);
        developerController.create(developerToSave);
    }

    public void updateDeveloper(){
        Developer developerToUpdate = new Developer();

        System.out.println("Введите id Developer для обновления ");
        Integer id = Integer.parseInt(scanner.nextLine());
        developerToUpdate.setId(id);

        System.out.println("Введите новое firstName Developer");
        String firstNameDeveloper = scanner.nextLine();
        developerToUpdate.setFirstName(firstNameDeveloper);

        System.out.println("Введите новое lastName Developer");
        String lastNameDeveloper = scanner.nextLine();
        developerToUpdate.setLastName(lastNameDeveloper);


        System.out.println("Введите id Specialty для Developer");
        int newSpecialtyId = Integer.parseInt(scanner.nextLine());
        Specialty specialtyDeveloper = specialtyController.read(newSpecialtyId);
        developerToUpdate.setSpecialty(specialtyDeveloper);

        developerController.update(developerToUpdate);
    }

    public void deleteDeveloper(){
        System.out.println("Введите id Developer для удаления");
        Integer id = scanner.nextInt();

        developerController.delete(id);
    }

    public void getAllDeveloper(){
        List<Developer> developers = developerController.readAll();
        for (Developer item: developers) {
            System.out.println(item);

        }
    }

    public List<Skill> skillRead(){

        List<Skill> currentDeveloperSkills = new ArrayList<>();


        System.out.println("Введите id Skill");
        System.out.println(skillController.readAll());
        final int skillId = scanner.nextInt();
        currentDeveloperSkills.add(skillController.read(skillId));

        return currentDeveloperSkills;
    }

    public void findDeveloperById() {
        System.out.println("Введите id Developer для поиска");
        Integer id = scanner.nextInt();

        Developer developer = developerController.read(id);
        System.out.println(developer);
    }
}
