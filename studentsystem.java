package studentSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class studentsystem {
    public static void main(String[] args){
        ArrayList<student> list=new ArrayList<>();
        loop: while(true) {  //loop是给循环起个名字，方便break语句退出此次循环
            System.out.println("-------------------欢迎来到0.0的学生管理系统-------------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出系统");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();  //写next好一点，写nextint接收不了字母
            switch (choose) {
                case "1" -> addstudent(list);
                case "2" -> deletestudent(list);package studentSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class studentsystem {
    public static void startStudentSystem(){
        ArrayList<student> list=new ArrayList<>();
        loop: while(true) {  //loop是给循环起个名字，方便break语句退出此次循环
            System.out.println("-------------------欢迎来到0.0的学生管理系统-------------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出系统");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();  //写next好一点，写nextint接收不了字母
            switch (choose) {
                case "1" -> addstudent(list);
                case "2" -> deletestudent(list);
                case "3" -> updatestudent(list);
                case "4" -> querystudent(list);
                case "5" -> {
                    System.out.println("5.退出系统");
                    break loop; //system.exit(0);  也可以，这是停止虚拟机运行
                }
                default -> System.out.println("没有这个选项");

            }
        }

    }

    //添加学生
    public static void addstudent(ArrayList<student> list){
        //利用空参构造先构建学生对象
        student s=new student();
        System.out.println("添加学生");
        Scanner sc=new Scanner(System.in);

        while(true){System.out.println("请输入学生的id");
        String id=sc.next();
        boolean flag=contain(list,id);
        if(flag){
            System.out.println("id存在");
        }else{
            s.setId(id);
            break;
        }
        }


        System.out.println("请输入学生的姓名");
        String name=sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age=sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String addess=sc.next();
        s.setAddress(addess);

        list.add(s);
        System.out.println("学生信息添加成功");
    }
    //删除学生
    public static void deletestudent(ArrayList<student> list){
        System.out.println("删除学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id=sc.next();

        int index=getIndex(list,id);
        if(index>=0){
            list.remove(index);
            System.out.println("id为："+id+"的学生删除成功");
        }else{
            System.out.println("该id不存在，删除失败");
            return;
        }
    }
    //修改学生
    public static void updatestudent(ArrayList<student> list){
        System.out.println("修改学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改的id");
        String id=sc.next();

        int index=getIndex(list,id);
        if(index==-1){
            System.out.println("你输入的"+id+"不存在");
            return;
        }
        student stu=list.get(index);

        System.out.println("请输入要修改的学生姓名");
        String newName=sc.next();
        stu.setName(newName);

        System.out.println("请输入要修改的学生年龄");
        int newAge=sc.nextInt();
        stu.setAge(newAge);

        System.out.println("请输入要修改的学生家庭住址");
        String newAdress=sc.next();
        stu.setAddress(newAdress);

        System.out.println("修改完毕");
    }
    //查询学生
    public static void querystudent(ArrayList<student> list){
        if(list.size()==0){
            System.out.println("查询失败，请添加学生后再查询");
        return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+"\t"+ stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }

        System.out.println("查询学生");
    }

    //判断id的唯一性
    public static boolean contain(ArrayList<student>list,String id){
        return getIndex(list,id)>=0;
}
public static int getIndex(ArrayList<student>list,String id){
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            String sid=stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
}
}

                case "3" -> updatestudent(list);
                case "4" -> querystudent(list);
                case "5" -> {
                    System.out.println("5.退出系统");
                    break loop; //system.exit(0);  也可以，这是停止虚拟机运行
                }
                default -> System.out.println("没有这个选项");

            }
        }

    }

    //添加学生
    public static void addstudent(ArrayList<student> list){
        //利用空参构造先构建学生对象
        student s=new student();
        System.out.println("添加学生");
        Scanner sc=new Scanner(System.in);

        while(true){System.out.println("请输入学生的id");
        String id=sc.next();
        boolean flag=contain(list,id);
        if(flag){
            System.out.println("id存在");
        }else{
            s.setId(id);
            break;
        }
        }


        System.out.println("请输入学生的姓名");
        String name=sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age=sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String addess=sc.next();
        s.setAddress(addess);

        list.add(s);
        System.out.println("学生信息添加成功");
    }
    //删除学生
    public static void deletestudent(ArrayList<student> list){
        System.out.println("删除学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id=sc.next();

        int index=getIndex(list,id);
        if(index>=0){
            list.remove(index);
            System.out.println("id为："+id+"的学生删除成功");
        }else{
            System.out.println("该id不存在，删除失败");
            return;
        }
    }
    //修改学生
    public static void updatestudent(ArrayList<student> list){
        System.out.println("修改学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改的id");
        String id=sc.next();

        int index=getIndex(list,id);
        if(index==-1){
            System.out.println("你输入的"+id+"不存在");
            return;
        }
        student stu=list.get(index);

        System.out.println("请输入要修改的学生姓名");
        String newName=sc.next();
        stu.setName(newName);

        System.out.println("请输入要修改的学生年龄");
        int newAge=sc.nextInt();
        stu.setAge(newAge);

        System.out.println("请输入要修改的学生家庭住址");
        String newAdress=sc.next();
        stu.setAddress(newAdress);

        System.out.println("修改完毕");
    }
    //查询学生
    public static void querystudent(ArrayList<student> list){
        if(list.size()==0){
            System.out.println("查询失败，请添加学生后再查询");
        return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+"\t"+ stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }

        System.out.println("查询学生");
    }

    //判断id的唯一性
    public static boolean contain(ArrayList<student>list,String id){
        return getIndex(list,id)>=0;
}
public static int getIndex(ArrayList<student>list,String id){
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            String sid=stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
}
}
