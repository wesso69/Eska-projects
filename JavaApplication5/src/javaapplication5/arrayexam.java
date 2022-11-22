package javaapplication5;

public class arrayexam {

   static class test {

        int s = 10;

        test() {}

        public void print() {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test obj = new test();
        obj.print();
    }
}
