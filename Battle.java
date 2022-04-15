public class Battle{
    private Person hero;
    private Person monster;
    private int[] result;

    public void fihgt(Person hero, Person monster, int[] result){
        this.hero = hero;
        this.monster = monster;
        this.result = result;
        int step = 1;
        result[0] = 0;
        boolean endOfFight = false;
        while (!endOfFight) {
            System.out.println(">>>>>> " + step + " <<<<<<");
            if (step++ % 2 != 0) endOfFight = makeHit(hero, monster, result);
            else endOfFight = makeHit(monster, hero, result);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Boolean makeHit(Person striker, Person defencer, int[] result){
        int hitPower = striker.powerOfAttack();
        int defencerHealth = defencer.getHealth();
        if (hitPower != 0){
            defencerHealth -= hitPower;
            System.out.println(String.format("%s нанес удар в %d единиц!",striker.getName(),hitPower));
            System.out.println(String.format("У %s осталось %d единиц здоровья!",defencer.getName(),defencerHealth));
        }else{
            System.out.println(String.format("%s промахнулся!",striker.getName()));
            result[0] = 0;
        }
        if (defencerHealth <= 0 && defencer instanceof Hero){
            System.out.println(String.format("%s пал в бою!", defencer.getName()));
            result[0] = 2;
            return true;
        }else if (defencerHealth <= 0) {
            System.out.println(String.format("Монстр %s повержен! Вы получаете %d золота и %d опыта!",defencer.getName(),defencer.getGold(),defencer.getExperience()));
            striker.addExperience(defencer.getExperience());
            striker.addGold(defencer.getGold());
            result[0] = 1;
            return true;
        }else{
            defencer.addHealth(-hitPower);
            return false;
        }
    }
}
