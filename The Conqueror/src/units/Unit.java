package units;



public class Unit{
    private int level ;
    private int maxSoldierCount ;
    private int currentSoldierCount;
    private double idleUpKeep;
    private double marchingUpKeep;
    private double siegeUpKeep;

    public int getLevel(){
        return this.level ;
    }
    
    public int getMaxSoldierCount(){
        return this.maxSoldierCount ;
    }

    
    public int getCurrentSoldierCount(){
        return this.currentSoldierCount ;
    }

    
    public void setCurrentSoldierCount(int n){
        this.currentSoldierCount = n ;
        return ;
    }
    public double getIdleUpKeep(){
        return this.idleUpKeep;
    }

    public double getMarchingUpKeep(){
        return this.marchingUpKeep ;
    }

    public double getSiegeUpKeep(){
        return this.siegeUpKeep ;
    }
    public Unit(int level,int maxSoldierCount,double idleUpkeep, double
                marchingUpkeep,double siegeUpkeep){
                
                    this.level = level;
                    this.maxSoldierCount = maxSoldierCount;
                    this.idleUpKeep = idleUpkeep ;
                    this.marchingUpKeep = marchingUpkeep;
                    this.siegeUpKeep = siegeUpkeep;
                    



                    

                }
    

}