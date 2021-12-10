import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Conta c = new Conta();
		TipoReceita tr = new TipoReceita();
		TipoDespesa td = new TipoDespesa();
		Receita r = new Receita();
		Despesa d = new Despesa();
		ListTipoReceita trecl = new ListTipoReceita();
		ListTipoDespesa tdesl = new ListTipoDespesa();
		ListReceita l = new ListReceita();
		ListDespesa desl = new ListDespesa();
		
		System.out.println("-------OR�AMENTO PESSOAL---------\n");
		
		//Receita
		
		tr = new TipoReceita();
		tr.setCategoria("Sal�rio");
		trecl.add(tr);
			
		tr = new TipoReceita();
		tr.setCategoria("Vari�vel");
		trecl.add(tr);
			
		tr = new TipoReceita();
		tr.setCategoria("Outro");
		trecl.add(tr);
			
		trecl.gravar();
			
		trecl = new ListTipoReceita();
			
		trecl.setLista(trecl.ler());
		
		//Despesa

		td = new TipoDespesa();
		td.setCategoria("Alimenta��o");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Transporte");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Lazer");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Mensalidade");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Vestu�rio");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Sa�de");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Moradia");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Outro");
		tdesl.add(td);
		
		tdesl.gravar();
		
		tdesl = new ListTipoDespesa();
		
		tdesl.setLista(tdesl.ler());
		
		while(true){
			
			
			System.out.println("O que voc� deseja gerenciar? \n1 - Receita\n2 - Despesa\n3 - Conta\n0 - Para finalizar qualquer opera��o ou sub opera��o");
			int og = input.nextInt();
			
			System.out.println("-------------------");
	
			if(og == 1) {
				System.out.println("O que deseja fazer?\n1 - Inserir receita\n2 - Ver receita total por categoria de receita");
				int or = input.nextInt();
				
				if(or == 1) {
					
					while(true) {
							
						System.out.println("\n------LISTA DE TIPOS DE RECEITA------\n");
						
						for (TipoReceita p : trecl.getLista()) {
							System.out.println(p);
						}   
						 
						r = new Receita();
						
						System.out.println("\nDigite o valor da receita: ");
						r.setValor(input.nextDouble());
						input.nextLine();
						
						System.out.println("Digite a data:");
						r.setData(input.nextLine());
						
						System.out.println("\nDigite a categoria da receita por �ndice (de 0 a 2):");
						r.setTipoReceita(trecl.getLista().get(input.nextInt()));
						
	
						l.add(r);
						c.setLr(l);
			
						l.gravar();
						
						l.setLista(l.ler());
						
					    for (Receita p : l.getLista()) {
							System.out.println(p);
						}   
					    

						System.out.println("\nCadastrar mais receitas? 1 - Sim e 2 - N�o");
						int a = input.nextInt();
						if(a == 2) {
							break;
						}
					
					}
					
				}if(or == 2) {
					System.out.println("\nSelecione o catergoria da receita:");
					System.out.println("\n0 - S�lario 1 - Vari�vel 2 - Outro");
					int cat = input.nextInt();
					
					switch (cat) {
						
					case 0:
						System.out.println("Valor total da receita pela categoria SAL�RIO R$" + c.somaPorCatReceita("Sal�rio"));
						break;
					case 1:
						System.out.println("Valor total da receita pela categoria VARI�VEL R$" + c.somaPorCatReceita("Vari�vel"));
						break;
					default:
						System.out.println("Valor total da receita pela categoria OUTRO R$" + c.somaPorCatReceita("Outro"));
						break;
					}
					
				}
				
				
			}if(og == 2) {
					System.out.println("O que deseja fazer?\n1 - Inserir despesa\n2 - Ver despesa total  por categoria de despesa");
					int od = input.nextInt();
					
					if(od == 1) {
						
						while(true) {
							
							System.out.println("\n------ LISTA DE TIPOS DE DESPESAS ------\n");
							 
							 for (TipoDespesa p : tdesl.getLista()) {
									System.out.println(p);
							} 
							 
							d = new Despesa();
							 
							System.out.println("\nDigite o valor da despesa: ");
							d.setValor(input.nextDouble());
							input.nextLine();
									
							System.out.println("Digite a data:");
							d.setData(input.nextLine());
									
							System.out.println("\nDigite a categoria da despesa por �ndice (de 0 a 7):");
							d.setTipoDespesa(tdesl.getLista().get(input.nextInt()));
							 
							desl.add(d);
							
							c.setLd(desl);

							desl.gravar();
							
							desl.setLista(desl.ler());
							
							for (Despesa p : desl.getLista()) {
								System.out.println(p);
							}  
							 
							System.out.println("\nCadastrar mais despesas? 1 - Sim e 2 - N�o");
							int a = input.nextInt();
							if(a == 2) {
								break;
							}
							
						}	
					}if(od == 2) {
							System.out.println("\nSelecione o catergoria da despesa:");
							System.out.println("\n0 - Alimenta��o 1 - Transporte 2 - Lazer 3 - Mensalidade 4 - Vestu�rio 5 - Sa�de 6 - Moradia 7 - Outro");
							int cat = input.nextInt();
							
							switch (cat) {
								
							case 0:
								System.out.println("Valor total da despesa pela categoria ALIMENTA��O R$ " + c.somaPorCatDespesa("Alimenta��o"));
								break;
							case 1:
								System.out.println("Valor total da despesa pela categoria TRANSPORTE R$ " + c.somaPorCatDespesa("Transporte"));
								break;
							case 2:
								System.out.println("Valor total da despesa pela categoria LAZER R$ " + c.somaPorCatDespesa("Lazer"));
								break;
							case 3:
								System.out.println("Valor total da despesa pela categoria MENSALIDADE R$ " + c.somaPorCatDespesa("Mensalidade"));
								break;
							case 4: 
								System.out.println("Valor total da despesa pela categoria VESTU�RIO R$ " + c.somaPorCatDespesa("Vestu�rio"));
								break;
							case 5:
								System.out.println("Valor total da despesa pela categoria SA�DE R$ " + c.somaPorCatDespesa("Sa�de"));
								break;
							case 6:
								System.out.println("Valor total da despesa pela categoria MORADIA R$ " + c.somaPorCatDespesa("Moradia"));
								break;
							default:
								System.out.println("Valor total da despesa pela categoria OUTRO R$ " + c.somaPorCatDespesa("Outro"));
								break;
							}
							
						}
							
							
					
						
				}	
			
			//--------------- ok -------
			else {
				
				
				
				
				
			}
			
			
		}
	}
	
}
