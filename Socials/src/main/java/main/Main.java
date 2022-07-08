package main;

import main.model.Role;
import main.model.User;
import main.model.Right;
import org.hibernate.Session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Session session=HibernateUtils.getSessionFactory().openSession();
        DBService err=new DBServiceImpl();

        Right r1=new Right();
        r1.setRight("create");

        Right r2=new Right();
        r2.setRight("change");

        Right r3=new Right();
        r3.setRight("delete");

        Right r4=new Right();
        r4.setRight("rename");

        Right r5=new Right();
        r5.setRight("add");

        Right r6=new Right();
        r6.setRight("move");

        Role role=new Role();
        role.setTitle("moder");

        Role role1=new Role();
        role1.setTitle("user");

        role.addRight(r1);
        role.addRight(r3);
        role.addRight(r6);
        role1.addRight(r1);
        role1.addRight(r2);
        role1.addRight(r4);
        role1.addRight(r5);



        User user=new User();
        user.setName("aaa");
        user.setRole(role);
        user.setLogin("apple");
        user.setPassword(getHash("1234"));

        User user1=new User();
        user1.setName("bbb");
        user1.setRole(role1);
        user1.setLogin("straw");
        user1.setPassword(getHash("1235"));

        User user2=new User();
        user2.setName("dwarf");
        user2.setRole(role1);
        user2.setLogin("yargk");
        user2.setPassword(getHash("5846185zxfw"));

        err.save(user);
        err.save(user1);
        err.save(user2);





        List<User> yes = err.readAllUsers();

        System.out.println(err.readAllUsers());
        System.out.println(yes.get(0));
        System.out.println(yes.get(1));
        System.out.println(yes.get(2));


        err.findUser("apple",getHash("1234"));
        err.closeConnection();

        err.openConnection();
        //DBService con=new DBServiceImpl();
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
        String str1 = in.nextLine();
        if (err.findUser(str,getHash(str1))==null){
            System.out.println("-----------Авторизация невозможна-------------------");
        }
        else {
            System.out.println("-------"+err.findUser(str,getHash(str1)).getRole()+"--------------");
        }


        err.closeConnection();
        System.out.println("OK");
        System.exit(0);
    }


    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return sb.toString();
    }

    public static String getHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return bytesToHexString(md.digest(pass.getBytes()));
    }
}
