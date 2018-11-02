/**
 * Kartu untuk Permainan Ranjau Tersembunyi
 */
public class Card {
    private boolean mine;
    private boolean clicked;
    private String front;
    private String back;

    /**
     * Inisiasi kartu sebagai kartu bukan ranjau dan belum di klik.
     */
    public Card(){
        this.mine = false;
        this.clicked = false;
    }

    /**
     * Membuat kartu menjadi ranjau.
     */
    public void setMine() {
        this.mine = true;
    }

    /**
     * Menandai kartu sudah di klik.
     */
    public void setClicked(){
        this.clicked = true;
    }

    /**
     * Mengatur bagian depan kartu
     */
    public void setFront(String front){
        this.front = front;
    }

    /**
     * Mengembalikan bagian depan kartu
     * @return bagian depan kartu
     */
    public String getFront() {
        return this.front;
    }

    /**
     * Mengatur bagian belakang kartu
     */
    public void setBack(String back){
        this.back = back;
    }

    /**
     * Mengembalikan bagian belakang kartu
     * @return bagian belakang kartu
     */
    public String getBack() {
        return this.back;
    }

    /**
     * Mengembalikan kondisi kartu apakah ranjau atau bukan
     * @return true jika kartu adalah ranjau, false sebaliknya
     */
    public boolean isMine() {
        return this.mine;
    }

    /**
     * Mengembalikan kondisi kartu apakah sudah di klik atau belum
     * @return true jika kartu sudah di klik, false sebaliknya
     */
    public boolean isClicked() {
        return this.clicked;
    }
}