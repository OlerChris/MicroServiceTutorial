package com.Revature.AccountService.beans.enums;

public enum SecurityLevel {
    Basic(1),
    Manager(2);

    private final int level;

    SecurityLevel(int i) {
        this.level = i;
    }

    public int getLevelId(){
        return level;
    }

    public static SecurityLevel getSecurityLevelbyLevelId(int id){
        for(SecurityLevel x : SecurityLevel.values()){
            if(x.level == id) return x;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SecurityLevel{" +
                "level=" + level +
                '}';
    }
}
