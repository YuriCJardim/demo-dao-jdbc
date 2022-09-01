package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== Test 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2,null));
        for(Seller s: list){
            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller s: list){
            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== Test 4: seller insert ===");
        Seller newSeller = new Seller ( null, "Greg", "greg@gmail.com", new Date(), 4000.00, new Department(2, null));
        sellerDao.insert(newSeller);
       System.out.println("Inserido! Nova id = " + newSeller.getId());





    }
}
