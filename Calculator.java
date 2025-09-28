class Operations{
      
      int add(int a, int b){
        return a+b;
      }

      int sub(int a, int b){
        return a-b;
      }

      int mul(int a, int b){
        return a*b;
      }

      int div(int a, int b)
      {
        if(b==0){
            System.out.println("Cannot be divided by denominator zero");
        }
        return a/b;
      }

}




public class Calculator{
    public static void main(String args[]){
           int a = 10;
           int b = 5;
           Operations obj = new Operations();
           int result = obj.add(a,b);
           System.out.println(result);
           
    }
}