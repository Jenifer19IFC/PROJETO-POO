public class Usuario {

		private String nome;
		private String cpf;
		protected Endereco endereco;
	
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			if(nome.length() > 0)
				this.nome = nome;
		}
		
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			if(cpf.length() > 0)
				this.cpf = cpf;
		}
		
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Usuario [nome=");
			builder.append(nome);
			builder.append(", cpf=");
			builder.append(cpf);
			builder.append(", endereco=");
			builder.append(endereco);
			builder.append(", toString()=");
			builder.append(super.toString());
			builder.append("]");
			return builder.toString();
	}

}

