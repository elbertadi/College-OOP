package Main;

import java.util.Scanner;
import java.util.Vector;

public class Main {
		Scanner scan = new Scanner(System.in);
		Vector<Dish> listDish = new Vector<>();
		String name, nampung;
	
	public Main() {
		Integer pilihan;
		do {
			try {
				menu();
				pilihan = scan.nextInt();scan.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				pilihan = -1;
				scan.next();
			}
			System.out.println(" ");
			System.out.println(" ");
			if(pilihan == 1) {
				cookDish();
			}else if(pilihan == 2) {
				if(listDish.size() == 0) {
					menu3();
				}else {
					menu2();
					System.out.println("Press [Enter] to go back to menu!");
					scan.nextLine();
				}
			}else if(pilihan == 3) {
				String nampNama; 
				Integer counter = -1;
				if(listDish.size() == 0) {
					menu3();
				}else {
					menu2();
					do{
						System.out.println("Choose the name of the dish you want to eat (Case Sensitive): ");
						nampNama = scan.nextLine();	
						for (int i = 0; i<listDish.size(); i++) {
							if(nampNama.equals(listDish.get(i).getName())) {
								counter = i;
								listDish.remove(i);
							}
						}
						if(counter == -1) {
							System.out.println("Dish doesn't exist!");
						}
					}while(counter == -1);
			
					System.out.println("Successfully eat the dish!");
				}
			}
			
			
			
		}while(pilihan != 4);
		
		
	}

	public static void main(String[] args) {
		new Main();

	}
	public void menu2() {
		System.out.printf("%-8s %-20s %-5s %-15s\n", "ID", "NAME", "Qty", "Time(h)");
		for (Dish dish : listDish) {
			System.out.printf("%-8s %-20s %-5d %-15.4f\n", dish.getId(), dish.getName(), dish.getQuantity(),dish.getTime());
		}
	}
	public void menu3() {
		System.out.println("No dishes yet!");
		System.out.println("Press [Enter] to go back to menu!");
		scan.nextLine();
	}
	public void cookDish() {

		Integer quantity;
		Float time;
		String id;
		int counter = -1;
		System.out.println("Let's cook your favourite dish!");
		
			if(listDish.size() == 0) {
				do {
					System.out.println("Enter dish name [Starts with Papa][Must be unique]: ");
					this.nampung = scan.nextLine();
				}while(!nampung.contains("Papa") );
			}else {
				do {
					do {
						System.out.println("Enter dish name [Starts with Papa][Must be unique]: ");
						this.nampung = scan.nextLine();
					}while(!nampung.contains("Papa") );
					for (int i = 0; i<listDish.size(); i++) {
						if(this.nampung.toLowerCase().equals(listDish.get(i).getName().toLowerCase())) {
							System.out.println("Name duplicate!");
							counter = -1;
						}else {
							counter = i;
						}
					}	
				}while(counter == -1);
			}

	
		do {
			try {
				System.out.println("How much do you want to cook [1-10]");
				quantity = scan.nextInt();scan.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				quantity = -1;
				scan.next();
			}
		}while(quantity < 1 || quantity > 10);
		do {
			try {
				System.out.println("How much hour do you need to cook one [0.25-2]: ");
				time = scan.nextFloat();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				time = (float) 10;
				scan.next();
			}
		}while(time < 0.25 || time > 2);
		
		id = rng();
		System.out.println("Dish cooked successfully!");
		System.out.println("Press [Enter] to continue!");
		listDish.add(new Dish(this.nampung, quantity, time, id));
		scan.nextLine();
		scan.nextLine();
	}
	public String rng() {
		char huruf1 = 'P';
	    char huruf2 = 'A';
		char huruf3 = 'P';
	    char huruf4 = 'A';
	    char huruf5 = (char)(listDish.size()+'1');
	    char huruf6 = (char)(listDish.size()+'2');
	    String string = Character.toString(huruf1)+Character.toString(huruf2)+Character.toString(huruf3)+Character.toString(huruf4)+Character.toString(huruf5)+Character.toString(huruf6);
	   return string;
	  }
	
	public void menu() {
		System.out.println("Cooking Papa");
		System.out.println("-------------");
		System.out.println("1. Cook Dish");
		System.out.println("2. View Dish");
		System.out.println("3. Eat Dish");
		System.out.println("4. Exit");
	}

}

