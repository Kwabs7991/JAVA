import java.util.Random;

public class Futoshiki {
    public static final int DEFAULT_GRIDSIZE = 5;
    public int gridsize;
    private int[][] squares;
    private String[][] rowConstraints;
    private String[][] columnConstraints;

    public Futoshiki(int gridsize) {
        this.gridsize = gridsize;
        this.squares = new int[gridsize][gridsize];
        this.rowConstraints = new String[gridsize][gridsize - 1];
        this.columnConstraints = new String[gridsize][gridsize - 1];

        int column;
        int row;
        for(column = 0; column < gridsize; ++column) {
            for(row = 0; row < gridsize - 1; ++row) {
                this.rowConstraints[column][row] = " ";
            }
        }

        for(column = 0; column < gridsize; ++column) {
            for(row = 0; row < gridsize - 1; ++row) {
                this.columnConstraints[column][row] = " ";
            }
        }

    }

    public Futoshiki() {
        this(5);
    }

    private boolean checkCoordinates(int row, int column) {
        return row >= 0 && row < this.gridsize && column >= 0 && column < this.gridsize;
    }

    public void setSquare(int row, int column, int val) {
        if (val >= 1 && val <= this.gridsize && this.checkCoordinates(row, column)) {
            this.squares[row][column] = val;
        }

    }

    public int getSquare(int row, int column) {
        return this.checkCoordinates(row, column) ? this.squares[row][column] : 0;
    }

    public void setRowConstraint(int row, int col, String relation) {
        if (relation.equals("<") || relation.equals(">")) {
            this.rowConstraints[row][col] = relation;
        }

    }

    public void setColumnConstraint(int col, int row, String relation) {
        if (relation.equals("<") || relation.equals(">")) {
            this.columnConstraints[col][row] = relation;
        }

    }

    public void fillPuzzle(int numValues, int numHorizontal, int numVertical) {
        Random rand = new Random(3L);
        int countValues = 0;

        int x;
        int x;
        while(countValues < numValues) {
            x = rand.nextInt(this.gridsize);
            x = rand.nextInt(this.gridsize);
            if (this.squares[x][x] == 0) {
                this.squares[x][x] = rand.nextInt(this.gridsize) + 1;
                ++countValues;
            }
        }

        x = 0;

        int x;
        while(x < numHorizontal) {
            x = rand.nextInt(this.gridsize);
            x = rand.nextInt(this.gridsize - 1);
            if (this.rowConstraints[x][x].equals(" ")) {
                this.rowConstraints[x][x] = rand.nextInt(2) > 0 ? ">" : "<";
                ++x;
            }
        }

        x = 0;

        while(x < numVertical) {
            x = rand.nextInt(this.gridsize);
            int y = rand.nextInt(this.gridsize - 1);
            if (this.columnConstraints[x][y].equals(" ")) {
                this.columnConstraints[x][y] = rand.nextInt(2) > 0 ? ">" : "<";
                ++x;
            }
        }

    }

    public String displayString() {
        String s = "";

        for(int row = 0; row < this.gridsize - 1; ++row) {
            s = s + this.drawRow(row);
            s = s + this.drawColumnConstraints(row);
        }

        s = s + this.drawRow(this.gridsize - 1);
        return s;
    }

    private String printTopBottom() {
        String s = "";

        for(int col = 0; col < this.gridsize; ++col) {
            s = s + "---";
            if (col < this.gridsize - 1) {
                s = s + " ";
            }
        }

        return s + "\n";
    }

    private String drawColumnConstraints(int row) {
        String s = " ";

        for(int col = 0; col < this.gridsize; ++col) {
            String symbol = " ";
            if (this.columnConstraints[col][row].equals("<")) {
                symbol = "^";
            } else if (this.columnConstraints[col][row].equals(">")) {
                symbol = "V";
            }

            s = s + symbol + " ";
            if (col < this.gridsize - 1) {
                s = s + "  ";
            }
        }

        return s + "\n";
    }

    private String drawRow(int row) {
        String s = this.printTopBottom();

        for(int col = 0; col < this.gridsize; ++col) {
            if (this.squares[row][col] > 0) {
                s = s + "|" + this.squares[row][col] + "|";
            } else {
                s = s + "| |";
            }

            if (col < this.gridsize - 1) {
                s = s + this.rowConstraints[row][col];
            }
        }

        return s + "\n" + this.printTopBottom();
    }

    public static void main(String[] args) {
        Futoshiki f = new Futoshiki(6);
        f.fillPuzzle(10, 10, 10);
        System.out.println("Futoshiki with 10 values, row and vertical constraints");
        System.out.print(f.displayString());
    }
}
