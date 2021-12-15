public class Usuario {

		private int idUsuario;
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
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(" -- ID Usuário: ");
			builder.append(idUsuario);
			builder.append(" -- Nome: ");
			builder.append(nome);
			builder.append(" -- CPF: ");
			builder.append(cpf);
			//builder.append(" Endereço: ");
			builder.append(endereco);
			//builder.append(", toString()=");
			//builder.append(super.toString());
			//builder.append("]");
			return builder.toString();
		}
		
		
		
		
		

}

