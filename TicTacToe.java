// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class TicTacToe {
   private static char[][] grid = new char[3][3];
   private static final char PLAYER_X = 'X';
   private static final char PLAYER_O = 'O';
   private static char currentPlayer = 'X';

   public TicTacToe() {
   }

   public static void main(String[] var0) {
      int var2;
      for(int var1 = 0; var1 < 3; ++var1) {
         for(var2 = 0; var2 < 3; ++var2) {
            grid[var1][var2] = ' ';
         }
      }

      while(true) {
         printGrid();
         System.out.println("Player " + currentPlayer + ", enter your move (row, col): ");
         Scanner var4 = new Scanner(System.in);
         var2 = var4.nextInt();
         int var3 = var4.nextInt();
         grid[var2][var3] = currentPlayer;
         if (isGameOver()) {
            printGrid();
            if (hasWinner()) {
               System.out.println("Player " + currentPlayer + " wins!");
            } else {
               System.out.println("It's a tie!");
            }

            return;
         }

         currentPlayer = (char)(currentPlayer == 'X' ? 79 : 88);
      }
   }

   private static void printGrid() {
      for(int var0 = 0; var0 < 3; ++var0) {
         for(int var1 = 0; var1 < 3; ++var1) {
            System.out.print(grid[var0][var1]);
            if (var1 < 2) {
               System.out.print("|");
            }
         }

         System.out.println();
         if (var0 < 2) {
            System.out.println("-+-+-");
         }
      }

   }

   private static boolean isGameOver() {
      return hasWinner() || isFull();
   }

   private static boolean hasWinner() {
      int var0;
      for(var0 = 0; var0 < 3; ++var0) {
         if (isRowWin(var0)) {
            return true;
         }
      }

      for(var0 = 0; var0 < 3; ++var0) {
         if (isColWin(var0)) {
            return true;
         }
      }

      if (!isDiag1Win() && !isDiag2Win()) {
         return false;
      } else {
         return true;
      }
   }

   private static boolean isRowWin(int var0) {
      return grid[var0][0] != ' ' && grid[var0][0] == grid[var0][1] && grid[var0][1] == grid[var0][2];
   }

   private static boolean isColWin(int var0) {
      return grid[0][var0] != ' ' && grid[0][var0] == grid[1][var0] && grid[1][var0] == grid[2][var0];
   }

   private static boolean isDiag1Win() {
      return grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2];
   }

   private static boolean isDiag2Win() {
      return grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
   }

   private static boolean isFull() {
      for(int var0 = 0; var0 < 3; ++var0) {
         for(int var1 = 0; var1 < 3; ++var1) {
            if (grid[var0][var1] == ' ') {
               return false;
            }
         }
      }

      return true;
   }
}
