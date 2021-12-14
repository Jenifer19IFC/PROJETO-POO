import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int idR = 0;
		Endereco e = new Endereco();
		Usuario u = new Usuario();
		Conta c = new Conta();
		TipoReceita tr = new TipoReceita();
		TipoDespesa td = new TipoDespesa();
		Receita r = new Receita();
		Despesa d = new Despesa();
		ListTipoReceita trecl = new ListTipoReceita();
		ListTipoDespesa tdesl = new ListTipoDespesa();
		ListReceita l = new ListReceita();
		ListDespesa desl = new ListDespesa();
		
		System.out.println("-------ORÇAMENTO PESSOAL---------\n");
		
		//Receita
		
		tr = new TipoReceita();
		tr.setCategoria("Salário");
		trecl.add(tr);
			
		tr = new TipoReceita();
		tr.setCategoria("Variável");
		trecl.add(tr);
			
		tr = new TipoReceita();
		tr.setCategoria("Outro");
		trecl.add(tr);
			
		trecl.gravar();
			
		trecl = new ListTipoReceita();
			
		trecl.setLista(trecl.ler());
		
		//Despesa

		td = new TipoDespesa();
		td.setCategoria("Alimentação");
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
		td.setCategoria("Vestuário");
		tdesl.add(td);
		
		td = new TipoDespesa();
		td.setCategoria("Saúde");
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
			
			
			System.out.println("O que você deseja gerenciar? \n1 - Receita\n2 - Despesa\n3 - Conta\n0 - Para finalizar qualquer operação ou sub operação");
			int og = input.nextInt();
			
			System.out.println("-------------------");
	
			if(og == 1) {
				System.out.println("O que deseja fazer?\n1 - Inserir receita\n2 - Ver receita total por categoria de receita");
				int or = input.nextInt();
				
				if(or == 1) {
					
					while(true) {
							
						System.out.println("\n------LISTA DE TIPOS DE RECEITA------\n");
						
						System.out.println("0- Salário\n1-Variável\n2-Outro");
						
						r = new Receita();
						idR++;
						r.setIdReceita(idR);
						
						System.out.println("\nDigite o valor da receita: ");
						r.setValor(input.nextDouble());
						input.nextLine();
						
						System.out.println("Digite a data:");
						r.setData(input.nextLine());
						
						System.out.println("\nDigite a categoria da receita por índice (de 0 a 2):");
						r.setTipoReceita(trecl.getLista().get(input.nextInt()));
						
	
						l.add(r);
						c.setLr(l);
			
						l.gravar();
						
						l.setLista(l.ler());
						
					    for (Receita p : l.getLista()) {
							System.out.println(p);
						}   
					    

						System.out.println("\nCadastrar mais receitas? 1 - Sim e 2 - Não");
						int a = input.nextInt();
						if(a == 2) {
							break;
						}
					
					}
					
				}if(or == 2) {
					System.out.println("\nSelecione o catergoria da receita:");
					System.out.println("\n0 - Sálario 1 - Variável 2 - Outro");
					int cat = input.nextInt();
					
					switch (cat) {
						
					case 0:
						System.out.println("Valor total da receita pela categoria SALÁRIO R$" + c.somaPorCatReceita("Salário"));
						break;
					case 1:
						System.out.println("Valor total da receita pela categoria VARIÁVEL R$" + c.somaPorCatReceita("Variável"));
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
							 
							System.out.println("0- Alimentação\n1- Transporte\n2- Lazer\n3- Mensalidade\n4- Vestuário\n5- Saúde\n6- Moradia\n7- Outro"); 
							 
							d = new Despesa();
							
							System.out.println("\nDigite o valor da despesa: ");
							d.setValor(input.nextDouble());
							input.nextLine();
									
							System.out.println("Digite a data:");
							d.setData(input.nextLine());
									
							System.out.println("\nDigite a categoria da despesa por índice (de 0 a 7):");
							d.setTipoDespesa(tdesl.getLista().get(input.nextInt()));
							 
							desl.add(d);
							
							c.setLd(desl);

							desl.gravar();
							
							desl.setLista(desl.ler());
							
							//remover receita
							int i = 0;
							for (Despesa p : desl.getLista()) {//Pecorrer igual
								System.out.println(p);
								
								if(p.getIdDespesa() == 1) {//input 1
									desl.getLista().remove(i);
								}
								i++;
							}  
							c.setLd(desl); //atualiza lista na conta
							 
							System.out.println("\nCadastrar mais despesas? 1 - Sim e 2 - Não");
							int a = input.nextInt();
							if(a == 2) {
								break;
							}
						}	
					}if(od == 2) {
							System.out.println("\nSelecione o catergoria da despesa:");
							System.out.println("\n0 - Alimentação 1 - Transporte 2 - Lazer 3 - Mensalidade 4 - Vestuário 5 - Saúde 6 - Moradia 7 - Outro");
							int cat = input.nextInt();
							
							switch (cat) {
								
							case 0:
								System.out.println("Valor total da despesa pela categoria ALIMENTAÇÃO R$ " + c.somaPorCatDespesa("Alimentação"));
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
								System.out.println("Valor total da despesa pela categoria VESTUÁRIO R$ " + c.somaPorCatDespesa("Vestuário"));
								break;
							case 5:
								System.out.println("Valor total da despesa pela categoria SAÚDE R$ " + c.somaPorCatDespesa("Saúde"));
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
			if(og == 3){
				System.out.println("O que deseja fazer?\n1- Inserir ou excluir usuário\n2- Mostrar receitas e despesas da conta (incluir e excluir)");
				int oc = input.nextInt();
				
				if(oc == 1) {
					
					u = new Usuario();
					
					System.out.println("Digite o nome para inserir usuário:");
					u.setNome(input.nextLine());
					
					System.out.println("Digite o CPF:");
					u.setCpf(input.nextLine());
					
					System.out.println("Digite o endereço:");
					d.setTipoDespesa(tdesl.getLista().get(input.nextInt()));
					
				}
					
			}
			
			
			
			
			
			
			
		}
	}
	
}
