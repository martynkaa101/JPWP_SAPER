package utils;
import java.util.*;

public class Board {

    private Square[][] board;
    private int bombsCount;
    private int size;


    public Board(int size, int bombsCount) {
        this.size = size;
        this.bombsCount = bombsCount;
        board = new Square[size][size];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Square();
            }
        }
        setBombs();
    }


    /*
    a) Uzupełnij metodę setBombs tak, aby na losowych kwadratach
    z board[][] ustawiała bombę, czyli przypisywało polu status "o".
    (board[x][y].setStatus). Pól z bombami ma być tyle ile podaje
    parametr bombsCount.
     */

   private void setBombs() {
       List<Integer> position = new ArrayList<>();
       int temp = board.length * board[0].length;
       int bomb;

       Random random = new Random();

       while (position.size() < bombsCount) {
           bomb = random.nextInt(temp);
           if (position.contains(bomb) == false) {
               position.add(bomb);
           }
       }
       Collections.sort(position);
       int tmp = 0;
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               if (position.contains(tmp) == true) {
                   board[i][j].setStatus("o");
               }
               tmp += 1;
           }
       }


   }



    public void printBoard() {
        System.out.println("#########BOARD#######");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                    System.out.print(" " + board[i][j].getStatus() + " ");

            }
            System.out.println();
        }
        System.out.println("######################");
    }

    public Square[][] getBoard() {
        return board;
    }

}
