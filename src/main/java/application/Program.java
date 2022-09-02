package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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

        System.out.println();
        System.out.println("=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
            System.out.println("Atualização concluída");

        System.out.println();
        System.out.println("=== Test 6: seller deleteById ===");
        System.out.println("Entre com id para o teste 'delete':");
        int idTest = sc.nextInt();
        sellerDao.deleteById(idTest);
        System.out.println("Deletado com sucesso!");

        sc.close();

    }
}
