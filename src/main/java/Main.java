import empty.Category;
import repository.CategoryRespository;
import utills.DbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws SQLException {

        //System.out.println(CategoryRespository.getCategories());

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Id kirit:");
//        int id = scanner.nextInt();
//        scanner = new Scanner(System.in);
//        System.out.println("Nomini kiriting");
//        String name = scanner.nextLine();
//        CategoryRespository.addCategory(id,name);
//        System.out.println("Xammasi yaxshi bo'ladi");
//        System.out.println(CategoryRespository.getCategories());


        Scanner scanner = new Scanner(System.in);
        System.out.println("Id kirit:");
//        int id = scanner.nextInt();
//        scanner = new Scanner(System.in);
        System.out.println("Nomini kiriting");
        String name = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("Type ni kiriting");
        String type = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("new name kiriting");
        String newname = scanner.nextLine();


        CategoryRespository.callFunction(name, type, newname);

    }
}
