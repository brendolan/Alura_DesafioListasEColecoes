package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Classes.CreditCard;

public class Main {

	public static void main(String[] args) {

		CreditCard myCard = new CreditCard("Banco do Brasil", "0001 0002 0003 0004", "Rafael Brendolan", "03/27", 333, 25000);

		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {		
				System.out.println("Deseja inserir uma nova compra? Digite 'sim' ou 'nao': ");
				String response = scanner.nextLine();

				if (response.equals("sim")) {

					System.out.println("Digite o nome da loja: ");
					String storeName = scanner.nextLine();

					System.out.println("Digite a data da compra (DD/MM/YYYY): ");
					String dateString = scanner.nextLine();

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");				
					LocalDate purchaseDate = LocalDate.parse(dateString, formatter);

					System.out.println("Digite o valor da compra: ");
					double purchaseAmount = Double.parseDouble(scanner.nextLine());
					

					myCard.addPurchase(storeName, purchaseDate, purchaseAmount);

				} else if (response.equals("nao")) {
					break;
				} else {
					System.out.println("resposta invalida");
				}
			}			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			scanner.close();
			
			System.out.println("Compras ordenadas por valor ascendente: ");
			System.out.println(myCard.getPurchasesOrderingByValueAsc());
			
		}
	}
}
