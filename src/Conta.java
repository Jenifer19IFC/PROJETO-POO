public class Conta {
	
	private int idConta;
	private double saldo;
	protected Usuario usuario;
	private ListReceita lr;
	private ListDespesa ld;
	private ListUsuario lu;
	private ListConta cl;
	
	public Conta() {	
		lr = new ListReceita();
		ld = new ListDespesa();
		lu = new ListUsuario();
		cl = new ListConta();
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ListReceita getLr() {
		return lr;
	}

	public void setLr(ListReceita lr) {
		this.lr = lr;
	}

	public ListDespesa getLd() {
		return ld;
	}

	public void setLd(ListDespesa ld) {
		this.ld = ld;
	}
	
	public ListUsuario getLu() {
		return lu;
	}

	public void setLu(ListUsuario lu) {
		this.lu = lu;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public void atualizaSaldo() {
		for(int i = 0; i < ld.getLista().size(); i++) {
			saldo = saldo - ld.getLista().get(i).getValor();
		}
		for(int i = 0; i < lr.getLista().size(); i++) {
			saldo = saldo + lr.getLista().get(i).getValor();
		}
	}
	
	public double somaPorCatDespesa(String categoria) {
		double soma = 0;
		for(int i = 0; i < ld.getLista().size(); i++) {
			if(ld.getLista().get(i).getTipoDespesa().getCategoria().equalsIgnoreCase(categoria)) {
				soma = soma + ld.getLista().get(i).getValor();
			}
		}
		return soma;
	}
	
	public double somaPorCatReceita(String categoria) {
		double soma = 0;
		for(int i = 0; i < lr.getLista().size(); i++) {
			if(lr.getLista().get(i).getTipoReceita().getCategoria().equalsIgnoreCase(categoria)) {
				soma = soma + lr.getLista().get(i).getValor();
			}
		}
		return soma;
	}

	public void pesquisaConta(int id) {
        if ( cl != null) {
            boolean achou = false;
            for(int i = 0; i < cl.getLista().size(); i++) {
                if (cl.getLista().get(i).getIdConta() == id) {
                    cl.getLista().get(i);
                    achou = true;
                    System.out.println(cl.getLista().get(i));
                    
                }
            }
            if (!achou) {
                System.out.println("Codigo nao encontrado! ");
            }

        } else {
            System.out.println("Lista vazia");
        }
    }
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [idConta=");
		builder.append(idConta);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", lr=");
		builder.append(lr);
		builder.append(", ld=");
		builder.append(ld);
		builder.append(", lu=");
		builder.append(lu);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
		
	
	

	

}
