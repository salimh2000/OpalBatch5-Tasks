public class LoopDiamond {
    public static void main(String[] args) {
        int size = 5;

        for (int row = 1; row <= size; row++) {
            for (int blank = size - row; blank > 0; blank--){
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++){
                System.out.print("*"); 
            } 
            System.out.println();
        }

        for (int row = size - 1; row >= 1; row--) {
            for (int blank = size - row; blank > 0; blank--){
                System.out.print(" ");
            } 
            for (int star = 1; star <= 2 * row - 1; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}