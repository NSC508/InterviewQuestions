public class ReverseInteger {
    public static void main(String[] args) {
        int result = characterToInt('1') + characterToInt('2');
        System.out.println(result);
    }

    //public int reverseInteger(int toBeReversed) {
        //int temporary = 
    //}

    public static int characterToInt(char a) {
        switch (a) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
        }
        return -1;
    }
}
