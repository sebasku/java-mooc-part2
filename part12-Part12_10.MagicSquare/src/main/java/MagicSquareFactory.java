
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        int number = 1;
        int row = 0;
        int column = size / 2;
        int curr_row;
        int curr_col;
        while (number <= size * size) {
            square.placeValue(row, column, number);
            number++;
            curr_row = row;
            curr_col = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = size - 1;
            }
            if (column == size) {
                column = 0;
            }
            if (square.readValue(row, column) != 0) {
                row = curr_row + 1;
                column = curr_col;
                if (row == -1) {
                    row = size - 1;
                }
            }
        }
        return square;
    } 
}
