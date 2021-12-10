public class Endereco {

	private String bairro;
	private String cidade;
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if(bairro.length() > 0)
			this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		if(cidade.length() > 0)
			this.cidade = cidade;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [rua=");
		builder.append(bairro);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append("]");
		return builder.toString();
	}
	
}

