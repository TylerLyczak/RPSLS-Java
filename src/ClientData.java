import java.io.Serializable;
import java.util.ArrayList;

public class ClientData implements Serializable {
    // Used for serialization
    private int clientID;

    private boolean isRock;
    private boolean isPaper;
    private boolean isScissors;
    private boolean isLizard;
    private boolean isSpock;

    ClientData()    {
        this.clientID = -1;
        this.isRock = false;
        this.isPaper = false;
        this.isScissors = false;
        this.isLizard = false;
        this.isSpock = false;
    }

    ClientData(int clientNum)    {
        this.clientID = clientID;
        this.isRock = false;
        this.isPaper = false;
        this.isScissors = false;
        this.isLizard = false;
        this.isSpock = false;
    }

    public int getClientID()                       { return clientID;}

    public boolean isRock()                         { return isRock;}

    public boolean isPaper()                        { return isPaper;}

    public boolean isScissors()                     { return isScissors;}

    public boolean isLizard()                       { return isLizard;}

    public boolean isSpock()                        { return isSpock;}

    public void setClientID (int clientID)        { this.clientID = clientID; }

    public void setRock (boolean isRock)            { this.isRock = isRock;}

    public void setPaper (boolean isPaper)          { this.isPaper = isPaper;}

    public void setScissors (boolean isScissors)    { this.isScissors = isScissors;}

    public void setLizard (boolean isLizard)        { this.isLizard = isLizard;}

    public void setSpock (boolean isSpock)          { this.isSpock = isSpock;}

    public void resetBools()    {
        isRock = false;
        isPaper = false;
        isScissors = false;
        isLizard = false;
        isSpock = false;
    }

    // This function will return the bool when it is set to true
    // If there is one or more true values, then the override int will return -1 to indicate something is wrong.
    public int getTrue()    {
        int override = 0;
        int correctBool = -1;

        if (isRock) {
            correctBool = 0;
            override++;
        }
        if (isPaper)    {
            correctBool = 1;
            override++;
        }
        if (isScissors) {
            correctBool = 2;
            override++;
        }
        if (isLizard)   {
            correctBool = 3;
            override++;
        }
        if (isSpock)    {
            correctBool = 4;
            override++;
        }

        if (override > 1)   {
            return -1;
        }   else    {
            return correctBool;
        }
    }

    // Returns an arraylist of all the bools
    public ArrayList<Boolean> getAllBools() {
        ArrayList<Boolean> allBools = new ArrayList<>();
        allBools.add(isRock);
        allBools.add(isPaper);
        allBools.add(isScissors);
        allBools.add(isLizard);
        allBools.add(isSpock);
        return allBools;
    }

    public boolean isAllFalse() {
        if (isRock)     { return false;}
        if (isPaper)    { return false;}
        if (isScissors) { return false;}
        if (isLizard)   { return false;}
        if (isSpock)    { return false;}
        return true;
    }

}