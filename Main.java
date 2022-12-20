public class Main {

    public static void main(String[] args) {
        int[] arr1 = { 8, 26, 45, 4, 90, 79 };
        int[] arr2 = { 1, 19, 22, 2, 7, 11 };

        try {
            outputArr(check(arr1, arr2));
        } catch (Exception e) {
            switch (Integer.parseInt(e.getMessage())) {
                case -1 -> System.out.println("разная длина массивов");
                case -2 -> System.out.println("делить на 0 нельзя");
                case -3 -> System.out.println("слишком большие значения");
                case -4 -> System.out.println("значения отрицательны");
                case -5 -> System.out.println("Не делятся нацело");

            }

        }

    }

    public static int[] taskDiv(int[] array1, int[] array2) {
        int[] resultArr = new int[Math.max(array1.length, array2.length)];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = array1[i] / array2[i];
        }
        return resultArr;
    }

    public static void outputArr(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static boolean containZero(int[] array) {
        boolean result = false;
        int i = 0;
        while ((i < array.length) && (!result)) {
            if (array[i] == 0) {
                result = true;
            } else {
                i++;
            }

        }
        return result;
    }

    public static boolean tooMuch(int[] array1, int[] array2) {
        boolean result = false;
        int i = 0;
        while ((i < array1.length) && (!result)) {
            if ((array1[i] / array2[i]) >= 100) {
                result = true;
            } else {
                i++;
            }

        }
        return result;

    }

    public static boolean lessThanZero(int[] array1, int[] array2) {
        boolean result = false;
        int i = 0;
        while ((i < array1.length) && (!result)) {
            if ((array1[i] / array2[i]) <= 0) {
                result = true;
            } else {
                i++;
            }

        }
        return result;
    }

    public static boolean isDivisible(int[] array1, int[] array2) {
        boolean result = true;
        int i = 0;
        while ((i < array1.length) && (result)) {
            if ((array1[i] % array2[i]) != 0) {
                result = false;
            } else {
                i++;
            }

        }
        return result;
    }

    public static int[] check(int[] array1, int[] array2) throws Exception {
        if (array1.length != array2.length) {
            throw new Exception("-1");
        }
        if (containZero(array2) == true) {
            throw new Exception("-2");

        }
        if (tooMuch(array1, array2)) {
            throw new Exception("-3");
        }

        if (lessThanZero(array1, array2)) {
            throw new Exception("-4");
        }

        if (!isDivisible(array1, array2)) {
            throw new Exception("-5");

        }

        return taskDiv(array1, array2);

    }

}
