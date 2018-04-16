public class CountNumberOfIslandPart {
 public static void main(String[] args) {

  int[][] island = new int[][] {
    { 1, 1, 0, 0, 0 },
    { 0, 1, 0, 0, 1 },
    { 1, 0, 0, 1, 1 },
    { 0, 0, 0, 0, 0 },
    { 1, 0, 1, 0, 1 }    ,
    { 0, 0 , 0, 0, 0}
  };
  System.out.println(island.length);//rows
  System.out.println(island[0].length); // columns
  System.out.println(countIsland(island));

  //If required, change '*' back to 1 in matrix.
 }

 public static int countIsland(int[][] island){
  if(island == null){
   return 0;
  }
  int count = 0;
  for (int row = 0; row < island.length; row++) {
   for (int column = 0; column < island[row].length; column++) {

    if(island[row][column] == 1){
     markAllNeighours(row, column, island);
     count++;
    }
   }
  }
  return count;
 }

 public static void markAllNeighours(int row, int column, int[][] island){

  island[row][column] = '*';

  //Right
  if(column+1 < island[row].length && island[row][column+1] == 1)
   markAllNeighours(row, column+1, island);

  //Bottom Right diagonal
  if(row+1 < island.length && column+1 < island[row].length && island[row+1][column+1] == 1)
   markAllNeighours(row+1, column+1, island);

  //Bottom
  if(row+1 < island.length && island[row+1][column] == 1)
   markAllNeighours(row+1, column, island);

  //Bottom Left diagonal
  if(row+1 < island.length && column-1 >= 0 && island[row+1][column-1] == 1)
   markAllNeighours(row+1, column-1, island);

  //Left
  if(column-1 >= 0 && island[row][column-1] == 1)
   markAllNeighours(row, column-1, island);

  //Top Left diagonal
  if(row-1 >= 0 && column-1 >= 0 && island[row-1][column-1] == 1)
   markAllNeighours(row-1, column-1, island);

  //Top
  if(row-1 >= 0 && island[row-1][column] == 1)
   markAllNeighours(row-1, column, island);

  //Top Right diagonal
  if(row-1 >= 0 && column+1 < island[row].length && island[row-1][column+1] == 1)
   markAllNeighours(row-1, column+1, island);
 }
}
