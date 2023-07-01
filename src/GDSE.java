import java.util.Scanner;
public class GDSE {
    static String[][] dataSetString = new String[2][100];
    static int[][] dataSetInt= new int[4][100];
    static int top=0;
    Scanner input2 = new Scanner(System.in);

    public static void clearConsole() {
      try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
    private static int sortAccordingtoRank() {
        int lastRank=-1;
        //sorting according to total
        for (int i = 0; i < top-2; i++) {
            for (int j = 0; j < top-(i+1); j++) {
                if((dataSetInt[0][i]+dataSetInt[1][i])<(dataSetInt[0][i+1]+dataSetInt[1][i+1])){
                    int tempProgramming=dataSetInt[0][i+1];
                    int tempDatabase=dataSetInt[1][i+1];
                    int tempRank=dataSetInt[2][i+1];
                    int tempHasMarksEntered=dataSetInt[3][i+1];
                    String tempStdID=dataSetString[0][i+1];
                    String tempName=dataSetString[1][i+1];

                    dataSetInt[0][i+1]=dataSetInt[0][i];
                    dataSetInt[1][i+1]=dataSetInt[1][i];
                    dataSetInt[2][i+1]=dataSetInt[2][i];
                    dataSetInt[3][i+1]=dataSetInt[3][i];
                    dataSetString[0][i+1]=dataSetString[0][i];
                    dataSetString[1][i+1]=dataSetString[1][i];

                    dataSetInt[0][i]=tempProgramming;
                    dataSetInt[1][i]=tempDatabase;
                    dataSetInt[2][i]=tempRank;
                    dataSetInt[3][i]=tempHasMarksEntered;
                    dataSetString[0][i]=tempStdID;
                    dataSetString[1][i]=tempName;
                }
            }
        }
        //inserting rank to every student
        for (int i = 0; i < top; i++) {
            dataSetInt[2][i]=i+1;
        }
        //finding last rank
        lastRank=dataSetInt[2][top-1];
        return lastRank;
    }
    private static void sortAccordingtoProgramming() {
        //sorting according to marks of programming
        for (int i = 0; i < top-2; i++) {
            for (int j = 0; j < top-(i+1); j++) {
                if((dataSetInt[0][i])<(dataSetInt[0][i+1])){
                    int tempProgramming=dataSetInt[0][i+1];
                    int tempDatabase=dataSetInt[1][i+1];
                    int tempRank=dataSetInt[2][i+1];
                    int tempHasMarksEntered=dataSetInt[3][i+1];
                    String tempStdID=dataSetString[0][i+1];
                    String tempName=dataSetString[1][i+1];

                    dataSetInt[0][i+1]=dataSetInt[0][i];
                    dataSetInt[1][i+1]=dataSetInt[1][i];
                    dataSetInt[2][i+1]=dataSetInt[2][i];
                    dataSetInt[3][i+1]=dataSetInt[3][i];
                    dataSetString[0][i+1]=dataSetString[0][i];
                    dataSetString[1][i+1]=dataSetString[1][i];

                    dataSetInt[0][i]=tempProgramming;
                    dataSetInt[1][i]=tempDatabase;
                    dataSetInt[2][i]=tempRank;
                    dataSetInt[3][i]=tempHasMarksEntered;
                    dataSetString[0][i]=tempStdID;
                    dataSetString[1][i]=tempName;
                }
            }
        }

    }
    private static void sortAccordingtoDatabase() {
        //sorting according to marks of database
        for (int i = 0; i < top-2; i++) {
            for (int j = 0; j < top-(i+1); j++) {
                if((dataSetInt[1][i])<(dataSetInt[1][i+1])){
                    int tempProgramming=dataSetInt[0][i+1];
                    int tempDatabase=dataSetInt[1][i+1];
                    int tempRank=dataSetInt[2][i+1];
                    int tempHasMarksEntered=dataSetInt[3][i+1];
                    String tempStdID=dataSetString[0][i+1];
                    String tempName=dataSetString[1][i+1];

                    dataSetInt[0][i+1]=dataSetInt[0][i];
                    dataSetInt[1][i+1]=dataSetInt[1][i];
                    dataSetInt[2][i+1]=dataSetInt[2][i];
                    dataSetInt[3][i+1]=dataSetInt[3][i];
                    dataSetString[0][i+1]=dataSetString[0][i];
                    dataSetString[1][i+1]=dataSetString[1][i];

                    dataSetInt[0][i]=tempProgramming;
                    dataSetInt[1][i]=tempDatabase;
                    dataSetInt[2][i]=tempRank;
                    dataSetInt[3][i]=tempHasMarksEntered;
                    dataSetString[0][i]=tempStdID;
                    dataSetString[1][i]=tempName;
                }
            }
        }
    }
    public static boolean searchWithStdID(String stdID){
        boolean isExists=false;
        for (int i = 0; i < top; i++) {
            if(dataSetString[0][i].equals(stdID)){
                isExists=true;
                break;
            }
        }
        return isExists;
    }

    public static void addNewStudentWithMarks(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                          ADD NEW STUDENT WITH MARKS                                |");
        System.out.println("-------------------------------------------------------------------------------------");
        Scanner input2 = new Scanner(System.in);
        System.out.print("\nEnter Student ID  :    ");
        String stdID= input2.nextLine();
        //searching whether student id exists or not

        if(!searchWithStdID(stdID)){
            System.out.print("Enter Student name  :    ");
            String name= input2.nextLine();
            System.out.print("Programming Fundementals Marks : ");
            int programming =input2.nextInt();
            while((programming<0)||(programming>100)){
                System.out.println("Invalid marks please enter correct marks\n");
                System.out.print("Programming Fundementals Marks : ");
                programming =input2.nextInt();
            }

            System.out.print("Database Management Systems Marks : ");
            int database =input2.nextInt();
            while((database<0)||(database>100)){
                System.out.println("Invalid marks please enter correct marks\n");
                System.out.print("Database Management Systems Marks : ");
                database =input2.nextInt();
            }

            dataSetString[0][top]=stdID;
            dataSetString[1][top]=name;
            dataSetInt[0][top]=programming;
            dataSetInt[1][top]=database;
            dataSetInt[3][top]=1;
            System.out.println("std id : "+ dataSetString[0][top]);
            System.out.println("std name : "+ dataSetString[1][top]);
            System.out.println("programming fundementals marks : "+ dataSetInt[0][top]);
            System.out.println("database management systems marks : "+ dataSetInt[1][top]);

            top++;
            System.out.println("Top is : "+top);
            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                addNewStudentWithMarks();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }else{
            System.out.println("The student id already exists.\n");
            addNewStudentWithMarks();
        }
    }

    public static void addNewStudent(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                ADD NEW STUDENT                                    |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("Enter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID= input2.nextLine();
        //searching whether student id exists or not
        if(!searchWithStdID(stdID)){
            System.out.print("Enter Student name  :    ");
            String name= input2.nextLine();
            dataSetString[0][top]=stdID;
            dataSetString[1][top]=name;
            System.out.println("std id : "+ dataSetString[0][top]);
            System.out.println("std name : "+ dataSetString[1][top]);
            top++;
            System.out.println("Top is : "+top);
            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                addNewStudent();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }else{
            System.out.println("The student id already exists.\n");
            addNewStudent();
        }

    }
    public static void addMarks(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                    ADD MARKS                                       |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("\nEnter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID= input2.nextLine();
        //searching whether student id exists or not
        int position=-1;
        for (int i = 0; i < top; i++) {
            if(dataSetString[0][i].equals(stdID)){
                position=i;
                System.out.println("Student  Name : "+dataSetString[1][i]);

                if(dataSetInt[3][i]==1){
                    System.out.println("This student's marks already added.\nIf you want to update marks use [4] Update marks option\n");
                    System.out.print("Do you want to add marks for another student? (Y/N) : ");
                    char option= input2.next().charAt(0);;
                    if(option=='Y'){
                        addMarks();
                    }else if(option=='N'){

                    }else{
                        System.out.println("Invalid Choice.");
                    }
                }else{
                    System.out.print("\nProgramming Fundementals Marks : ");
                    int programming =input2.nextInt();
                    while((programming<0)||(programming>100)){
                        System.out.println("Invalid marks please enter correct marks\n");
                        System.out.print("Programming Fundementals Marks : ");
                        programming =input2.nextInt();
                    }

                    System.out.print("Database Management Systems Marks : ");
                    int database =input2.nextInt();
                    while((database<0)||(database>100)){
                        System.out.println("Invalid marks please enter correct marks\n");
                        System.out.print("Database Management Systems Marks : ");
                        database =input2.nextInt();
                    }
                    dataSetInt[0][position]=programming;
                    dataSetInt[1][position]=database;
                    dataSetInt[3][position]=1;
                    System.out.print("Marks have been added. Do you want to add marks for another student? (Y/N) : ");
                    char option= input2.next().charAt(0);;
                    if(option=='Y'){
                        addMarks();
                    }else if(option=='N'){

                    }else{
                        System.out.println("Invalid Choice.");
                    }
                    break;
                }
            }
        }
        if(position==-1){
            System.out.println("\nInvalid Student ID. Do you want to search again? (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                addMarks();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }


    }
    public static void updateStudentDetails() {
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                            UPDATE STUDENT DETAILS                                 |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("\nEnter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID = input2.nextLine();
        //searching whether student id exists or not
        int position = -1;
        for (int i = 0; i < top; i++) {
            if (dataSetString[0][i].equals(stdID)) {
                position = i;
                System.out.println("Student  Name : " + dataSetString[1][i]);
                System.out.print("\nEnter the new student name : ");
                String name= input2.nextLine();
                dataSetString[1][position]=name;
                System.out.println("Student details has been added successfully.\nDo you want to update another student details? (Y/N) : ");
                char option= input2.next().charAt(0);;
                if(option=='Y'){
                    updateStudentDetails();
                }else if(option=='N'){

                }else{
                    System.out.println("Invalid Choice.");
                }
                break;
            }
        }
        if(position==-1){
            System.out.println("Invalid Student ID. Do you want to search again (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                updateStudentDetails();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }
    }

    public static void updateMarks(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                UPDATE MARKS                                       |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("\nEnter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID = input2.nextLine();
        //searching whether student id exists or not
        int position = -1;
        for (int i = 0; i < top; i++) {
            if (dataSetString[0][i].equals(stdID)) {
                position = i;
                System.out.println("Student  Name : " + dataSetString[1][i]);
                System.out.println("Programming fundementals marks : " + dataSetInt[0][i]);
                System.out.println("Database management systems marks : " + dataSetInt[1][i]);
                System.out.print("\nEnter new Programming Fundementals Marks : ");
                int programming =input2.nextInt();
                while((programming<0)||(programming>100)){
                    System.out.println("Invalid marks please enter correct marks\n");
                    System.out.print("Programming Fundementals Marks : ");
                    programming =input2.nextInt();
                }

                System.out.print("Enter new Database Management Systems Marks : ");
                int database =input2.nextInt();
                while((database<0)||(database>100)){
                    System.out.println("Invalid marks please enter correct marks\n");
                    System.out.print("Database Management Systems Marks : ");
                    database =input2.nextInt();
                }
                dataSetInt[0][position]=programming;
                dataSetInt[1][position]=database;
                System.out.println("Marks have been added successfully.\nDo you want to update marks for another student? (Y/N) : ");
                char option= input2.next().charAt(0);;
                if(option=='Y'){
                    updateMarks();
                }else if(option=='N'){

                }else{
                    System.out.println("Invalid Choice.");
                }
                break;
            }
        }
        if(position==-1){
            System.out.println("Invalid Student ID. Do you want to search again (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                updateMarks();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }
    }
    public static void deleteStudent(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                DELETE STUDENT                                     |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("Enter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID = input2.nextLine();
        //searching whether student id exists or not
        int position = -1;
        for (int i = 0; i < top; i++) {
            if (dataSetString[0][i].equals(stdID)) {
                position = i;
                for (int j = position; j < top; j++) {
                    dataSetString[0][position]=dataSetString[0][position+1];
                    dataSetString[1][position]=dataSetString[1][position+1];
                    dataSetInt[0][position]=dataSetInt[0][position+1];
                    dataSetInt[1][position]=dataSetInt[1][position+1];
                    dataSetInt[2][position]=dataSetInt[2][position+1];
                    dataSetInt[3][position]=dataSetInt[3][position+1];
                }
                top--;
                System.out.println("Student has been deleted successfully\nDO you want to delete another student? (Y/N) : ");
                char option= input2.next().charAt(0);;
                if(option=='Y'){
                    deleteStudent();
                }else if(option=='N'){

                }else{
                    System.out.println("Invalid Choice.");
                }
                break;
            }
        }
        if(position==-1){
            System.out.print("Invalid Student ID. Do you want to search again (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                deleteStudent();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }
    }
    public static void printStudentDetails(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                               PRINT STUDENT DETAILS                               |");
        System.out.println("-------------------------------------------------------------------------------------");
        int lastRank = sortAccordingtoRank();
        System.out.print("\nEnter Student ID  :    ");
        Scanner input2 = new Scanner(System.in);
        String stdID = input2.nextLine();
        //searching whether student id exists or not
        int position = -1;
        for (int i = 0; i < top; i++) {
            if (dataSetString[0][i].equals(stdID)) {
                position = i;
                System.out.println("Student Name : "+dataSetString[1][i]);
                System.out.println("----------------------------------------------------------------");
                System.out.println("Programming fundementals marks              |            " + dataSetInt[0][i]);
                System.out.println("Database management systems marks           |            " + dataSetInt[1][i]);
                System.out.println("Total marks                                 |            "+(dataSetInt[0][i]+dataSetInt[1][i]));
                System.out.println("Avg marks :                                 |            "+(dataSetInt[0][i]+dataSetInt[1][i])/2);

                System.out.println(dataSetInt[2][i]==1? "Rank                                       |               1 (First)" :
                        dataSetInt[2][i]==2? "Rank                                       |               2 (Second)":
                                dataSetInt[2][i]==3? "Rank                                       |               3 (Third)":
                                        dataSetInt[2][i]==dataSetInt[2][top-1] ? "Rank                                        |               "+dataSetInt[2][top-1]+" (Last)" :
                                                "Rank                                        |               "+dataSetInt[2][i]);


                System.out.println("----------------------------------------------------------------\n");
                System.out.println("Do you want to search another student? (Y/N) : ");
                char option= input2.next().charAt(0);;
                if(option=='Y'){
                    printStudentDetails();
                }else if(option=='N'){

                }else{
                    System.out.println("Invalid Choice.");
                }

                break;
            }
        }
        if(position==-1){
            System.out.println("Marks yet to be added");
            System.out.print("\nDo you want to search another student? (Y/N) : ");
            char option= input2.next().charAt(0);;
            if(option=='Y'){
                printStudentDetails();
            }else if(option=='N'){

            }else{
                System.out.println("Invalid Choice.");
            }
        }


    }
    public static void printStudentRanks(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                PRINT STUDENT RANKS                                |");
        System.out.println("-------------------------------------------------------------------------------------\n");
        int lastRank = sortAccordingtoRank();
        System.out.println("Rank\t\tID\t\tName\t\tTotal Marks\t\tAvg Marks");
        for (int i = 0; i < top; i++) {
            System.out.println(dataSetInt[2][i]+"\t\t"+dataSetString[0][i]+"\t\t"+dataSetString[1][i]+"\t\t"+(dataSetInt[0][i]+dataSetInt[1][i])+"\t\t"+(dataSetInt[0][i]+dataSetInt[1][i])/2.0);
        }
        System.out.println("\nDo you want to go back to main menu? (Y/N)");
        Scanner input2 = new Scanner(System.in);
        char option= input2.next().charAt(0);;
        if(option=='Y'){

        }else if(option=='N'){
            printStudentRanks();
        }else{
            System.out.println("Invalid Choice.");
            printStudentRanks();
        }
    }
    public static void showBestInProgrammingFundementals(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                         SHOW BEST IN PROGRAMMING FUNDEMENTALS                     |");
        System.out.println("-------------------------------------------------------------------------------------\n");
        sortAccordingtoProgramming();
        System.out.println("ID\t\tName\t\tPF Marks\t\tDBMS Marks");
        for (int i = 0; i < top; i++) {
            if(dataSetInt[3][i]==1) {
                System.out.println(dataSetString[0][i]+"\t\t"+dataSetString[1][i]+"\t\t"+dataSetInt[0][i]+"\t\t"+dataSetInt[1][i]);
            }
        }
        System.out.println("\nDo you want to go back to main menu? (Y/N)");
        Scanner input2 = new Scanner(System.in);
        char option= input2.next().charAt(0);;
        if(option=='Y'){

        }else if(option=='N'){
            showBestInProgrammingFundementals();
        }else{
            System.out.println("Invalid Choice.");
            showBestInProgrammingFundementals();
        }

    }
    public static void showBestInDatabaseManagementSystems(){
        clearConsole();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                        SHOW BEST IN DATABASE MANAGEMENT SYSTEMS                   |");
        System.out.println("-------------------------------------------------------------------------------------\n");
        sortAccordingtoDatabase();
        System.out.println("ID\t\tName\t\tDBMS Marks\t\tPF Marks");
        for (int i = 0; i < top; i++) {
            if(dataSetInt[3][i]==1) {
                System.out.println(dataSetString[0][i]+"\t\t"+dataSetString[1][i]+"\t\t"+dataSetInt[1][i]+"\t\t"+dataSetInt[0][i]);
            }
        }
        System.out.println("\nDo you want to go back to main menu? (Y/N)");
        Scanner input2 = new Scanner(System.in);
        char option= input2.next().charAt(0);;
        if(option=='Y'){

        }else if(option=='N'){
            showBestInDatabaseManagementSystems();
        }else{
            System.out.println("Invalid Choice.");
            showBestInDatabaseManagementSystems();
        }
    }
    public static void  main (String args[]){

       System.out.println("-------------------------------------------------------------------------------------");
       System.out.println("|                     WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                         |");
       System.out.println("-------------------------------------------------------------------------------------");
       System.out.println("[1] Add New Student                              [2] Add New Student with marks");
       System.out.println("[3] Add Marks                                    [4] Update Student details");
       System.out.println("[5] Update Marks                                 [6] Delete Student");
       System.out.println("[7] Print student details                        [8] Print Student Ranks");
       System.out.println("[9] Best in Programming fundementals             [10] Best in Database Management Systems\n\n");
       System.out.print("Enter an Option to Continue >");
       Scanner input=new Scanner(System.in);
       int choice= input.nextInt();

       while (true){
           switch (choice) {
               case 1:
                   clearConsole();
                   System.out.println("System is adding a New Student....");
                   addNewStudent();
                   break;
               case 2:
                   clearConsole();
                   System.out.println("System is adding a New Student with marks....");
                   addNewStudentWithMarks();
                   break;
               case 3:
                   clearConsole();
                   System.out.println("System is adding Marks....");
                   addMarks();
                   break;
               case 4:
                   clearConsole();
                   System.out.println("System is Updating Student details....");
                   updateStudentDetails();
                   break;
               case 5:
                   clearConsole();
                   System.out.println("System is Updating Marks....");
                   updateMarks();
                   break;
               case 6:
                   clearConsole();
                   System.out.println("System is Deleting Student....");
                   deleteStudent();
                   break;
               case 7:
                   clearConsole();
                   System.out.println("System is Printing student details....");
                   printStudentDetails();
                   break;
               case 8:
                   clearConsole();
                   System.out.println("System is Printing student ranks....");
                   printStudentRanks();
                   break;
               case 9:
                   clearConsole();
                   System.out.println("System is showing Best in Programming fundementals....");
                   showBestInProgrammingFundementals();
                   break;
               case 10:
                   clearConsole();
                   System.out.println("System is showing Best in Database Management Systems....");
                   showBestInDatabaseManagementSystems();
                   break;
               default:
                   clearConsole();
                   System.out.println("Invalid choice try again....");
           }
                   System.out.println("-------------------------------------------------------------------------------------");
                   System.out.println("|                     WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                         |");
                   System.out.println("-------------------------------------------------------------------------------------");
                   System.out.println("[1] Add New Student                              [2] Add New Student with marks");
                   System.out.println("[3] Add Marks                                    [4] Update Student details");
                   System.out.println("[5] Update Marks                                 [6] Delete Student");
                   System.out.println("[7] Print student details                        [8] Print Student Ranks");
                   System.out.println("[9] Best in Programming fundementals             [10] Best in Database Management Systems\n\n");
                   System.out.print("Enter an Option to Continue >");
                   choice= input.nextInt();

       }
    }
}
