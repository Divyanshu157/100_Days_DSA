//import java.util.*;
//public class Test2 {
//    static int maxPoints = 1;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] chocolatesStr = scanner.nextLine().split(" ");
//        int[] chocolates = new int[chocolatesStr.length];
//        for (int i = 0; i < chocolatesStr.length; i++) {
//            chocolates[i] = Integer.parseInt(chocolatesStr[i]);
//        }
//
//        int initialChocolates = scanner.nextInt();
//
//        List<Integer> bagIndices = new ArrayList<>();
//        for (int i = 0; i < chocolates.length; i++) {
//            bagIndices.add(i);
//        }
//
//        // Generate permutations and calculate points
//        generatePermutations(bagIndices, chocolates, initialChocolates, 0);
//
//        System.out.println(maxPoints);
//        scanner.close();
//    }
//
//    // Recursive function to generate permutations
//    public static void generatePermutations(List<Integer> bagIndices, int[] chocolates, int initialChocolates, int index) {
//        if (index == bagIndices.size()) {
//            int currentPoints = 1;
//            int chocolatesLeft = initialChocolates;
//
//            for (int i = 0; i < bagIndices.size(); i++) {
//                int bagIndex = bagIndices.get(i);
//                if (chocolatesLeft >= chocolates[bagIndex]) {
//                    chocolatesLeft -= chocolates[bagIndex];
//                    currentPoints++;
//                } else {
//                    chocolatesLeft += chocolates[bagIndex];
//                    currentPoints--;
//                }
//                maxPoints = Math.max(maxPoints, currentPoints);
//            }
//        } else {
//            for (int i = index; i < bagIndices.size(); i++) {
//                Collections.swap(bagIndices, i, index);
//                generatePermutations(bagIndices, chocolates, initialChocolates, index + 1);
//                Collections.swap(bagIndices, i, index);
//            }
//        }
//    }
//}


//public class Test2 {
//        public static int Que = 5;
//
//        public void Test2(int Que)
//        {
//            this.Que = Que;
//        }
//
//        public static void main(String[] tail)
//        {
//            System.out.print(new Test2(2).Que);
//        }
//}
//
