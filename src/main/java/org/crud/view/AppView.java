package org.crud.view;

import java.util.Scanner;

public class AppView {

    SkillView skillView = new SkillView();
    SpecialtyView specialtyView = new SpecialtyView();
    DeveloperView developerView = new DeveloperView();
    Scanner scanner = new Scanner(System.in);
    public void runApp(){
        while(true)
        {
            mainMenu();
        }
    }
    private void mainMenu(){
        System.out.println("Введите номер действия");
        System.out.println("1) Управлять Skill");
        System.out.println("2) Управлять Developer");
        System.out.println("3) Управлять Specialty");

        int num = scanner.nextInt();
        switch (num){
            case 1:
                skillMenu();
                break;
            case 2:
                developerMenu();
                break;
            case 3:
                specialtyMenu();
                break;
            default:
                mainMenu();
                break;
        }
    }

    private  void skillMenu(){
        System.out.println("Введите номер действия");
        System.out.println("1) новый Skill");
        System.out.println("2) обновить Skill");
        System.out.println("3) удалить Skill");
        System.out.println("4) найти Skill по id");
        System.out.println("5) Вывести все записи");

        int num = scanner.nextInt();
        switch (num){
            case 1:
                skillView.writeNewSkill();
                break;
            case 2:
                skillView.updateSkill();
                break;
            case 3:
                skillView.deleteSkill();
                break;
            case 4:
                skillView.findSkillById();
                break;
            case 5:
                skillView.getAllSkill();
            default:
                mainMenu();
                break;
        }
        mainMenu();
    }
    private  void developerMenu(){
        System.out.println("Введите номер действия");
        System.out.println("1) новый Developer");
        System.out.println("2) обновить Developer");
        System.out.println("3) удалить Developer");
        System.out.println("4) найти Developer по id");
        System.out.println("5) Вывести все записи");

        int num = scanner.nextInt();
        switch (num){
            case 1:
                developerView.writeNewDeveloper();
                break;
            case 2:
                developerView.updateDeveloper();
                break;
            case 3:
                developerView.deleteDeveloper();
                break;
            case 4:
                developerView.findDeveloperById();
                break;
            case 5:
                developerView.getAllDeveloper();
            default:
                mainMenu();
                break;
        }
        mainMenu();
    }
    private  void specialtyMenu(){
        System.out.println("Введите номер действия");
        System.out.println("1) новый Specialty");
        System.out.println("2) обновить Specialty");
        System.out.println("3) удалить Specialty");
        System.out.println("4) найти Specialty по id");
        System.out.println("5) Вывести все записи");

        int num = scanner.nextInt();
        switch (num){
            case 1:
                specialtyView.writeNewSpecialty();
                break;
            case 2:
                specialtyView.updateSpecialty();
                break;
            case 3:
                specialtyView.deleteSpecialty();
                break;
            case 4:
                specialtyView.findSpecialtyById();
                break;
            case 5:
                specialtyView.getAllSpeciality();
            default:
                mainMenu();
                break;
        }
        mainMenu();
    }
}
