public class ReverseString {
    public static void main(String[] args) {
        //тут задание 2
        Stack mStack = new Stack(10);
        String someString = "some_text";
        for (int i = 0; i < someString.length(); i++) {
            mStack.addElement(Character.toString(someString.charAt(i)));
        }
        someString = "";
        while (!mStack.isEmpty()){
            someString += mStack.deleteElement();
        }
        System.out.println(someString);
    }
}
