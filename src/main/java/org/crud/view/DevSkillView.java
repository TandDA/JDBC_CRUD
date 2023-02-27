package org.crud.view;

import org.crud.controller.DevSkillController;
import org.crud.model.DevSkill;

import java.util.Scanner;

public class DevSkillView {
    Scanner scanner = new Scanner(System.in);
    DevSkillController devSkillController = new DevSkillController();

    public void writeNewDevSkill() {
        System.out.println("Введите id developer ");
        int devId = scanner.nextInt();
        System.out.println("Введите id skill ");
        int skillId = scanner.nextInt();
        DevSkill devSkill = new DevSkill(devId,skillId);
        devSkillController.create(devSkill);
    }

    public void deleteDevSkill() {
        System.out.println("Введите id developer ");
        int devId = scanner.nextInt();
        System.out.println("Введите id skill ");
        int skillId = scanner.nextInt();
        DevSkill devSkill = new DevSkill(devId,skillId);
        devSkillController.delete(devSkill);
    }
}
