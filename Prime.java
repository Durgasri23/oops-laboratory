//Durgasri S
//2117240070081
program title:prime number checker
  Tc:1
  public class Prime{
    public static void main(String[] args) {
        int n=2;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  output:Prime
  Tc:2
  public class Prime{
    public static void main(String[] args) {
        int n=15;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  output:Not Prime
    Tc:3
  public class Prime{
    public static void main(String[] args) {
        int n=17;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  output:Prime
    Tc:4
  public class Prime{
    public static void main(String[] args) {
        int n=1;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  output:Not Prime
    Tc:5
  public class Prime{
    public static void main(String[] args) {
        int n=0;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  output:Not Prime
