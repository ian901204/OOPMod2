import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Movie> movies = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    
    public static void main(String[] args) {
        // 初始化一些資料作為示範
        initializeSampleData();
        
        boolean exit = false;
        while (!exit) {
            showMainMenu();
            int choice = getIntInput("請選擇操作: ");
            
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addRental();
                    break;
                case 4:
                    showCustomerStatement();
                    break;
                case 5:
                    changeMovieType();
                    break;
                case 6:
                    listAllMovies();
                    break;
                case 7:
                    listAllCustomers();
                    break;
                case 0:
                    exit = true;
                    System.out.println("感謝使用白仕達錄影帶出租系統，再見！");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
        }
        scanner.close();
    }
    
    private static void showMainMenu() {
        System.out.println("\n===== 白仕達錄影帶出租系統 =====");
        System.out.println("1. 新增電影");
        System.out.println("2. 新增顧客");
        System.out.println("3. 新增租借記錄");
        System.out.println("4. 顯示顧客租借報表");
        System.out.println("5. 變更電影類型（如新片轉為舊片）");
        System.out.println("6. 列出所有電影");
        System.out.println("7. 列出所有顧客");
        System.out.println("0. 離開系統");
    }
    
    private static void initializeSampleData() {
        // 預設新增一些電影和顧客，方便測試
        movies.add(new NewReleaseMovie("我的名字"));
        movies.add(new RegularMovie("K-O"));
        movies.add(new RegularMovie("涼宮春日的"));
        movies.add(new ChildrenMovie("GIVEN"));
        
        customers.add(new Customer("倫倫"));
        customers.add(new Customer("六花醬"));
        customers.add(new Customer("K昂"));
        customers.add(new Customer("史家瑩"));
    }
    
    private static void addMovie() {
        System.out.println("\n----- 新增電影 -----");
        String title = getStringInput("請輸入電影名稱: ");
        
        System.out.println("請選擇電影類型:");
        System.out.println("1. 新片");
        System.out.println("2. 舊片");
        System.out.println("3. 兒童片");
        
        int type = getIntInput("請選擇: ");
        Movie movie = null;
        
        switch (type) {
            case 1:
                movie = new NewReleaseMovie(title);
                break;
            case 2:
                movie = new RegularMovie(title);
                break;
            case 3:
                movie = new ChildrenMovie(title);
                break;
            default:
                System.out.println("無效的電影類型！操作取消。");
                return;
        }
        
        movies.add(movie);
        System.out.println("成功新增電影: " + movie);
    }
    
    private static void addCustomer() {
        System.out.println("\n----- 新增顧客 -----");
        String name = getStringInput("請輸入顧客姓名: ");
        
        // 檢查是否已存在該顧客
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                System.out.println("顧客 " + name + " 已存在！");
                return;
            }
        }
        
        Customer customer = new Customer(name);
        customers.add(customer);
        System.out.println("成功新增顧客: " + name);
    }
    
    private static void addRental() {
        System.out.println("\n----- 新增租借記錄 -----");
        
        if (customers.isEmpty() || movies.isEmpty()) {
            System.out.println("系統中沒有足夠的顧客或電影資料！請先新增。");
            return;
        }
        
        // 顯示顧客列表
        listAllCustomers();
        int customerIndex = getIntInput("請選擇顧客 (輸入序號): ") - 1;
        
        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("無效的顧客選擇！操作取消。");
            return;
        }
        
        // 顯示電影列表
        listAllMovies();
        int movieIndex = getIntInput("請選擇電影 (輸入序號): ") - 1;
        
        if (movieIndex < 0 || movieIndex >= movies.size()) {
            System.out.println("無效的電影選擇！操作取消。");
            return;
        }
        
        int days = getIntInput("請輸入租借天數: ");
        if (days <= 0) {
            System.out.println("租借天數必須大於零！操作取消。");
            return;
        }
        
        Customer customer = customers.get(customerIndex);
        Movie movie = movies.get(movieIndex);
        Rental rental = new Rental(movie, days);
        
        customer.addRental(rental);
        System.out.println("成功為 " + customer.getName() + " 建立電影 " + movie.getTitle() + " 的租借記錄 (" + days + " 天)");
    }
    
    private static void showCustomerStatement() {
        System.out.println("\n----- 顧客租借報表 -----");
        
        if (customers.isEmpty()) {
            System.out.println("系統中沒有顧客資料！");
            return;
        }
        
        listAllCustomers();
        int index = getIntInput("請選擇顧客 (輸入序號): ") - 1;
        
        if (index < 0 || index >= customers.size()) {
            System.out.println("無效的選擇！");
            return;
        }
        
        Customer customer = customers.get(index);
        System.out.println("\n" + customer.statement());
    }
    
    private static void changeMovieType() {
        System.out.println("\n----- 變更電影類型 -----");
        
        if (movies.isEmpty()) {
            System.out.println("系統中沒有電影資料！");
            return;
        }
        
        // 主要是將新片轉為舊片
        List<Movie> newReleaseMovies = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie instanceof NewReleaseMovie) {
                newReleaseMovies.add(movie);
                System.out.println((newReleaseMovies.size()) + ". " + movie);
            }
        }
        
        if (newReleaseMovies.isEmpty()) {
            System.out.println("系統中沒有新片可以轉換！");
            return;
        }
        
        int index = getIntInput("請選擇要轉換的新片 (輸入序號): ") - 1;
        
        if (index < 0 || index >= newReleaseMovies.size()) {
            System.out.println("無效的選擇！");
            return;
        }
        
        Movie oldMovie = newReleaseMovies.get(index);
        // 在主列表中找到這部電影
        int mainIndex = movies.indexOf(oldMovie);
        
        Movie newMovie = oldMovie.changeType();
        movies.set(mainIndex, newMovie);
        
        System.out.println("電影已成功轉換: " + oldMovie + " => " + newMovie);
    }
    
    private static void listAllMovies() {
        System.out.println("\n----- 所有電影清單 -----");
        if (movies.isEmpty()) {
            System.out.println("系統中沒有電影資料！");
            return;
        }
        
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }
    
    private static void listAllCustomers() {
        System.out.println("\n----- 所有顧客清單 -----");
        if (customers.isEmpty()) {
            System.out.println("系統中沒有顧客資料！");
            return;
        }
        
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("請輸入有效的數字！");
            }
        }
    }
}