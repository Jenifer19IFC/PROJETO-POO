public class Conta {
	
	private double saldo;
	protected Usuario usuario;
	private ListReceita lr;
	private ListDespesa ld;
	
	public Conta() {	
		lr = new ListReceita();
		ld = new ListDespesa();
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
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [saldo=");
		builder.append(saldo);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
