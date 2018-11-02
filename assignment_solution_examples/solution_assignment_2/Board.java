import java.util.Random;
import java.util.Scanner;

/**
 * Papan Permainan Ranjau Tersembunyi.
 */
public class Board {
    private Card[][] cards;
    private int row;
    private int column;
    private Random random;

    /**
     * Inisiasi papan permainan dengan baris dan kolom yang diinginkan.
     * @param row Jumlah baris
     * @param column Jumlah kolom
     */
    public Board(int row, int column){
        this.cards = new Card[row][column];
        this.row = row;
        this.column = column;
        this.random = new Random();
    }

    /**
     * Meletakkan kartu ke atas papan, semua kartu yang diletakkan bukanlah ranjau.
     */
    public void setUpCards(){
        for (int i = 0; i < this.row; i++){
            for (int j = 0; j < this.column; j++){
                cards[i][j] = new Card();
                cards[i][j].setFront(Integer.toString(i+1) + Integer.toString(j+1));
                cards[i][j].setBack("O");
            }
        }
    }

    /**
     * Menandai kartu sebagai ranjau sebanyak jumlah ranjau.
     * @param numberOfMine jumlah ranjau
     */
    public void setUpMines(int numberOfMine){
        int mineRowIndex;
        int mineColumnIndex;
        int count = 0;
        while(count<numberOfMine) {
            mineRowIndex = random.nextInt(this.row);
            mineColumnIndex = random.nextInt(this.column);

            if(!cards[mineRowIndex][mineColumnIndex].isMine()) {
                cards[mineRowIndex][mineColumnIndex].setMine();
                cards[mineRowIndex][mineColumnIndex].setBack("X");
                count++;
            }
        }
    }

    /**
     * Fungsi bantuan untuk melakukan pengulangan spasi sebanyak n.
     * @param n jumlah untuk pengulangan spasi
     * @return spasi sebanyak n
     */
    private String repeatSpace(int n){
       String space = "";
       for (int i = 0; i < n; i++){
           space += " ";
       }
       return space;
    }

    /**
     * Fungsi untuk mengetahui kondisi papan saat ini.
     * Kartu yang sudah pernah di klik, ditampilkan bagian belakangnya
     * Sedangkan yang belum pernah di klik, ditampilkan bagian depannya
     * @return kondisi papan saat ini.
     */
    public String currentBoardInfo(){
        String info = "";
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                //Spasi dibuat dinamis menyesuaikan dengan nilai terbesar dari bagian depan kartu
                int maxSpaceRequired = cards[row-1][column-1].getFront().length() + 1;
                int spaceRequired;
                if (cards[i][j].isClicked()){
                    spaceRequired = (maxSpaceRequired - 1);
                    info += cards[i][j].getBack() + repeatSpace(spaceRequired);
                }
                else {
                    spaceRequired = maxSpaceRequired - cards[i][j].getFront().length();
                    info += cards[i][j].getFront() + repeatSpace(spaceRequired);
                }
            }
            info += "\n";
        }
        return info;
    }

    /**
     * Fungsi untuk mengetahui kondisi papan saat permainan berakhir.
     * Kartu yang belum pernah di klik dan bukan ranjau, ditampilkan bagian depannya
     * Kartu yang lainnya, ditampilkan bagian belakangnya
     * @return kondisi papan saat permainan berakhir.
     */
    public String endBoardInfo(){
        String info = "";
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                //Spasi dibuat dinamis menyesuaikan dengan nilai terbesar dari bagian depan kartu
                int maxSpaceRequired = cards[row-1][column-1].getFront().length() + 1;
                int spaceRequired;
                if (!cards[i][j].isClicked() && !cards[i][j].isMine()){
                    spaceRequired = maxSpaceRequired - cards[i][j].getFront().length();
                    info += cards[i][j].getFront() + repeatSpace(spaceRequired);
                } else {
                    spaceRequired = (maxSpaceRequired - 1);
                    info += cards[i][j].getBack() + repeatSpace(spaceRequired);
                }

            }
            info += "\n";
        }
        return info;
    }

    /**
     * Fungsi untuk menandai kartu sudah pernah di klik.
     * @param row baris tempat kartu berada
     * @param column kolom tempat kartu berada
     * @return true jika tidak mengenai ranjau, false sebaliknya
     */
    public boolean markCard(int row, int column){
        cards[row][column].setClicked();
        return !cards[row][column].isMine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("#############################################");
        System.out.println("Selamat datang di Permainan Ranjau Tersembunyi");
        System.out.println("Dibuat oleh: Nurul Qomariyah");
        System.out.println("#############################################");

        //Meminta ukuran papan kepada user
        boolean invalidSize = true;
        int fieldSize = 0;
        while (invalidSize){
            System.out.print("Masukkan ukuran field: ");
            fieldSize = Integer.parseInt(scanner.nextLine());
            if (fieldSize >= 3 && fieldSize <= 10) invalidSize = false;
            else System.out.println("Input tidak sesuai");
        }

        //Meminta level permainan kepada user
        boolean invalidLevel = true;
        int numberOfMine = 0;
        while (invalidLevel) {
            System.out.print("Pilih level permainan (1: SULIT; 2: MUDAH): ");
            int level = Integer.parseInt(scanner.nextLine());
            if (level == 1) {
                numberOfMine = (int) Math.ceil(0.5 * fieldSize * fieldSize);
                invalidLevel = false;
            } else if (level == 2) {
                numberOfMine = (int) Math.ceil(0.25 * fieldSize * fieldSize);
                invalidLevel = false;
            } else {
                System.out.println("Input tidak sesuai");
            }
        }

        Board board = new Board(fieldSize, fieldSize);
        board.setUpCards();
        board.setUpMines(numberOfMine);

        //Memulai permainan
        boolean endOfGame = false;
        int winCount = 0;
        boolean win = false;
        while (!endOfGame) {
            System.out.println("\nIni adalah kotak permainan Anda:");
            System.out.print(board.currentBoardInfo());
            System.out.printf("Jumlah Ranjau: %s\n", numberOfMine);
            System.out.print("Silahkan pilih posisi sel: ");
            String position = scanner.nextLine();
            int splitPlace = (int)(Math.ceil(position.length()/2.0));

            int row  = 0;
            int column = 0;
            try {
                row = Integer.parseInt(position.substring(0, splitPlace));
                column = Integer.parseInt(position.substring(splitPlace, position.length()));
            } catch (NumberFormatException e) {
                System.out.println("Input tidak sesuai");
                continue;
            }

            try {
                if (board.markCard(row - 1, column - 1)) {
                    winCount++;
                    if (winCount == fieldSize) {
                        endOfGame = true;
                        win = true;
                    }
                } else {
                    endOfGame = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Input tidak sesuai");
            }
        }

        System.out.println("\nIni adalah kotak permainan Anda:");
        System.out.print(board.endBoardInfo());
        if (win) System.out.println("Selamat, Anda menang!");
        else System.out.println("Maaf, Anda kalah!");
    }
}