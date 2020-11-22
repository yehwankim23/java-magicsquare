package magicsquare;

public class MagicSquareTest {
    public static void main(String[] args) {
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.fill();
        magicSquare.display();
        magicSquare.verify();
        
        magicSquare.resize(4);
        magicSquare.fill();
        magicSquare.display();
        magicSquare.verify();
        
        magicSquare.resize(5);
        magicSquare.fill();
        magicSquare.display();
        magicSquare.verify();
    }
}
