package ru.mirea.rodion.tasks4;
import java.util.Scanner;

    public class ServiseUserCommunication {

        public void processingUserCommunication() {

            BigDigits dataBaseBigDigits = new BigDigits();
            SmallStarDigits dataBaseSmallStarDigits = new SmallStarDigits();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите любую положительную цифру.");

            String input = scanner.next();
            char[] userCh = input.toCharArray();

            for (int i = 0; i < userCh.length; i++) {
                if (Character.isDigit(userCh[i])) {
                    char userCh1 = userCh[i];
                }
            }

            int[] userDigit = new int[userCh.length];
            for (int i = 0; i < userCh.length; i++) {
                userDigit[i] = Character.getNumericValue(userCh[i]);
            }

            System.out.println("Вы ввели следующее число:  ");
            for (int i = 0; i < userDigit.length; i++) {
                System.out.print(userDigit[i] + " ");
            }
            System.out.println();

            int max = userDigit [0];
            for (int i = 0; i<userDigit.length; i++){
                if (userDigit[i] > max) max = userDigit[i];
            }

            System.out.println("Ваше число в виде изображений: ");
            for (int i=0; i< userDigit.length; i++){
                if (userDigit[i] == 0){
                    dataBaseSmallStarDigits.createDigitZeroStar();
                    System.out.println();
                }else if (userDigit[i] == 1){
                    dataBaseSmallStarDigits.createDigitOneStar();
                    System.out.println();
                }else if (userDigit[i] == 2){
                    dataBaseSmallStarDigits.createDigitTwoStar();
                    System.out.println();
                }else if (userDigit[i] == 3){
                    dataBaseSmallStarDigits.createDigitThreeStar();
                    System.out.println();
                }else if (userDigit[i] == 4){
                    dataBaseSmallStarDigits.createDigitFourStar();
                    System.out.println();
                }else if (userDigit[i] == 5){
                    dataBaseSmallStarDigits.createDigitFiveStar();
                    System.out.println();
                }else if (userDigit[i] == 6){
                    dataBaseSmallStarDigits.createDigitSixStar();
                    System.out.println();
                }else if (userDigit[i] == 7){
                    dataBaseSmallStarDigits.createDigitSevenStar();
                    System.out.println();
                }else if (userDigit[i] == 8){
                    dataBaseSmallStarDigits.createDigitEightStar();
                    System.out.println();
                }else if (userDigit[i] == 9){
                    dataBaseSmallStarDigits.createDigitNineStar();
                    System.out.println();
                }
            }

            System.out.println("Наибольшее число, введенное вами: " + max);
            if (max == 0) {
                dataBaseBigDigits.createDigitZeroBig();
                System.out.println();
            }else if (max == 1) {
                dataBaseBigDigits.createDigitOneBig();
                System.out.println();
            }else if (max == 2) {
                dataBaseBigDigits.createDigitTwoBig();
                System.out.println();
            }else if (max == 3) {
                dataBaseBigDigits.createDigitThreeBig();
                System.out.println();
            }else if (max == 4) {
                dataBaseBigDigits.createDigitFourBig();
                System.out.println();
            }else if (max == 5) {
                dataBaseBigDigits.createDigitFiveBig();
                System.out.println();
            }else if (max == 6) {
                dataBaseBigDigits.createDigitSixBig();
                System.out.println();
            }else if (max == 7) {
                dataBaseBigDigits.createDigitSevenBig();
                System.out.println();
            }else if (max == 8) {
                dataBaseBigDigits.createDigitEightBig();
                System.out.println();
            }else if (max == 9) {
                dataBaseBigDigits.createDigitNineBig();
                System.out.println();
            }
        }
    }

