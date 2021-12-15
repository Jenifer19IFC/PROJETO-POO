public class TipoDespesa {
	
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		if(categoria.length() > 0)
			this.categoria = categoria;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("-- Categoria: ");
		builder.append(categoria);
		//builder.append("]");
		return builder.toString();
	}
	
	

}
