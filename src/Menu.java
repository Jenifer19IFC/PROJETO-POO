import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		int idR = 0;
		int idD = 0;
		int idC = 0;
		int idU = 0;
		Gerencial g = new Gerencial();
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
		ListConta cl = new ListConta();
		ListEndereco enl = new ListEndereco();
		ListUsuario ul = new ListUsuario();
		ArrayList<Conta> contas = new ArrayList< Conta >();
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
		
		System.out.println("-------OR�AMENTO PESSOAL---------\n");
	
		while(true){
			System.out.println("O que deseja fazer?\n1- Criar conta\n2- Excluir conta\n3- Gerenciar conta");
			int og = input.nextInt();
			
			if(og == 1) {
				
				while(true){
					
					u = new Usuario();
					idU++;
					u.setIdUsuario(idU);
					
					input.nextLine();
					System.out.println("Nome do usu�rio:");
					u.setNome(input.nextLine());
					
					System.out.println("CPF:");
					u.setCpf(input.nextLine());
					
					e = new Endereco();
					System.out.println("Digite o bairro:");
					e.setBairro(input.nextLine());
					
					System.out.println("Digite a cidade:");
					e.setCidade(input.nextLine());
					
					u.setEndereco(e);
					
					enl.add(e);
					
					enl.gravar();
					
					enl = new ListEndereco();
					
					enl.setLista(enl.ler());
					
				    for (Endereco p : enl.getLista()) {
						System.out.println(p);
					}  
					
					c = new Conta();
					idC++;
					c.setIdConta(idC);
					
					System.out.println("Saldo a conta:");
					c.setSaldo(input.nextDouble());
					
					System.out.println("----------------------");
					System.out.println("SEU ID DA CONTA � '" + idC +"'!");
					System.out.println("----------------------");
					
					cl.add(c);
					ul.add(u);
					//g.setCl(cl);
					cl.gravar();
					ul.gravar();
					
					cl.setLista(cl.ler());
					ul.setLista(ul.ler());
					
					c.setUl(ul);
					c.setUsuario(u);
					//g.setCl(cl);//Lista de contas - gerencial
					contas.add(c);
					
					
				    for (Conta p : cl.getLista()) {
						System.out.println(p);
					}   
			
				   //System.out.println(g);
					System.out.println("\nDeseja inserir mais contas?1- Sim 2- N�o");
					int o = input.nextInt();
					
					if(o == 2) {
						break;
					}
				}//while
	
			}//if de og == 1
			if(og == 2) {//EXCLUIR CONTA
				int exC;
				while(true) {
					 System.out.println("Digite o ID da conta:");
					 exC = input.nextInt();
					
					 for(int i = 0; i < cl.getLista().size(); i++) {
			                if (cl.getLista().get(i).getIdConta() == exC) {
			                    cl.getLista().get(i);
			                    cl.getLista().remove(i);
						}
					}  
					
					System.out.println("\nExcluir mais contas? 1- Sim e 2- N�o");
					int a = input.nextInt();
					if(a == 2) {
						break;
					}
				}
			}//if og == 2
			if(og == 3) {
				 
				while(true) {
					
					for (Conta p : cl.getLista()) {
						System.out.println(p);
					}
					
					System.out.println("Digite o Id da conta: 0- Voltar ao menu");
					int id = input.nextInt();
							
					while(true) { 
						
							System.out.println("O que deseja fazer?\n1- Adicionar usu�rio\n2- Excluir usu�rio\n3- Listar receitas\n4- Listar despesas\n"
							+ "5- Somar receitas e descontar despesas do saldo\n6- Voltar ao menu");
							int o = input.nextInt();
							
							if(o == 1) {//ADD US�RIO
								
								while(true) {
									
									System.out.println("-------LISTA DE USU�RIOS--------");
									
									for (Usuario p : ul.getLista()) {
										System.out.println(p);
									}
									
									u = new Usuario();
									idU++;
									u.setIdUsuario(idU);
									
									input.nextLine();
									System.out.println("Nome do usu�rio:");
									u.setNome(input.nextLine());
									
									System.out.println("CPF:");
									u.setCpf(input.nextLine());
									
									e = new Endereco();
									System.out.println("Digite o bairro:");
									e.setBairro(input.nextLine());
									
									System.out.println("Digite a cidade:");
									e.setCidade(input.nextLine());
									
									u.setEndereco(e);
									
									enl.add(e);
									
									enl.gravar();
									
									enl = new ListEndereco();
									
									enl.setLista(enl.ler());
									
								    for (Endereco p : enl.getLista()) {
										System.out.println(p);
									}  
								    ul.add(u);
								    
								    ul.gravar();
									
									ul = new ListUsuario();
									
									ul.setLista(ul.ler());
									
								    for (Usuario p : ul.getLista()) {
										System.out.println(p);
									}
								    
								    System.out.println("Adicionar mais usu�rios?1- Sim 2- N�o");
								    int a = input.nextInt();
								    
								    if(a == 2) {
								    	break;
								    }
								
								}
							}//if o == 1
							
							if(o == 2) {//EXCLUIR USUARIO
								
								while(true) {
									 System.out.println("Digite o ID dO Usu�rio:");
									 int exU = input.nextInt();
										
									 for(int i = 0; i < ul.getLista().size(); i++) {
							                if (ul.getLista().get(i).getIdUsuario() == exU) {
							                    ul.getLista().get(i);
							                    ul.getLista().remove(i);
										}
									}  
									
									System.out.println("\nExcluir mais usuarios? 1- Sim e 2- N�o");
									int a = input.nextInt();
									if(a == 2) {
										break;
									}
								}
								
							}//if o == 2
							
							
							if(o == 3) {//LISTAR RECEITAS
								
								while(true) {
									System.out.println("\n------LISTA DE RECEITAS------\n");
									
									 for (Receita p : l.getLista()) {
											System.out.println(p);
										}   
									    c.setLr(l); //atualiza lista na conta
									    
									    
									 System.out.println("\nO que deseja fazer?\n1- Adicionar receita\n2- Excluir receita\n3- Ver receita "
									 		+ " total por categoria\n4- Voltar ao menu");
									 int or = input.nextInt();
									 
									 if(or == 1) {//ADD RECEITA
										 
										 while(true) {
												
												System.out.println("\n------LISTA DE TIPOS DE RECEITA------\n");
												
												System.out.println("0- Sal�rio\n1-Vari�vel\n2-Outro");
												
												r = new Receita();
												idR++;
												r.setIdReceita(idR);
												
												System.out.println("\nDigite o valor da receita: ");
												r.setValor(input.nextDouble());
												input.nextLine();
												
												System.out.println("Digite a data:");
												r.setData(input.nextLine());
												
												System.out.println("\nDigite a categoria da receita:");
												r.setTipoReceita(trecl.getLista().get(input.nextInt()));
												
							
												l.add(r);
												c.setLr(l);
												
												l.gravar();
												
												l.setLista(l.ler());
												
											    for (Receita p : l.getLista()) {
													System.out.println(p);
												}   
											    c.setLr(l); //atualiza lista na conta
											    c.atualizaSaldo();
											    
												System.out.println("\nCadastrar mais receitas? 1 - Sim e 2 - N�o");
												int a = input.nextInt();
												if(a == 2) {
													break;
												}
											
											}	
									 }//if or == 1
									 if(or == 2) {//EXCLUIR RECEITA
										 
										 while(true) {
											 System.out.println("Digite o ID da receita:");
											 int exR = input.nextInt();
												
											 for(int i = 0; i < l.getLista().size(); i++) {
									                if (l.getLista().get(i).getIdReceita() == exR) {
									                    l.getLista().get(i);
									                    l.getLista().remove(i);
												}
											}  
											c.setLd(desl); //atualiza lista na conta
											c.atualizaSaldo();
											
											System.out.println("\nExcluir mais receitas? 1- Sim e 2- N�o");
											int a = input.nextInt();
											if(a == 2) {
												break;
											}
										}
											
									 }//if or == 2
									 if(or == 3) {//VER RECEITA TOTAL POR CATEGORIA
										 
										 while(true) {
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
										
											System.out.println("\nSelecionar mais categorias?? 1- Sim e 2- N�o");
											int a = input.nextInt();
											
											if(a == 2) {
												break;
											}
										 }
									 }//if or == 3
									 if(or == 4) {
											break;
									}
								}//WhileReceita
							
							}//if or == 3
							if(o == 4) {//LISTAR DESPESAS
								
								while(true) {
									System.out.println("\n------LISTA DE DESPESAS------\n");
									
									for (Despesa p : desl.getLista()) {
										System.out.println(p);
									}  
									c.setLd(desl); //atualiza lista na conta
									
									System.out.println("\nO que deseja fazer?\n1- Adicionar despesa\n2- Excluir despesa\n3- Ver despesa"
									+ "total por categoria\n4- Voltar ao menu");
									int od = input.nextInt();
				
									if(od == 1) {//ADD DESPESA
										
										while(true) {
											
											System.out.println("\n------ LISTA DE TIPOS DE DESPESAS ------\n");
											 
											System.out.println("0- Alimenta��o\n1- Transporte\n2- Lazer\n3- Mensalidade\n4- Vestu�rio\n5- Sa�de\n6- Moradia\n7- Outro"); 
											 
											d = new Despesa();
											idD++;
											d.setIdDespesa(idD);
											
											System.out.println("\nDigite o valor da despesa: ");
											d.setValor(input.nextDouble());
											input.nextLine();
													
											System.out.println("Digite a data:");
											d.setData(input.nextLine());
													
											System.out.println("\nDigite a categoria da despesa:");
											d.setTipoDespesa(tdesl.getLista().get(input.nextInt()));
											 
											desl.add(d);
											
											c.setLd(desl);
								
											desl.gravar();
											
											desl.setLista(desl.ler());
											
											for (Despesa p : desl.getLista()) {
												System.out.println(p);
											}  
											c.setLd(desl); //atualiza lista na conta
											c.atualizaSaldo();
											
											System.out.println("\nCadastrar mais despesas? 1 - Sim e 2 - N�o");
											int a = input.nextInt();
											if(a == 2) {
												break;
											}
										}	
									}//if od == 1
									if(od == 2) {//EXCLUIR DESPESA
										
										while(true) {
											System.out.println("Digite o ID da despesa:");
											int exD = input.nextInt();
											
											for(int i = 0; i < desl.getLista().size(); i++) {
								                if (desl.getLista().get(i).getIdDespesa() == exD) {
								                    desl.getLista().get(i);
								                    desl.getLista().remove(i);
											}
										}  
											c.setLd(desl); //atualiza lista na conta
											c.atualizaSaldo();
											
											System.out.println("\nExcluir mais despesas? 1 - Sim e 2 - N�o");
											int a = input.nextInt();
											if(a == 2) {
												break;
											}
										}
									}//od == 2
									if(od == 3) {//VER DESPESA TOTAL POR CATEGORIA
										
										while(true) {
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
											System.out.println("\nSelecionar mais categorias?? 1- Sim e 2- N�o");
											int a = input.nextInt();
											
											if(a == 2) {
												break;
											}
									}
								}//if od == 3
								if(od == 4) {
									break;
								}
							}//WhileDespesa
							
								}//if or == 3
							if(o == 5) {//SOMAR RECEITAS E DESCONTAR DESPESAS DO SALDO
								
								System.out.println("Digite o ID da conta");
								int cod = input.nextInt();
								for(int i = 0; i < cl.getLista().size(); i++) {
						               if (cl.getLista().get(i).getIdConta() == cod) {
						                   cl.getLista().get(i);
						                   System.out.println("\nSALDO ATUAL: R$ " + c.getSaldo());
						               }
								}
							}//if o == 5
							
							System.out.println("Continuar gerenciando esta conta?1- Sim 2- N�o");
							int a = input.nextInt();
						
							if(a == 2) {
								break;
							}
					
					} //while og = 3
					System.out.println("Voltar ao menu principal?1- Sim 2- N�o");
					int a = input.nextInt();
				
					if(a == 1) {
						break;
					}
				
				}// while principal og == 3
				
			}//if og = 3
			
		}//While geral
		
	}//Classe
}//NEW


