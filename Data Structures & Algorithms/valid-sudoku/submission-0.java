class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

         for(int i=0;i<9;i++){ 
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
         }

        for(int i=0;i<9;i++){ //row
            for(int j=0;j<9;j++){ // column
                if(board[i][j]=='.'){
                    continue;
                }
                else{
                    int boxIndex = (i/3)*3+(j/3);
                    char c = board[i][j];
                    if (rows[i].contains(c)|| cols[j].contains(c) || boxes[boxIndex].contains(c)){
                        return false;
                    }
                    else{
                        rows[i].add(c);
                        cols[j].add(c);
                        boxes[boxIndex].add(c);
                    }

                }
            }
        }
       return true; 
    }
}
