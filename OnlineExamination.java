import java.util.*;
class OnlineExamination{
    String fullName;
    String gender;
    String userName;
    String password;
    String phoneNumber;
    int count=0;
    int score=0;
    int attempt=0;
    Scanner input=new Scanner(System.in);
    HashMap<String,String> data=new HashMap<String,String>();
    public void Register(){
        System.out.println("...Registration...");
        System.out.print("Enter Full Name: ");
        this.fullName=input.nextLine();
        System.out.print("Enter Gender(M/F): ");
        this.gender=input.nextLine();
        String gender1="M";
        String gender2="m";
        String gender3="F";
        String gender4="f";
        while(!((((this.gender).equals(gender1)) || ((this.gender).equals(gender2))) || (((this.gender).equals(gender3)) || ((this.gender).equals(gender4))))){
            System.out.print("Invalid...Please enter correct Gender(M/F): ");
            this.gender=input.nextLine();
        }
        if(this.gender.equals(gender1) || this.gender.equals(gender2)){
            this.gender="Male";
        }
        else{
            this.gender="Female";
        }
        System.out.print("Enter Username: ");
        this.userName=input.nextLine();
        System.out.print("Enter Password: ");
        this.password=input.nextLine();
        data.put(this.userName,this.password);
        System.out.print("Enter Phone Number: ");
        this.phoneNumber=input.nextLine();
        while((phoneNumber.length())!=10){
            System.out.print("!!! Please Enter Valid 10 Digit Mobile Number: ");
            this.phoneNumber=input.nextLine();
        }
        System.out.println("Your are Successfully Registered...");
        System.out.println("Please Login to Take Online Exam");
    }
    public boolean Login(){
        boolean log=false;
        System.out.print("Enter your Username: ");
        String Username;
        Username=input.nextLine();
	if(data.containsKey(Username)){
            System.out.print("Enter your Password: ");
            String Pass_Word;
            Pass_Word=input.nextLine();
            if(data.containsKey(Username) && data.containsValue(Pass_Word)){
                System.out.println("Login Successful...");
                log=true;
            }
            else{
                System.out.println("You have Entered Wrong Password...");
            }
	}
	else{
	    System.out.println("User doesn't Exists Please Register first");
	}
        return log;
    }
    public void viewProfile(){
        System.out.println("Your Profile: ");
        System.out.println("Full Name: "+this.fullName);
        System.out.println("Gender: "+this.gender);
        System.out.println("User Name: "+this.userName);
        System.out.println("Password(Don't Share with any one) :"+this.password);
        System.out.println("Phone Number: "+this.phoneNumber);
    }
    public void updateProfile(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Username: ");
        String Username;
        Username=input.nextLine();
        if(Username.equals(this.userName)){
            System.out.println("Select: \n1.To change Username\n2.To change Password");
            int ch;
            System.out.print("Your Option: ");
            ch=input.nextInt();
            switch(ch){
                case 1:updateUsername();
                       break;
                case 2:updatePassWord();
                       break;
                default :System.out.println("Invalid option...");
            }
        }
        else{
            System.out.println("User Does not Exit Please Register First\n");
        }
    }
    public void updateUsername(){
        Scanner input=new Scanner(System.in);
        String User;
        String User1;
        System.out.print("Enter New User Name to Update: ");
        User=input.nextLine();
        if(!(User.equals(this.userName))){
            System.out.print("Conform New User Name to Update: ");
            User1=input.nextLine();
            if(User.equals(User1)){
                System.out.println("Username Updated Successfully...");
                this.userName=User1;
                return;
            }
            else{
                System.out.println("You must type the same Username...");
                updateUsername();
            }
        }
        else{
            System.out.println("New Username and Present Username cannot not be same...");
            updateUsername();
        }
    }
    public void updatePassWord(){
        Scanner input=new Scanner(System.in);
        String Pass;
        String Pass1;
        System.out.print("Enter New Password to Update: ");
        Pass=input.nextLine();
        if(!(Pass.equals(this.password))){
            System.out.print("Conform New Password to Update: ");
            Pass1=input.nextLine();
            if(Pass.equals(Pass1)){
                System.out.println("Password Updated Successfully...");
                this.password=Pass1;
                return;
            }
            else{
                System.out.println("You must type the same Password...");
                updatePassWord();
            }
        }
        else{
            System.out.println("New Password and Present Password cannot not be same...");
            updatePassWord();
        }
    }
    public void takeExam(){
        long examtime=System.currentTimeMillis();
        long endtime=examtime+45*1000;
        int ans;
        int ch;
        System.out.println("Select Subject to take exam: ");
        System.out.println("1.Mathematics\n2.Java Programming\n3.C-Programming Language");
	System.out.print("Your choice: ");
        ch=input.nextInt();
        if(ch==1){
            System.out.println("Welcome to Mathematics Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. 20+(90÷2) = ?");
                System.out.println("Option 1. 50\nOption 2. 55\nOption 3. 65\nOption 4. 60 \n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 2.The product of 82 and 5 = ?");
                System.out.println("Option 1. 400\nOption 2. 410\nOption 3. 420\nOption 4. None of these\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 3. 24÷8+2 = ?");
                System.out.println("Option 1. 5\nOption 2. 6\nOption 3. 8\nOption 4. 12\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 4.What is the average of the first 50 natural numbers ?");
                System.out.println("Option 1. 25.5\nOption 2. 35\nOption 3. 25\nOption 4. 20\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 5. 0/0 = ?");
                System.out.println("Option 1. 0\nOption 2. undefine\nOption 3. not possible\nOption 4. None of the above\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                attempt++;
                break;
            }
        }
        else if(ch==2){
            System.out.println("Welcome to Java Programming Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. Java is developed by : ");
                System.out.println("Option 1. Dennis Ritchie\nOption 2. James Gosling\nOption 3. Guido van Rossum\nOption 4. Bjarne Stroustrup\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 2. Which one of the following is not a java feature? ");
                System.out.println("Option 1. Object-Oriented\nOption 2. Use of pointers\nOption 3. Portable\nOption 4. Dynamic and Extensible\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 3. Which component is used to compile,debug and execute the java programs? ");
                System.out.println("Option 1. JRE\nOption 2. JIT\nOption 3. JDK\nOption 4. JVM\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 4. What is the extension of java code files? ");
                System.out.println("Option 1. .js\nOption 2. .txt\nOption 3. .class\nOption 4. .java\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==4){
                    count++;
                }
                System.out.println("Question 5. Which of the following is not an OOPS concept in java?");
                System.out.println("Option 1. Polymorphism\nOption 2. Inheritance\nOption 3. Compilation\nOption 4. Encapsulation\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                attempt++;
                break;
            }
        }
        else if(ch==3){
            System.out.println("Welcome to C-Programming Language Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. Who is the father of C language? ");
                System.out.println("Option 1. James Gosling\nOption 2. Steve Jobs\nOption 3. Dennis Ritchie\nOption 4. Rasmus Lerdorf\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 2.  Which keyword is used to prevent any changes in the variable within a C program? ");
                System.out.println("Option 1. immutable\nOption 2. mutable\nOption 3. const\nOption 4. volatile\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 3. What is #include <stdio.h>?");
                System.out.println("Option 1. Preprocessor directive\nOption 2. Inclusion directive\nOption 3. File inclusion directive\nOption 4. None of these\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 4. How many number of pointer (*) does C have against a pointer variable declaration? ");
                System.out.println("Option 1. 7\nOption 2. 127\nOption 3. 255\nOption 4. No limits\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==4){
                    count++;
                }
                System.out.println("Question 5. What is the sizeof(char) in a 32-bit C compiler? ");
                System.out.println("Option 1. 1 bit\nOption 2. 2 bits\nOption 3. 1 byte\nOption 4. 2 bytes\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                attempt++;
                break;
            }
        }
        else{
            System.out.println("Invalid option...Please Try Again...");
            takeExam();
        }
    }
    public void viewMarks(){
	int score=((10*count)-((5-count)*5));
	if(score==50){
	    System.out.println("Congratulations....");
	}
	else if(score<50 && score>=35){
	    System.out.println("Well Done...");
	}
	else if(score<35 && score>=20){
	    System.out.println("Well Tried...");
	}
	else if(score<20 && score>=10){
	    System.out.println("Good...");
	}
	else{
	    System.out.println("Ok! Try Again...");
	}
        if(attempt==1){
            System.out.println("Your Score: "+score+"/50");
        }
        else{
            System.out.println("You haven't Written any exam...");
        }
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println("-------WELCOME TO ONLINE EXAMINATION-------");
        System.out.println("Please Register first to write the exam...");
        System.out.println("1.Register(New Users should Register First)\n2.Exit");
        System.out.print("Your choice:");
        int choice;
        choice=input.nextInt();
        if(choice==1){
            OnlineExamination exam=new OnlineExamination();
            exam.Register();
            while(choice==1){
                System.out.println("\n Select any one option: ");
                System.out.println("1.Login(If already Registered)\n2.Exit");
                System.out.print("Your option :");
                int option=input.nextInt();
                if (option==1){
                    if(exam.Login()){
                        while(true){
                            System.out.println("\n\nWelcome to Online Examination");
                            System.out.println("1.View Profile\n2.Update Profile and Password\n3.Take Exam\n4.View Marks\n5.Logout");
                            System.out.print("Enter your option :");
                            int select; 
                            select=input.nextInt();
                            switch(select){
                                case 1 : exam.viewProfile();
                                         break;
                                case 2 : exam.updateProfile();
                                         break;
                                case 3 : exam.takeExam();
                                         break;
                                case 4 : exam.viewMarks();
                                         break;
                                case 5 : System.out.println("\nLogged out Successfully..."); 
                                         System.exit(0);
                                         break;
                                default: System.out.println("Invalid option!...Enter Valid option...");
                            }
                        }
                    }
                }
                else{
                    System.out.println("\nThank you...Visit Again...:)"); 
                    System.exit(0);
                }
            }
        }
        else {
            System.out.println("\nThank you...Visit Again...:)"); 
        	System.exit(0);
        }
    }
}
