public class Main {
    public static void main(String[] args) {
        // Use Case A: 建立四部電影
        Movie movie1 = new NewReleaseMovie("我的名字");
        Movie movie2 = new RegularMovie("K-O");
        Movie movie3 = new RegularMovie("涼宮春日的");
        Movie movie4 = new ChildrenMovie("GIVEN");
        
        // Use Case B: 建立四位顧客
        Customer customer1 = new Customer("倫倫");
        Customer customer2 = new Customer("六花醬");
        Customer customer3 = new Customer("K昂");
        Customer customer4 = new Customer("史家瑩");
        
        // Use Case C: 建立七筆租借資料
        Rental rental1 = new Rental(movie4, 8);  // 倫倫: GIVEN/8天
        Rental rental2 = new Rental(movie1, 7);  // 倫倫: 我的名字/7天
        Rental rental3 = new Rental(movie1, 8);  // 六花醬: 我的名字/8天
        Rental rental4 = new Rental(movie2, 7);  // 六花醬: K-O/7天
        Rental rental5 = new Rental(movie3, 8);  // 六花醬: 涼宮春日的/8天
        Rental rental6 = new Rental(movie2, 7);  // K昂: K-O/7天
        Rental rental7 = new Rental(movie4, 8);  // 史家瑩: GIVEN/8天
        
        // 將租借紀錄加入顧客
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer2.addRental(rental3);
        customer2.addRental(rental4);
        customer2.addRental(rental5);
        customer3.addRental(rental6);
        customer4.addRental(rental7);
        
        // Use Case D: 印出顧客的租借紀錄
        System.out.println("=== 顧客租借報表 ===");
        System.out.println(customer1.statement());
        System.out.println();
        System.out.println(customer2.statement());
        System.out.println();
        System.out.println(customer3.statement());
        System.out.println();
        System.out.println(customer4.statement());
        
        // Use Case E: 將新片 "我的名字" 轉換為舊片
        System.out.println("\n=== 兩個月後，「我的名字」從新片變成舊片 ===");
        Movie changedMovie = movie1.changeType();
        System.out.println(movie1 + " 變成了 " + changedMovie);
        
        // 建立新的租借紀錄（使用已經轉換為舊片的電影）
        Customer customer5 = new Customer("丸丸");
        Rental newRental = new Rental(changedMovie, 5);
        customer5.addRental(newRental);
        System.out.println("\n" + customer5.statement());
    }
}