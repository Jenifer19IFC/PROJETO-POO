import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Despesa> despesa = new ArrayList<Despesa>();
		
		Endereco e = new Endereco();
		//e.setBairro("Vista Alegre");
		//e.setCidade("Imbuia");
		
		Usuario u = new Usuario();
		//u.setNome("Jênifer");
		//u.setEndereco(e);
		//u.setCpf("109.419.629-03");
		
		Conta c = new Conta();
		//c.setUsuario(u);
		//c.setSaldo(1500);
		
		TipoReceita tr = new TipoReceita();
		//tr.setCategoria("Salário");
		
		TipoDespesa td = new TipoDespesa();
		//td.setCategoria("Alimentação");
		
		//System.out.println(c);
		//System.out.println(tr);
		//System.out.println(td);
		
		System.out.println("\n------ LISTA DE ENDEREÇOS ------\n");
	   
	    ListEndereco enl = new ListEndereco();
		
		e = new Endereco();
		e.setBairro("Vista Alegre");
		e.setCidade("Imbuia");
		enl.add(e);
		
		e = new Endereco();
		e.setBairro("Canoas");
		e.setCidade("Rio do Sul");
		enl.add(e);
		
		enl.gravar();
		
		enl = new ListEndereco();
		
		enl.setLista(enl.ler());
		
	    for (Endereco p : enl.getLista()) {
			System.out.println(p);
		}  
	    
	    System.out.println("\n------ LISTA DE USUÁRIOS ------\n");
	    
	    ListUsuario ul = new ListUsuario();

		u = new Usuario();
		u.setNome("Ana");
		u.setCpf("343.566.666-54");
		u.setEndereco(e);
		ul.add(u);
		
		u = new Usuario();
		u.setNome("Jesiane");
		u.setCpf("243.345.453-00");
		u.setEndereco(e);
		ul.add(u);
		
		
		ul.gravar();
		
		ul = new ListUsuario();
		
		ul.setLista(ul.ler());
		
	    for (Usuario p : ul.getLista()) {
			System.out.println(p);
		}
	    
	    System.out.println("\n------ LISTA DE CONTAS ------\n");
	    
	    ListConta cl = new ListConta();

		c = new Conta();
		c.setSaldo(1200);
		c.setUsuario(u);
		cl.add(c);
		
		cl.gravar();
		
		cl = new ListConta();
		
		cl.setLista(cl.ler());
		
	    for (Conta p : cl.getLista()) {
			System.out.println(p);
		}
	    
	    System.out.println("\n------ LISTA DE TIPOS DE RECEITAS ------\n");
	    
	    ListTipoReceita trecl = new ListTipoReceita();
		
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
		
	    for (TipoReceita p : trecl.getLista()) {
			System.out.println(p);
		}   
	    
	    System.out.println("\n------ LISTA DE TIPOS DE DESPESAS ------\n");
	 
	    ListTipoDespesa tdesl = new ListTipoDespesa();
		
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
		
	    for (TipoDespesa p : tdesl.getLista()) {
			System.out.println(p);
		}   
	    
	    System.out.println("\n------ LISTA DE RECEITAS ------\n");
	    
	    ListReceita l = new ListReceita();
		
		Receita r = new Receita();
		r.setValor(1200);
		r.setData("05/11/2021");
		r.setTipoReceita(trecl.getLista().get(0));
		l.add(r);
		c.setLr(l);
		
		r = new Receita();
		r.setValor(300);
		r.setData("28/10/2021");
		r.setTipoReceita(trecl.getLista().get(1));
		l.add(r);
		c.setLr(l);
		
		r = new Receita();
		r.setValor(200);
		r.setData("29/10/2021");
		r.setTipoReceita(trecl.getLista().get(1));
		l.add(r);
		c.setLr(l);
		
		
		r = new Receita();
		r.setValor(5);
		r.setData("29/10/2021");
		r.setTipoReceita(trecl.getLista().get(2));
		l.add(r);
		c.setLr(l);
		
		l.gravar();
		
		l = new ListReceita();
		
		l.setLista(l.ler());
		
	    for (Receita p : l.getLista()) {
			System.out.println(p);
		}   
	    
	    System.out.println("\n------ LISTA DE DESPESAS ------\n");
	    
	    ListDespesa desl = new ListDespesa();
		
		Despesa d = new Despesa();
		d.setValor(3);
		d.setData("02/11/2021");
		d.setTipoDespesa(tdesl.getLista().get(7));
		desl.add(d);
		c.setLd(desl);
		
		d = new Despesa();
		d.setValor(2);
		d.setData("01/11/2021");
		d.setTipoDespesa(tdesl.getLista().get(4));
		desl.add(d);
		c.setLd(desl);
		
		
		d = new Despesa();
		d.setValor(200);
		d.setData("05/11/2021");
		d.setTipoDespesa(tdesl.getLista().get(7));
		desl.add(d);
		c.setLd(desl);
		
		
		desl.gravar();
		
		desl = new ListDespesa();
		
		desl.setLista(desl.ler());
		
	    for (Despesa p : desl.getLista()) {
			System.out.println(p);
		}   
	    
	    c.atualizaSaldo();
	    System.out.println("\nSALDO ATUAL = " + c.getSaldo());

	    System.out.println("TOTAL DA DEPESA PELA CATEGORIA ESCOLHIDA = R$" + c.somaPorCatDespesa("Outro"));
		System.out.println("TOTAL DA RECEITA PELA CATEGORIA ESCOLHIDA = R$" + c.somaPorCatReceita("Variável"));
		
	 }	
}