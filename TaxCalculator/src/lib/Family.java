package lib;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Family {
    public String spouseName;
    public int spouseIdNumber;
    public List<String> childNames;
    public List<String> childIdNumbers;
    
    public void setSpouse(String spouseName, int spouseIdNumber) {
	this.spouseName = spouseName;
	this.spouseIdNumber = spouseIdNumber;
    }
	
    public void addChild(String childName, String childIdNumber) {
	childNames.add(childName);
	childIdNumbers.add(childIdNumber);
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public int getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(int spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }

    public void setChildIdNumbers(List<String> childIdNumbers) {
        this.childIdNumbers = childIdNumbers;
    }
    
}
