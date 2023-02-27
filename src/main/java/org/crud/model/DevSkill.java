package org.crud.model;

public class DevSkill {
    private int devId;
    private int skillId;
    private Status status = Status.ACTIVE;

    public DevSkill(int devId, int skillId) {
        this.devId = devId;
        this.skillId = skillId;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
