import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static BufferedReader br;
    private static Person gamer = null;
    private static Battle battle = null;
    private static int[] result = new int[1];

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Введите имя воина:");
        try {
            command(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void command (String string) throws IOException{
        if (gamer == null){
            gamer = new Hero(string, 100, 0,20, 0, 50);
            System.out.println(String.format("%s готов к бою!",string));
            showMenu();
        }
        switch (string){
            case "1":{
                System.out.println("Торговец еще не приехал");
                command(br.readLine());
            }
            break;
            case "2":{
                startFight();
            }
            break;
            case "3":{
                System.exit(0);
            }
            break;
            case "да":{
                command("2");
            }
            break;
            case "нет":{
                showMenu();
            }
        }
        command(br.readLine());
    }

    private static void startFight(){
        battle.fihgt(gamer, createMonster(), result);
        if (result[0] == 1){
            System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота. Осталось %d единиц здоровья.",gamer.getName(),gamer.getExperience(),gamer.getGold(),gamer.getHealth()));
            System.out.println("Желаете продолжить поход? (да) Или вернуться в город? (нет)");
            try {
                command(br.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
        }else  if (result[0] == 2) {
            System.out.println("Игра окончена!");
            try{
                command("3");
            }catch (IOException e){}
        }else {
            System.out.println("Желаете продолжить поход? (да) Или вернуться в город? (нет)");
            try {
                command(br.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void showMenu(){
        System.out.println("Выберите вариант:");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static Person createMonster(){
        if (Person.getRandom(10)%2 == 0)
            return new Goblin("Гоблин", 60,30,20,20,30);
        else
            return new Skeleton("Скелет",70,60, 30,10,20);
    }
}
