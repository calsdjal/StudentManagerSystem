package studentSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        ArrayList<user> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1.登录 2.注册 3.忘记密码 4.退出系统");


            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("退出系统");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }


    private static void login(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        //判断用户名是否存在
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("用户名" + username + "未注册，请先注册再登录");
            return;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码");
            String password = sc.next();

            while (true) {
                String rightcode = getCode();
                System.out.println("当前正确的验证码为：" + rightcode);
                System.out.println("请输入验证码");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightcode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码错误");
                    continue;
                }
            }

            //定义一个方法去判断用户名和密码是否正确
            //封装
            //传递参数，传整体就行
            user userInfo = new user(username, password, null, null);
            boolean res = checkUserInfo(list, userInfo);
            if (res) {
                System.out.println("登陆成功，可以开始使用学生管理系统了");
                studentsystem.startStudentSystem();
                return;
            } else {
                System.out.println("登陆失败，用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前账号" + username + "被锁定，请联系0.0");
                    return;
                } else {
                    System.out.println("用户名或密码错误，还剩下" + (2 - i) + "次机会");
                }
            }

        }
    }
    private static void register(ArrayList<user> list) {
        //录入用户名
        Scanner sc = new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();

            if (checkUsername(list, username)) {
                System.out.println("用户名可用，接着输入密码吧");
                break;
            }

        }

        //录入密码
        String password;
        while (true) {
            System.out.println("请输入密码:");
            password = sc.next();
            System.out.println("请再次输入密码确认");
            String repassword = sc.next();

            if (!password.equals(repassword)) {
                System.out.println("两次输入的密码不一致，请重新录入");
                continue;
            } else {
                System.out.println("两次密码一致，继续录入其他数据");
                break;
            }

        }

        //录入身份证号码
        String personId;
        while (true) {
            System.out.println("请输入身份证号码");
            personId = sc.next();
            boolean flag = checkPersonId(personId);
            if (flag) {
                System.out.println("身份证号码满足需求");
                break;
            } else {
                System.out.println("身份证号码格式有误，请重新输入");
                continue;
            }
        }

        //录入手机号码
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if(flag){
                System.out.println("手机号码格式正确");
                break;
            }else{
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }
        }

        //把这些信息放到用户对象中
        user u= new user(username,password,personId,phoneNumber);
        list.add(u);
        System.out.println("注册成功");

        printlist(list);
    }
    private static void printlist(ArrayList<user>list){
        for(int i=0;i< list.size();i++){
            user user=list.get(i);
        System.out.println(user.getUsername()+","+user.getPassword()+","+user.getPersonId()+","+user.getPhoneNumber());
        }
    }

    private static void forgetPassword(ArrayList<user> list) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.next();
        boolean flag=contains(list,username);
        if(!flag){
            System.out.println("当前用户"+username+"未注册，请先注册");
            return;
        }
        //录入身份证号和手机密码
        System.out.println("请输入身份证号码");
        String personId=sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber=sc.next();

        //比较手机号码和身份证号码是否相同
        int index=findIndex(list,username);
        user user=list.get(index);
        //比较用户对象中的手机号码和身份证号码是否相同
        if(!(user.getPassword().equalsIgnoreCase(personId)&&user.getPhoneNumber().equals(phoneNumber))){
            System.out.println("身份证号码或手机号码输入有误，不能继续操作");
            return;
        }
        String newPassword;
        while(true){System.out.println("请输入新的密码");
        newPassword=sc.next();
        System.out.println("请再次输入新的密码");
        String rePassword=sc.next();

        if(newPassword.equals(rePassword)){
            System.out.println("两次密码输入一致");
            break;
        }else{
            System.out.println("两次密码输入不一致");
            continue;
        }
        }
        //直接修改
        user.setPassword(newPassword);
        System.out.println("密码修改成功");
    }

    private static int findIndex(ArrayList<user> list, String username) {
        for(int i=0;i<list.size();i++){
            user user=list.get(i);
            if(user.getUsername().equals(username)){
                return i;
            }
        }return -1;
    }

    private static boolean contains(ArrayList<user> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            user user = list.get(i);
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUsername(ArrayList<user> list, String username) {
        int len = username.length();
        if (len < 3 || len > 15) {
            System.out.println("用户名长度不符合要求");
            return false;
        }
        //继续校验
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                System.out.println("用户名只包含字母和数字，当前包含非法字符：" + c);
                return false;
            }
        }
        //用户名满足两个要求：1、长度满足 2、内容也满足（字母+数字）
        int cnt = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'z')) {
                cnt++;
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                System.out.println("用户名已存在");
                return false;
            }
        }
        return true;
    }

    private static boolean checkpassword(String password) {
        if (password.length() < 6) {
            System.out.println("密码强度太低，长度至少为6位");
            return false;
        }
        //必须包含数字和字母
        int lettercnt=0;
        int wordcnt=0;
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                lettercnt++;
            }else if(c>='0'&&c<='9'){
                wordcnt++;
            }
        }
        if(lettercnt==0||wordcnt==0){
            System.out.println("密码格式不符合条件，密码必须同时包含数字和字母");
            return false;
        }
        return true;
    }

    private static boolean checkPersonId(String personId) {
        //长度校验
        if (personId.length() != 18) {
            return false;
        }
        //开头不能是0
        boolean flag = personId.startsWith("0");
        if (flag) {
            return false;
        }
        //前17位必须是数字
        for (int i = 0; i < personId.length() - 1; i++) {
            char c = personId.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        char endChar = personId.charAt(personId.length() - 1);
        if ((endChar >= '0' && endChar <= '9') || (endChar == 'x') || (endChar == 'X')) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=11){
            return false;
        }
        if(phoneNumber.startsWith("0")){
            return false;
        }
        for(int i=0;i<phoneNumber.length();i++){
            char c=phoneNumber.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }return true;  //表示每个字符都在0~9之间
    }

    private static String getCode(){
        ArrayList<Character>list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        for(int i=0;i<10;i++){
            list.add((char)('0'+i));
        }
        String res="";
        Random r=new Random();
        for(int i=0;i<4;i++){
            int index=r.nextInt(list.size());
            res+=list.get(index);
        }
        return res;
    }

    private static boolean checkUserInfo(ArrayList<user>list,user userInfo){
        for(int i=0;i< list.size();i++){
            user user=list.get(i);
            if(user.getUsername().equals(userInfo.getUsername())&&user.getPassword().equals(userInfo.getPassword())){
                return true;
            }
        }
        return false;
    }
}