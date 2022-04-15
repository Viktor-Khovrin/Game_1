public abstract class Person implements Attack {
    private String name;
    private int health;
    private int gold;
    private int dexterity; //ловкость
    private int experience;
    private int power;
    public Person(String name, int health, int gold, int dexterity, int experience, int power){
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.power = power;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getGold(){
        return gold;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getExperience(){
        return experience;
    }
    public int getPower(){
        return power;
    }
    public void addHealth(int addition){
        this.health+= addition;
    }
    public void addGold(int addition){
        this.gold+=addition;
    }
    public void addDexterity(int addition){
        this.dexterity += addition;
    }
    public void addExperience(int addition){
        this.experience += addition;
    }
    public static int getRandom(int range){
        return (int)(Math.random()*range);
    }
    @Override
    public String toString(){
        return String.format("%s здоровье %d",name,health);
    }
    @Override
    public int powerOfAttack(){
        if (dexterity * 3 > getRandom(100)) return power;
        else return 0;
    }
}
