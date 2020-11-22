package magicsquare;

public class MagicSquare {
    final private static int MINIMUM_SIZE = 3;
    final private static int MAXIMUM_SIZE = 5;
    private int size;
    private int[][] square;
    
    public MagicSquare() {
        this(MINIMUM_SIZE);
    }
    
    public MagicSquare(int size) {
        if (!resize(size)) {
            resize(MINIMUM_SIZE);
        }
    }
    
    public boolean resize(int size) {
        boolean value = false;
        
        if (MINIMUM_SIZE <= size && size <= MAXIMUM_SIZE) {
            value = true;
            this.size = size;
            square = new int[size][size];
            
            clear();
        }
        
        return value;
    }
    
    private void clear() {
        int i, j;
        
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                square[i][j] = 0;
            }
        }
    }
    
    public void fill() {
        int i, row, col;
        
        if (size % 2 == 1) {
            for (i = 0, row = 0, col = size / 2; i < size * size; i++) {
                square[row][col] = i + 1;
                row--;
                col++;
                
                if (row < 0) {
                    row += size;
                }
                
                if (col == size) {
                    col = 0;
                }
                
                if (!isEmpty(row, col)) {
                    row++;
                    col--;
                    
                    if (row == size) {
                        row = 0;
                    }
                    
                    if (col < 0) {
                        col += size;
                    }
                    
                    row++;
                    
                    if (row == size) {
                        row = 0;
                    }
                }
            }
        } else {
            // even size
        }
    }
    
    private boolean isEmpty(int row, int col) {
        boolean value = false;
        
        if (square[row][col] == 0) {
            value = true;
        }
        
        return value;
    }
    
    public void display() {
        int i, j;
        
        for (i = 0; i < size * 2 + 1; i++) {
            if (i % 2 == 0) {
                System.out.print(" ");
                
                for (j = 0; j < size; j++) {
                    System.out.print(" ───");
                    
                    if (10 <= size * size) {
                        System.out.print("─");
                    }
                }
                
                System.out.println();
            } else {
                for (j = 0; j < size * 2 + 1; j++) {
                    if (j % 2 == 0) {
                        System.out.print(" │ ");
                    } else {
                        if (10 <= size * size && square[i / 2][j / 2] < 10) {
                            System.out.print(" ");
                        }
                        
                        System.out.print(square[i / 2][j / 2]);
                    }
                }
                
                System.out.println();
            }
        }
    }
    
    public void verify() {
        int row, col, sum1, sum2;
        
        System.out.print(" row :");
        
        for (row = 0, sum1 = 0; row < size; row++, sum1 = 0) {
            for (col = 0; col < size; col++) {
                sum1 += square[row][col];
            }
            
            System.out.print(" " + sum1);
        }
        
        System.out.print("\n column :");
        
        for (col = 0, sum1 = 0; col < size; col++, sum1 = 0) {
            for (row = 0; row < size; row++) {
                sum1 += square[row][col];
            }
            
            System.out.print(" " + sum1);
        }
        
        System.out.print("\n diagonal :");
        
        for (row = 0, col = 0, sum1 = 0, sum2 = 0; row < size; row++) {
            sum1 += square[row][col];
            sum2 += square[row][size - col - 1];
        }
        
        System.out.println(" " + sum1 + " " + sum2 + "\n");
    }
}
