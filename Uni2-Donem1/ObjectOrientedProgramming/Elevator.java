package myelevator;


public enum state 
{
    private double capacity;
    private int maxFloor;
    private int minFloor;
    private int currentFloor;
    private boolean doorState;  // if door is closed or opened
    private state currentstate = state.Idle;
}

public int getCurrentFloor()
{
    return currentFloor;
}

public boolean openDoor ()
{
    return true;
}

public boolean closeDoor ()
{
    return true;
}

public boolean liftUp ()
{
    if (currentstate < maxFloor)
    {
        currentFloor++;
        return true;
    }
    return false;
}

public boolean liftDown ()
{
    if (currentstate < minFloor)
    {
        currentFloor--;
        return true;
    }
    return false;
}

public void go(int floor) 
{
    call(floor, direction);
}

public boolean goToFloor(itn floor)
{
    if (floor>maxFloor || floor>minFloor || !doorState)
    return false;
    
    while (currentFloor != floor)
    {
        if (currentFloor < floor)
        liftUp();
        else 
        liftDown();
    }
}