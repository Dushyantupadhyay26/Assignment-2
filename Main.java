package com.company;

import java.util.*;
import java.util.logging.Handler;


class add_lec{
    String topic;
    String content;
    int slide;
    int num;
    java.util.Date date;
    String inst;


    @Override
    public String toString() {
        return "Title: "+topic+"\nSlide "+slide+": "+content+"\nNumber of slides: "+num+"\nDate of upload: "+date+"\nUploaded by: "+inst+"\n";
    }

    public add_lec(String topic, int slide, String content, int num, Date date, String inst) {
        this.topic = topic;
        this.slide = slide;
        this.content = content;
        this.num = num;
        this.date = date;
        this.inst = inst;
    }



    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public int getSlide() {
        return slide;
    }

    public void setSlide(int slide) {
        this.slide = slide;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
class add_ved{
    String video;
    String file;
    Date dat;
    String inst;

    public add_ved(String video, String file, Date dat,String inst) {
        this.video = video;
        this.file = file;
        this.dat = dat;
        this.inst = inst;
    }

    @Override
    public String toString() {
        return "\nTitle of video: " + video + "\nVideo file: " + file + "\nDate of upload: " + dat+"\nUploaded by: "+inst+"\n";
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }
}
class assignment{
    int num;
    int id;
    boolean check ;
    String problem;
    int marks;

    public assignment(int num, String problem, int marks) {
        this.num = num;
        this.problem = problem;
        this.marks = marks;
    }

    public assignment(int id) {
        this.id = id;
    }

    public void check(){
        if(id==num) {
            check = true;
        }
        else{ check = false;}
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: "+num+" Assignment: "+problem+" Max Marks: "+marks;
    }
}
class quiz{
    public int numb;
    String qus;
    int y;


    public quiz(int numb, String qus) {
        this.numb = numb;
        this.qus = qus;
    }
    public quiz(){
        return;
    }

    public quiz(int y) {
        this.y = y;
    }



    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    @Override
    public String toString() {
        return "ID: "+numb+" Question: "+qus;
    }
}
class comment{
    String com;
    Date date;
    String per;

    public comment(String com,String per, Date date) {
        this.com = com;
        this.per = per;
        this.date = date;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return com+" - "+per+"\n"+date+"\n";
    }
}
interface comments{
    void Add_comments(String per);
    void View_comments();
}
class instructor implements comments{
    Scanner sc = new Scanner(System.in);
    static int count = 0;

    static List<add_lec> temp = new ArrayList<>();
    static HashMap<String,String > sub_assign = new HashMap<>();
    static HashMap<String,String> sub_quiz = new HashMap<>();
    static List<add_ved> vid = new ArrayList<>();
    static List<assignment> assig = new ArrayList<>();
    static List<quiz> test = new ArrayList<>();
    static List<comment> add_comm = new ArrayList<>();

    static Map<String,List<assignment>> student = new HashMap<>();
    static Map<String,List<quiz>> k = new HashMap<>();
//    static Map<String,String> s2 = new HashMap<>();


    public void Add_class_material(String inst){

        System.out.println("1.Add Lecture Slide\n2.Add Lecture Video");
        int mat = sc.nextInt();
        if(mat==1){
            System.out.print("Enter topic of slides: ");
            sc.nextLine();
            String topic = sc.nextLine();
            Date date = new Date();
            System.out.print("Enter number of slides: ");
            int num = sc.nextInt();
            System.out.println("Enter content of slides");
            add_lec k;
            for(int i=1;i<=num;i++){
                System.out.print("content of slide "+i+": ");

                String cont = sc.nextLine();
                sc.nextLine();
                k = new add_lec(topic,i,cont,num,date,inst);
                temp.add(k);
            }

        }
        else if(mat==2){
            System.out.print("Enter topic of video: ");
            sc.nextLine();
            String video = sc.nextLine();
            System.out.print("Enter filename of video: ");
            String file = sc.nextLine();
            Date date = new Date();
            int a;
            a = file.indexOf(".mp4");
            add_ved l = new add_ved(video,file,date,inst);
            vid.add(l);
            while(a==-1){
                System.out.println("Enter valid file extention. Only  in mp4");
                System.out.print("Enter filename of video: ");
                file = sc.nextLine();
                a = file.indexOf(".mp4");

            }

        }
    }
    public void Add_assissments(){

        System.out.println("1.Add Assignment\n2.Add Quiz");
        int option = sc.nextInt();
        if(option==1){
            System.out.print("Enter problem statement: ");
            sc.nextLine();
            String prob = sc.nextLine();
            System.out.print("Enter max marks: ");
            int marks = sc.nextInt();
            assignment a = new assignment(count,prob,marks);
            assig.add(a);
            student.put("s0",assig);
            student.put("s1",assig);
            student.put("s2",assig);



        }
        else if(option==2){
            System.out.print("Enter quiz question: ");
            sc.nextLine();
            String qus = sc.nextLine();
            quiz q = new quiz(count,qus);
            test.add(q);
            k.put("s0",test);
            k.put("s1",test);
            k.put("s2",test);


        }
        else{
            System.out.println("Enter correct option\n1.Add Assignment\n2.Add Quiz");
            option = sc.nextInt();
        }
        count += 1;
        
    }
    public void view_lec_material(){
        temp.forEach(t -> System.out.println(t));
        vid.forEach(x -> System.out.println(x));
    }

    public void view_assessments(){
        assig.forEach(t -> System.out.println(t));
        System.out.println("-----------");
        test.forEach(x -> System.out.println(x));
        System.out.println("-----------");

    }

    public void grade(){
        System.out.println("List of assessmnets");
        assig.forEach(t -> System.out.println(t));
        System.out.println("-----------");
        test.forEach(x -> System.out.println(x));
        System.out.println("-----------");
        System.out.print("Enter ID of assessment to view submissions: ");
        int id = sc.nextInt();
        assignment a = new assignment(id);
        a.check();
        if(a.check==true){
            System.out.println("Choose ID from these ungraded submissions");
            System.out.print("Submission: "+sub_assign.get("s0"));
            System.out.println("-------------------");
            System.out.print("Marks scored: ");
            int score = sc.nextInt();

        }
    }
    public void close_assessment(){
        System.out.println("List of open Assignments:");
        assig.forEach(t -> System.out.println(t));
        System.out.println("-----------");
        test.forEach(x -> System.out.println(x));
        System.out.println("-----------");
        System.out.println("Enter id of assignment to close: ");
        int id = sc.nextInt();
        temp.remove(id);
        vid.remove(id);


    }
    public void Add_comments(String per){
        System.out.print("Enter comment: ");
        String add = sc.nextLine();
        java.util.Date date = new java.util.Date();
        comment c = new comment(add,per,date);
        add_comm.add(c);

    }
    public void View_comments(){
        add_comm.forEach(t -> System.out.println(t));
    }
}

class student implements comments{
    instructor s = new instructor();
    Scanner sc = new Scanner(System.in);

    public void view_lec_material(){
        instructor.temp.forEach(t -> System.out.println(t));
        instructor.vid.forEach(x -> System.out.println(x));
    }

    public void view_assessments(String stu){
        System.out.println(instructor.student.get(stu));
//        instructor.assig.forEach(t -> System.out.println(t));
        System.out.println("-----------");
        System.out.println(instructor.k.get(stu));
//        instructor.test.forEach(x -> System.out.println(x));
        System.out.println("-----------");
    }

    public void sub_assessments(String stud){

        System.out.println("Pending assessments");
        instructor.assig.forEach(t -> System.out.println(t));
        instructor.test.forEach(x -> System.out.println(x));
        System.out.print("Enter ID of assessment: ");
        int option = sc.nextInt();
        assignment a = new assignment(option);
        quiz q = new quiz();
        if(option==a.num){
            System.out.print("Enter filename of assignment: ");
            sc.nextLine();
            String file = sc.nextLine();
            int ext = file.indexOf(".zip");
            while(ext==-1){
                System.out.println("Enter valid file extention. only in zip");
                System.out.print("Enter filename of assignment: ");
                file = sc.nextLine();
                ext = file.indexOf(".zip");
                instructor.sub_assign.put(stud,file);
                instructor.student.remove(stud);
            }
        }
        else if(option==q.numb){

            System.out.print(q.qus+" ");
            String ans = sc.next();
            instructor.sub_quiz.put(stud,ans);
            instructor.k.remove(stud);
        }


    }

    public void view_grade(){

    }
    public void Add_comments(String per){
        System.out.print("Enter comment: ");
        String add = sc.nextLine();
        java.util.Date date = new java.util.Date();
        comment c = new comment(add,per,date);
        s.add_comm.add(c);

    }

    public void View_comments(){
        s.add_comm.forEach(t -> System.out.println(t));
    }

}
class Menu{
    Scanner sc = new Scanner(System.in);
    int option1;
    int option2;
    int option3;
    int choose1;
    int choose2;
    public void pack(){
        System.out.println("Welcome to Backpack\n1.Enter as instructor\n2.Enter as Student\n3.Exit");
        option1 = sc.nextInt();
    }

    public void ins(){
        System.out.print("Instructors\n0-I0\n1-I1\nChoose id: ");
        option2 = sc.nextInt();
    }

    public void stu(){
        System.out.print("Students:\n0-S0\n1-S1\n2-S2\nChoose id ");
        option3 = sc.nextInt();
    }

    public void I0(){
        choose1 = sc.nextInt();
    }

    public void I1(){
        choose1 = sc.nextInt();
    }

    public void s0(){

        choose2 = sc.nextInt();
    }

    public void s1(){
        choose2 = sc.nextInt();
    }

    public void s2(){
        choose2 = sc.nextInt();
    }
    public void print(String ins) {
        System.out.println("Welcome "+ins);
        System.out.println("1.Add class material\n2.Add assessments\n3.View lecture materials\n4.View assessments\n5.Grade assessments\n6.Close assessments\n7.View comments\n8.Add comments\n9.Logout");
    }

    public void print1(String stu) {
        System.out.println("Welcome "+stu);
        System.out.println("1.View lecture materials\n2.View assessments\n3.Submit assessments\n4.View grades\n5.View comments\n6.Add comments\n7.Logout");
    }
}

public class Main {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu m = new menu();
        instructor i = new instructor();
        student s = new student();
        

        while(m.option1!=3) {
            m.pack();
            if (m.option1 == 1) {
                m.ins();
                if (m.option2 == 0) {

                    while (m.choose1 != 9) {
                        m.I0();
                        switch (m.choose1) {
                            case 1:
                                System.out.println("Welcome I0");
                                i.Add_class_material("I0");

                                break;
                            case 2:
                                System.out.println("Welcome I0");
                                i.Add_assissments();
                                break;
                            case 3:
                                System.out.println("Welcome I0");
                                i.view_lec_material();
                                break;
                            case 4:
                                System.out.println("Welcome I0");
                                i.view_assessments();
                                break;
                            case 5:
                                System.out.println("Welcome I0");
                                i.grade();
//                                System.out.println("1.Add class material\n2.Add assessments\n3.View lecture materials\n4.View assessments\n5.Grade assessments\n6.Close assessments\n7.View comments\n8.Add comments\n9.Logout");
                                break;
                            case 6:
                                System.out.println("Welcome I0");
                                i.close_assessment();
//                                System.out.println("1.Add class material\n2.Add assessments\n3.View lecture materials\n4.View assessments\n5.Grade assessments\n6.Close assessments\n7.View comments\n8.Add comments\n9.Logout");
                                break;
                            case 7:
                                System.out.println("Welcome I0");
                                i.View_comments();
//                                System.out.println("1.Add class material\n2.Add assessments\n3.View lecture materials\n4.View assessments\n5.Grade assessments\n6.Close assessments\n7.View comments\n8.Add comments\n9.Logout");
                                break;
                            case 8:
                                System.out.println("Welcome I0");
                                i.Add_comments("I0");
//                                System.out.println("1.Add class material\n2.Add assessments\n3.View lecture materials\n4.View assessments\n5.Grade assessments\n6.Close assessments\n7.View comments\n8.Add comments\n9.Logout");
                                break;
                            default:
                                System.out.println("Please enter correct option");
                        }
//
                    }
                } else if (m.option2 == 1) {
                    m.I1();
                    while (m.choose1 != 9) {
                        switch (m.choose1) {
                            case 1:
                                i.Add_class_material("I1");
//                                m.print("I1");
                                break;
                            case 2:
                                i.Add_assissments();
//                                m.print("I1");
                                break;
                            case 3:
                                i.view_lec_material();
//                                m.print("I1");
                                break;
                            case 4:
                                i.view_assessments();
//                                m.print("I1");
                                break;
                            case 5:
                                i.grade();
//                                m.print("I1");
                                break;
                            case 6:
                                i.close_assessment();
//                                m.print("I1");
                                break;
                            case 7:
                                i.View_comments();
//                                m.print("I1");
                                break;
                            case 8:
                                i.Add_comments("I1");
//                                m.print("I1");
                                break;
                            default:
                                System.out.println("Please enter correct option");
                        }
//                        m.choose1 = sc.nextInt();
                    }
                }
            } else if (m.option1 == 2) {
                m.stu();
                if (m.option3 == 0) {
                    m.s0();
                    while (m.choose2 != 7) {
                        switch (m.choose2) {
                            case 1:
                                s.view_lec_material();
//                                m.print1("s0");
                                break;
                            case 2:
                                s.view_assessments("s0");
//                                m.print1("s0");
                                break;
                            case 3:
                                s.sub_assessments("s0");
//                                m.print1("s0");
                                break;
                            case 4:
                                s.view_grade();
//                                m.print1("s0");
                                break;
                            case 5:
                                s.View_comments();
//                                m.print1("s0");
                                break;
                            case 6:
                                s.Add_comments("s0");
//                                m.print1("s0");
                                break;

                            default:
                                System.out.println("Please enter correct option");
                        }
//                        m.choose2 = sc.nextInt();
                    }
                } else if (m.option2 == 1) {
                    m.s1();
                    while (m.choose2 != 7) {
                        switch (m.choose2) {
                            case 1:
                                s.view_lec_material();
//                                m.print1("s1");
                                break;
                            case 2:
                                s.view_assessments("s1");
//                                m.print1("s1");
                                break;
                            case 3:
                                s.sub_assessments("s1");
//                                m.print1("s1");
                                break;
                            case 4:
                                s.view_grade();
//                                m.print1("s1");
                                break;
                            case 5:
                                s.View_comments();
//                                m.print1("s1");
                                break;
                            case 6:
                                s.Add_comments("s1");
//                                m.print1("s1");
                                break;

                            default:
                                System.out.println("Please enter correct option");
                        }
//                        m.choose2 = sc.nextInt();
                    }
                } else {
                    m.s2();
                    while (m.choose2 != 7) {
                        switch (m.choose2) {
                            case 1:
                                s.view_lec_material();
//                                m.print1("s2");
                                break;
                            case 2:
                                s.view_assessments("s2");
//                                m.print1("s2");
                                break;
                            case 3:
                                s.sub_assessments("s2");
//                                m.print1("s2");
                                break;
                            case 4:
                                s.view_grade();
//                                m.print1("s2");
                                break;
                            case 5:
                                s.View_comments();
//                                m.print1("s2");
                                break;
                            case 6:
                                s.Add_comments("s2");
//                                m.print1("s2");
                                break;

                            default:
                                System.out.println("Please enter correct option");
                        }
//                        m.choose2 = sc.nextInt();
                    }
                }
            }
        }
    }
}
