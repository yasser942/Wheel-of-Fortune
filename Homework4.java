import java.io.*;
import java.util.Scanner;

public class Homework4 {

    public static int random(int maxRand) {
        int randomNumber = (int) (Math.random() * maxRand + 1);
        return randomNumber;
    }//getting a random number

    public static void readTxt(String filePath, SingleLinkedList SLL) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            SLL.sort(scanner.nextLine());
        }
    }//reads from txt file

    public static Object select(SingleLinkedList SLL, int maxRand) {
        int a = random(maxRand);
        return SLL.select(a);
    }// selects an element from list

    public static void main(String[] args) throws IOException {
        SingleLinkedList SLL1 = new SingleLinkedList();//animals
        SingleLinkedList SLL2 = new SingleLinkedList();//letters
        SingleLinkedList SLL3 = new SingleLinkedList();//word
        SingleLinkedList SLL4 = new SingleLinkedList();//hidden word
        SingleLinkedList SLL5 = new SingleLinkedList();//wheel
        SingleLinkedList SLL6 = new SingleLinkedList();//highScore


        int count = 1;//loop counter
        int max = 26;//max number of letters
        int step = 1;//step counter
        int score = 0;//score counter
        Object wheal = null;
        String name = "Yasser";
        Boolean bankrupt = false;
        //--------------------------------------------------Filling Lists------------------------------------------------------------
        SLL5.add("Bankrupt");
        SLL5.add(10);
        SLL5.add(20);
        SLL5.add(30);
        SLL5.add(40);
        SLL5.add(100);
        SLL5.add(200);
        SLL5.add(300);
        SLL5.add(400);
        SLL5.add("Bankrupt");
        SLL2.add("A");SLL2.add("B");SLL2.add("C");SLL2.add("D");SLL2.add("E");SLL2.add("F");SLL2.add("G");SLL2.add("H");
        SLL2.add("I");SLL2.add("J");SLL2.add("K");SLL2.add("L");SLL2.add("M");SLL2.add("N");SLL2.add("O");SLL2.add("P");
        SLL2.add("Q");SLL2.add("R");SLL2.add("S");SLL2.add("T");SLL2.add("U");SLL2.add("V");SLL2.add("W");SLL2.add("X");
        SLL2.add("Y");SLL2.add("Z");
        readTxt("D:\\animals.txt", SLL1);
        //System.out.print("Animals list : "); ** if you want to see the saved animals , please removes comments
        //SLL1.display();
        System.out.println();
        int randomAnimal = random(7);//Randomly selected number(in my case I have 7 animals,
        //please if you want to add more animals , change the max of random number depending on your choice
        System.out.print("Randomly generated number: " + randomAnimal);
        String word = (String) SLL1.select(randomAnimal);
        //adding the letters of the selected word to list , and adding (_) to the list that we will keep
        //correct selected letters inside.
        for (int i = 0; i < word.length(); i++) {
            SLL3.add(word.charAt(i));
            SLL4.add('_');
        }
        //-----------------------------------------------Starting game-------------------------------------------------------
        System.out.println();
        System.out.print("Word: ");
        SLL4.display();
        System.out.print("\t\t\t\t");
        System.out.print(String.format("Step: %-5S" , step));
        System.out.print(String.format("Score: %-10S" , score));
        SLL2.display();
        //the main loop of game
        while (count <= word.length()) {
            step++;
            System.out.println();
            wheal = select(SLL5, 10);
            System.out.println("Wheal: " + wheal);
            if (wheal.toString().equalsIgnoreCase("Bankrupt")) {
                score = 0;
                System.out.println("You have lost Your scores!!");
            } else {
                Object selectedChar = SLL2.select(random(max));
                System.out.print("Guess: " + selectedChar + "\n");
                if (SLL2.size() != 0) {
                    SLL2.delete(selectedChar);
                    max--;
                }
                for (int i = 0; i < word.length(); i++) {
                    int numberOfAppearing = 0;
                    boolean flag = SLL3.search(selectedChar.toString(), i);
                    if (flag) {
                        SLL4.changeChar(i, selectedChar.toString());
                        numberOfAppearing++;
                        score += ((int) wheal * numberOfAppearing);
                        count++;
                    }
                }
            }
            String str="-";
            System.out.println(str.repeat(120));
            System.out.print("Word: ");
            SLL4.display();
            System.out.print("\t\t\t\t");
            System.out.print(String.format("Step: %-5S" , step));
            System.out.print(String.format("Score: %-10S" , score));
            if (max > 0) {
                SLL2.display();
            }

        }
        System.out.println("\n");
        System.out.println("You have got " + score + " TL!!!\n");
        System.out.println("---------------------------\n High Score Table\n---------------------------");
        File file1 = new File("D:\\HighScoreTable.txt");//reading the old high scores
        Scanner scanner = new Scanner(file1);
        while (scanner.hasNext()) {
            SLL6.addPlayers(scanner.nextLine(), scanner.nextLine());
        }
        SLL6.addPlayers(name, score);//adding the current score to the ordered list

        Writer wr = new FileWriter("D:\\HighScoreTable.txt");//importing the names to the txt file
        for (int i = 1; i <= 10; i++) {

            wr.write((SLL6.select(i)) + "\n");
            wr.write((SLL6.select_Score(i)) + "\n");


        }
        wr.flush();
        wr.close();
        File file2 = new File("D:\\HighScoreTable.txt");//reading and printing the high score table
        Scanner scanner2 = new Scanner(file2);
        while (scanner2.hasNextLine()) {
            System.out.println(String.format("%-10S %S", scanner2.nextLine(), scanner2.nextLine()));
        }

    }
}
