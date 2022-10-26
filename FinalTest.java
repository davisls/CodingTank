import java.util.Objects;
import java.util.Scanner;

public class FinalTest {
    public static void main(String[] args) {
        int totalNum = getTotalNumOfMedia();
        int[] numsOfMedia = getNumsOfMedia(totalNum);
        String typeOfMedia = getTypeOfMedia();
        if (Objects.equals(typeOfMedia, "ARITMETICA")) {
            System.out.println("A media é igual a: " + calculateArithmeticMedia(numsOfMedia, totalNum));
        } else if (Objects.equals(typeOfMedia, "HARMONICA")) {
            System.out.println("A media é igual a: " + calculateHarmonicaMedia(numsOfMedia, totalNum));
        } else {
            System.out.println("Ocorreu um erro inesperado, por favor insira os valores novamente!");
            main(args);
        }
    }

    public static int getTotalNumOfMedia() {
        Scanner sc = new Scanner(System.in);
        try {
            int totalNums;
            System.out.println("Digite a quantidade de valores da media:");
            totalNums = sc.nextInt();
            if (totalNums <= 0) {
                System.out.println("Favor digitar um número inteiro positivo e maior que zero");
                return getTotalNumOfMedia();
            }
            return totalNums;
        } catch (Exception e) {
            System.out.println("Favor digitar um número real até 2.147.483.647:");
            return getTotalNumOfMedia();
        }
    }

    public static int[] getNumsOfMedia(int totalNum) {
        Scanner sc = new Scanner(System.in);
        int[] numsOfMedia = new int[totalNum];
        try {
            for (int i = 0; i < totalNum; i++) {
                System.out.println("Digite o " + (i + 1) + "° numero da media");
                numsOfMedia[i] = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Voce inseriu um valor errado, por favor repita todos os valores");
            System.out.println("Os valores devem ser números reais entre -2.147.483.647 e 2.147.483.647:");
            return getNumsOfMedia(totalNum);
        }

        return numsOfMedia;
    }

    public static String getTypeOfMedia() {
        Scanner sc = new Scanner(System.in);
        String typeOfMedia;
        try {
            System.out.println("Digite qual media voce quer calcular, ARITMETICA ou HARMONICA");
            typeOfMedia = sc.nextLine().toUpperCase();
            if (!Objects.equals(typeOfMedia, "ARITMETICA") && !Objects.equals(typeOfMedia, "HARMONICA")) {
                System.out.println("Favor digitar ou o texto ARITMETICA ou HARMONICA");
                return getTypeOfMedia();
            }
            return typeOfMedia;
        } catch (Exception e) {
            System.out.println("Favor digitar ou o texto ARITMETICA ou HARMONICA:");
            return getTypeOfMedia();
        }
    }

    public static double calculateArithmeticMedia(int[] numsOfMedia, int totalNums) {
        double totalSum = 0;
        for (int i = 0; i < totalNums; i++) {
            totalSum += numsOfMedia[i];
        }
        return totalSum / totalNums;
    }

    public static double calculateHarmonicaMedia(int[] numsOfMedia, int totalNums) {
        double totalSum = 0;
        for (int i = 0; i < totalNums; i++) {
            totalSum += 1.0 / numsOfMedia[i];
        }
        return totalNums / totalSum;
    }
}
