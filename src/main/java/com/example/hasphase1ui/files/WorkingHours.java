package com.example.hasphase1ui.files;
import java.util.InputMismatchException;

public class WorkingHours {
    int from;
    int to;
    public WorkingHours(int from,int to){
        this.from=from;
        this.to=to;
    }
    public void displayWorkingHours(Admin admin){
        System.out.println(admin.getUsername()+"Working hours from "+from+" to "+to);
    }
    public String returnWorkingHours(){
        return (" from "+from+" to "+to);
    }
}
