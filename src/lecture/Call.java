public class Call {
    public static void main(String[] args) {
        //출력을 예상해 보자
        int primitiveNumber = 1;
        int[] numbers = {1, 2, 3, 4, 5};

        NumberSet ns = new NumberSet();
        change(primitiveNumber, numbers, ns);
        System.out.println(primitiveNumber);
        System.out.println(numbers[0]);
        System.out.println(ns.primitiveNumber);
        System.out.println(ns.numbers[0]);
        change(ns.primitiveNumber, ns.numbers, null);
        System.out.println(ns.primitiveNumber);
        System.out.println(ns.numbers[0]);


    }

    public static class NumberSet {
        int primitiveNumber = 1;
        Integer wrapperNumber = 2;
        int[] numbers = {1, 2, 3, 4, 5};
    }

    public static void change(int primitiveNumber,  int[] numbers, NumberSet ns) {
        primitiveNumber = primitiveNumber + 1;
        numbers[0] = numbers[0] + 1;
        if (ns != null) {
            ns.primitiveNumber = ns.primitiveNumber + 1;
            ns.numbers[0] = ns.numbers[0] + 1;
        }
    }
}

